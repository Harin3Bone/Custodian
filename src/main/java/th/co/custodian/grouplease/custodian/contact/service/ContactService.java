package th.co.custodian.grouplease.custodian.contact.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import th.co.custodian.grouplease.custodian.contact.command.CreateContactCommand;
import th.co.custodian.grouplease.custodian.contact.domain.ContactEntity;
import th.co.custodian.grouplease.custodian.contact.repository.ContactRepository;
import th.co.custodian.grouplease.custodian.contact.view.ContactEntry;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    @Transactional
    public ContactEntity createContact(CreateContactCommand command){
        return contactRepository.save(ContactEntity(command));
    }
}
