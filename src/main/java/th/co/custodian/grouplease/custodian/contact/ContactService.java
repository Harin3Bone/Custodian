package th.co.custodian.grouplease.custodian.contact;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    public List<ContactEntity> getContactAll();
    public ContactEntity getContactById(long contactId);
    public void createContact(ContactEntity contactEntity);
}
