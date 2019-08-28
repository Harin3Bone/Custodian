package th.co.custodian.grouplease.custodian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import th.co.custodian.grouplease.custodian.contact.ContactEntity;
import th.co.custodian.grouplease.custodian.contact.ContactRepository;
import th.co.custodian.grouplease.custodian.contact.ContactType;
import th.co.custodian.grouplease.custodian.document.DocumentRepository;

import java.time.LocalDate;

@Component
public class DatabaseInitializer implements CommandLineRunner {
    @Autowired
    ContactRepository contactRepository;

    @Autowired
    DocumentRepository documentRepository;

    @Override
    public void run(String... args) throws Exception {
        contactRepository.save(ContactEntity.createFirst(1L, "Harin", "Thananam",
                ContactType.TypeA,LocalDate.now()));
        contactRepository.save(ContactEntity.createFirst(2L, "Naruemol", "Thananam",
                ContactType.TypeA,LocalDate.of(2019,8,1)));
        contactRepository.save(ContactEntity.createLast(3L,"Somchai","Thananam",
                ContactType.TypeB,LocalDate.now().minusDays(8),LocalDate.now()));
    }
}
