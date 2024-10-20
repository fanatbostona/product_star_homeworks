package com.example.facade;

import com.example.controller.ContactDTO;
import com.example.manager.Contact;
import com.example.manager.ContactDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ContactFacade {

    private final ContactDAO contactDAO;

    @Autowired
    public ContactFacade(ContactDAO cdao) {
        this.contactDAO = cdao;
    }

    public ContactDTO createContact(String n, String s, String pn, String ea) {
        var account = contactDAO.addContact(n,s,pn,ea);
        return new ContactDTO(account);
    }

    public ContactDTO getContact(long accountId) {
        var contact = contactDAO.getContact(accountId);
        return new ContactDTO(contact);
    }

    public Map<Long, Contact> getContacts() {
        return contactDAO.getContacts();
    }

    public void changeContactInfo(long accountId, String n, String s, String pn, String ea) {
        var contact = contactDAO.getContact(accountId);
        contact.editInformation(n,s,pn,ea);
    }







}
