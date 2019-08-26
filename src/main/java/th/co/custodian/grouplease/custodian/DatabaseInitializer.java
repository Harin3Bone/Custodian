package th.co.custodian.grouplease.custodian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import th.co.custodian.grouplease.custodian.contact.view.ContactEntry;
import th.co.custodian.grouplease.custodian.contact.repository.ContactRepository;
import th.co.custodian.grouplease.custodian.contact.view.ContactTypeEnum;
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
        // Add data to repository
        contactRepository.save(ContactEntry.create(1L, "Harin", "Thananam",
                ContactTypeEnum.TypeA, LocalDate.of(2019,8,1)));
        contactRepository.save(ContactEntry.create(2L, "Naruemol", "Thananam",
                ContactTypeEnum.TypeB,LocalDate.now()));

    }
}
