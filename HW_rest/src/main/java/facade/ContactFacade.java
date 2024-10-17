package facade;

import controller.ContactDTO;
import manager.ContactDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactFacade {

    private final ContactDAO contactDAO;

    @Autowired

    public ContactFacade(ContactDAO cdao) {
        this.contactDAO = cdao;
    }

    public ContactDTO createAccount(String n, String s, String pn, String ea) {
        var account = contactDAO.addContact(n,s,pn,ea);
        return new ContactDTO(account);
    }

    public ContactDTO getAccount(long accountId) {
        var account = contactDAO.getContact(accountId);
        return new ContactDTO(account);
    }





}
