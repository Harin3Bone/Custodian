package th.co.custodian.grouplease.custodian.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/contact")
public class ContactController {
    private ContactService contactService;

    @Autowired
    public ContactController(ContactService theContactService){
        contactService = theContactService;
    }

    @GetMapping()
    public List<ContactEntity> getContactAll(){
        return contactService.getContactAll();
    }

    @GetMapping(path = "/{contactId}")
    public ContactEntity getContactById(@PathVariable long contactId){
        return contactService.getContactById(contactId);
    }

    @PostMapping()
    public ContactEntity createContact(@RequestBody ContactEntity contactEntity){
//        contactEntity.setContactId(0);
        contactService.createContact(contactEntity);
        return contactEntity;
    }
}
