package com.example.controller;


import com.example.facade.ContactFacade;
import com.example.manager.Contact;
import com.example.manager.InMemoryContactDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private final ContactFacade contactFacade;

    @Autowired
    public ContactController(ContactFacade cf) {
        this.contactFacade = cf;
    }

    @PostMapping
    public ContactDTO createContact(
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String phoneNumber,
            @RequestParam String email
    ) {
        return contactFacade.createContact(name,surname,phoneNumber,email);
    }

    @GetMapping("/{contactID}")
    public ContactDTO getAccount(
            @PathVariable long contactID
    ) {
        return contactFacade.getContact(contactID);
    }

    @GetMapping()
    public Map<Long, Contact> getAccounts() {
        return contactFacade.getContacts();
    }

    @PutMapping("/{contactID}")
    public void changeAccount(
            @PathVariable long contactID,
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String phoneNumber,
            @RequestParam String email
    ) {
        contactFacade.changeContactInfo(contactID,name,surname,phoneNumber,email);
    }

    

}
