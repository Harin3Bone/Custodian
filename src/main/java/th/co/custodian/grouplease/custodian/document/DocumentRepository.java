package th.co.custodian.grouplease.custodian.document;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface DocumentRepository extends JpaRepository<DocumentEntity,Long> {

}
