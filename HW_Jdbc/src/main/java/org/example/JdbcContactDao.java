package org.example;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcContactDao implements ContactDao{
    private static final String GET_CONTACT_SQL = "" +
            "SELECT" +
            "ID, " +
            "NAME, " +
            "SURNAME, " +
            "PHONE_NUMBER, " +
            "EMAIL " +
            "FROM CONTACT " +
            "WHERE ID = ?";

    private static final String GET_ALL_CONTACTS_SQL = "" +
            "SELECT" +
            "ID, " +
            "NAME, " +
            "SURNAME, " +
            "PHONE_NUMBER, " +
            "EMAIL " +
            "FROM CONTACT ";


    private static final String CREATE_CONTACT_SQL = "" +
            "INSERT INTO CONTACT(NAME,SURNAME,PHONE_NUMBER,EMAIL)" +
            "VALUES(?,?,?,?)";

    private static final String SET_PHONE_NUMBER_SQL = "" +
            "UPDATE CONTACT " +
            "SET PHONE_NUMBER = ? " +
            "WHERE ID = ?";

    private static final String SET_EMAIL_SQL = "" +
            "UPDATE CONTACT " +
            "SET EMAIL = ? " +
            "WHERE ID = ?";

    private static final String DELETE_CONTACT_SQL = "" +
            "DELETE FROM CONTACT" +
            "WHERE ID = ?";


    private static final RowMapper<Contact> CONTACT_ROW_MAPPER =
            (rs,i) -> new Contact(rs.getLong("ID"),
                    rs.getString("NAME"),
                    rs.getString("SURNAME"),
                    rs.getString("PHONE_NUMBER"),
                    rs.getString("EMAIL"));


    private final JdbcTemplate jdbcTemplate;

    public JdbcContactDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Contact> getAllContacts() {
        return jdbcTemplate.query(
                GET_ALL_CONTACTS_SQL,
                CONTACT_ROW_MAPPER
        );
    }

    @Override
    public Contact getContact(Long id) {
        return jdbcTemplate.queryForObject(
                GET_CONTACT_SQL,
                CONTACT_ROW_MAPPER,
                id
        );
    }

    @Override
    public Contact addContact(String n, String s, String pn, String ea) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(
                con ->  {
                    var ps = con.prepareStatement(CREATE_CONTACT_SQL, new String[] {"id"});
                    ps.setString(1,n);
                    ps.setString(2,s);
                    ps.setString(3,pn);
                    ps.setString(4,ea);
                    return ps;
                },
                keyHolder
        );

        var accountId = keyHolder.getKey().longValue();
        return new Contact(accountId, n, s, pn, ea);
    }

    @Override
    public void updatePhoneNumber(Long id, String newPN) {
        jdbcTemplate.update(
                SET_PHONE_NUMBER_SQL,
                newPN,
                id
        );
    }

    @Override
    public void updateEmail(Long id, String newEmail) {
        jdbcTemplate.update(
                SET_EMAIL_SQL,
                newEmail,
                id
        );
    }

    @Override
    public void deleteContact(Long id) {
        jdbcTemplate.update(
                DELETE_CONTACT_SQL,
                id
        );
    }
}
