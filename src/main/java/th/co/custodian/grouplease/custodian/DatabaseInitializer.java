package th.co.custodian.grouplease.custodian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import th.co.custodian.grouplease.custodian.contact.ContactEntity;
import th.co.custodian.grouplease.custodian.contact.ContactRepository;
import th.co.custodian.grouplease.custodian.contact.ContactTypeEnum;
import th.co.custodian.grouplease.custodian.document.DocumentRepository;
import th.co.custodian.grouplease.custodian.type.ContactTypeEntity;
import th.co.custodian.grouplease.custodian.type.ContactTypeRepository;

import java.time.LocalDate;

@Component
public class DatabaseInitializer implements CommandLineRunner {
    @Autowired
    ContactRepository contactRepository;

    @Autowired
    DocumentRepository documentRepository;

    @Autowired
    ContactTypeRepository contactTypeRepository;

    @Override
    public void run(String... args) throws Exception {
        contactRepository.save(ContactEntity.createFirst(1L, "Harin", "Thananam",
                ContactTypeEnum.TypeA,LocalDate.now()));
        contactRepository.save(ContactEntity.createFirst(2L, "Naruemol", "Thananam",
                ContactTypeEnum.TypeA,LocalDate.of(2019,8,1)));
        contactRepository.save(ContactEntity.createLast(3L,"Somchai","Thananam",
                ContactTypeEnum.TypeB,LocalDate.now().minusDays(8),LocalDate.now()));
    }
}
