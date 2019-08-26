package th.co.custodian.grouplease.custodian.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import th.co.custodian.grouplease.custodian.contact.command.CreateContactCommand;
import th.co.custodian.grouplease.custodian.contact.view.ContactEntry;
import th.co.custodian.grouplease.custodian.contact.repository.ContactRepository;
import th.co.custodian.grouplease.custodian.contact.service.ContactService;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequestMapping(path = "/contact")
public class ContactController {
    @Autowired
    ContactService contactService;

    @Autowired
    ContactRepository contactRepository;

    @GetMapping()
    public List<ContactEntry> getAllContact(){
        return contactRepository.findAll();
    }

    @GetMapping(path = "/{contactId}")
    public ContactEntry getContactById(@PathVariable long contactId){
        return contactRepository.findById(contactId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ContactEntry addContact(@RequestBody @Valid CreateContactCommand command){
        return contactService.createContact(command);
    }
}
