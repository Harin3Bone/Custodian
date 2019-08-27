package th.co.custodian.grouplease.custodian.contact;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import th.co.custodian.grouplease.custodian.document.DocumentEntity;
import th.co.custodian.grouplease.custodian.type.ContactTypeEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
public class ContactEntity {
    // Specify Field
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private long contactId;

    @NotNull(message = "contact number cannot be null")
    @Column(name = "contact_number")
    private long contactNumber;

    @NotNull(message = "contact number cannot be null")
    @Column(name = "contact_firstname")
    private String contactFirstName;

    @NotNull(message = "contact number cannot be null")
    @Column(name = "contact_lastname")
    private String contactLastname;

//    @NotNull(message = "contact number cannot be null")
//    @Enumerated(EnumType.STRING)
//    @Column(name = "contact_type")
//    private ContactTypeEnum contactTypeEnum;

    @JsonIgnore
    @NotNull(message = "contact type cannot be null")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_type")
    private ContactTypeEntity contactTypeEntity;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_id")
    private DocumentEntity documentEntity;

    @CreatedDate
    @NotNull(message = "create date cannot be null")
    @Column(name = "contact_createDate")
    private LocalDate contactCreateDate;

    @LastModifiedDate
    @Column(name = "contact_updateDate")
    private LocalDate contactUpdateDate;

    public static ContactEntity create(long contactNumber, String contactFirstName, String contactLastname,
                                       ContactTypeEntity contactTypeEntity, LocalDate contactCreateDate){
        var contactEntity = new ContactEntity();
        contactEntity.setContactNumber(contactNumber);
        contactEntity.setContactFirstName(contactFirstName);
        contactEntity.setContactLastname(contactLastname);
        contactEntity.setContactTypeEntity(contactTypeEntity);
        contactEntity.setContactCreateDate(contactCreateDate);
        return contactEntity;
    }

}
