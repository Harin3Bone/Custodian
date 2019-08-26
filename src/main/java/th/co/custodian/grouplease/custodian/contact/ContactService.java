package th.co.custodian.grouplease.custodian.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import th.co.custodian.grouplease.custodian.contact.command.AddContactCommand;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    @Transactional
    public ContactEntity createContact(AddContactCommand command){
        return null;
//        return contactRepository.save(new ContactEntity(command));
    }
}
