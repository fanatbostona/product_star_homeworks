package org.example;

import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSourceExtensionsKt;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Primary
public class NamedJdbcContactDao implements ContactDao{
    private final NamedParameterJdbcTemplate namedJdbcTemplate;

    public NamedJdbcContactDao(NamedParameterJdbcTemplate namedJdbcTemplate) {
        this.namedJdbcTemplate = namedJdbcTemplate;
    }


    @Override
    public List<Contact> getAllContacts() {
        return namedJdbcTemplate.query(
                "SELECT ID, NAME, SURNAME, PHONE_NUMBER, EMAIL FROM CONTACT ",
                (rs,i) -> new Contact(rs.getLong("ID"),
                        rs.getString("NAME"),
                        rs.getString("SURNAME"),
                        rs.getString("PHONE_NUMBER"),
                        rs.getString("EMAIL"))
        );
    }

    @Override
    public Contact getContact(Long id) {
        return namedJdbcTemplate.queryForObject(
                "SELECT ID, NAME, SURNAME, PHONE_NUMBER, EMAIL FROM CONTACT WHERE ID = :id",
                new MapSqlParameterSource("id", id),
                (rs, i) -> new Contact(rs.getLong("ID"),
                        rs.getString("NAME"),
                        rs.getString("SURNAME"),
                        rs.getString("PHONE_NUMBER"),
                        rs.getString("EMAIL"))
        );
    }

    @Override
    public Contact addContact(String n, String s, String pn, String ea) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedJdbcTemplate.update(
                "INSERT INTO CONTACT(NAME,SURNAME,PHONE_NUMBER,EMAIL) VALUES(:n,:s,:pn,:ea)",
                new MapSqlParameterSource(Map.of("n",n,"s",s,"pn",pn,"ea",ea)),
                keyHolder,
                new String[] { "id" }
        );

        var contactId = keyHolder.getKey().longValue() + 1;
        return new Contact(contactId, n, s, pn, ea);
    }

    @Override
    public void updatePhoneNumber(Long id, String newPN) {
        namedJdbcTemplate.update(
                "UPDATE CONTACT SET PHONE_NUMBER = :newPN WHERE ID = :id",
                new MapSqlParameterSource()
                        .addValue("id", id)
                        .addValue("newPN", newPN)
        );
    }

    @Override
    public void updateEmail(Long id, String newEmail) {
        namedJdbcTemplate.update(
                "UPDATE CONTACT SET EMAIL = :newEmail WHERE ID = :id",
                new MapSqlParameterSource()
                        .addValue("id", id)
                        .addValue("newEmail", newEmail)
        );
    }

    @Override
    public void deleteContact(Long id) {
        namedJdbcTemplate.update(
                "DELETE FROM CONTACT WHERE ID = :id",
                new MapSqlParameterSource("id",id)
        );
    }
}
