package th.co.custodian.grouplease.custodian.document;

import lombok.Data;

import javax.naming.Reference;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.awt.*;

@Entity
@Data
public class DocumentEntity {
    // Specify Document Field
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "document_id")
    private long documentId;

    @NotNull(message = "document name cannot be null")
    @Column(name = "document_name")
    private String documentName;

    @Column(name = "document_reference")
    private String documentReference;


}
