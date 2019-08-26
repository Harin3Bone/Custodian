package th.co.custodian.grouplease.custodian.contact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import th.co.custodian.grouplease.custodian.contact.view.ContactEntry;

public interface ContactRepository extends JpaRepository <ContactEntry,Long> {

}
