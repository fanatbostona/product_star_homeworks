package controller;


import facade.ContactFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return contactFacade.createAccount(name,surname,phoneNumber,email);
    }

    @GetMapping("/{contactID}")
    public ContactDTO getAccount(
            @PathVariable long contactID
    ) {
        return contactFacade.getAccount(contactID);
    }

    

}
