package th.co.custodian.grouplease.custodian.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    public ContactServiceImpl(ContactRepository theContactRepository){
        contactRepository = theContactRepository;
    }

    @Override
    @Transactional
    public List<ContactEntity> getContactAll() {
        return contactRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<ContactEntity> getContactById(long contactId) {
        return contactRepository.findById(contactId);
    }

    @Override
    @Transactional
    public void createContact(ContactEntity contactEntity) {
        contactRepository.save(contactEntity);
    }
}
