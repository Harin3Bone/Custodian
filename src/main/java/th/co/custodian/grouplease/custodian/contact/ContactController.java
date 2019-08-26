package th.co.custodian.grouplease.custodian.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import th.co.custodian.grouplease.custodian.contact.command.AddContactCommand;

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
    public List<ContactEntity> getAllContact(){
        return contactRepository.findAll();
    }

    @GetMapping(path = "/{contactId}")
    public ContactEntity getContactById(@PathVariable long contactId){
        return contactRepository.findById(contactId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ContactEntity addContact(@RequestBody @Valid AddContactCommand command){
        return contactService.createContact(command);
    }
}
