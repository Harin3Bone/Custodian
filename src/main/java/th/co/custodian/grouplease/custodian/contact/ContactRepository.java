package th.co.custodian.grouplease.custodian.contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ContactRepository extends JpaRepository <ContactEntity,Long> {
}
