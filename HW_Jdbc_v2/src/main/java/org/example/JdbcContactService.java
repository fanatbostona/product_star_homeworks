package org.example;

import org.springframework.beans.factory.annotation.Autowired;

import java.nio.file.Path;

public class JdbcContactService implements ContactService {

    private final ContactDao contactDao;
    private final ContactReader contactReader;

    @Autowired
    public JdbcContactService(ContactDao contactDao, ContactReader contactReader) {
        this.contactDao = contactDao;
        this.contactReader = contactReader;
    }

    @Override
    public void saveContacts(Path filePath) {
        var contacts = contactReader.readFromFile(filePath);
        contactDao.saveAll(contacts);
    }
}
