package th.co.custodian.grouplease.custodian.contact;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import th.co.custodian.grouplease.custodian.document.DocumentEntity;
import th.co.custodian.grouplease.custodian.type.ContactTypeEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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

    // Specify Method
//    public static ContactEntity create(long contactNumber,String contactFirstName,String contactLastname,
//                                       ContactTypeEnum contactTypeEnum){
//        var contactEntity = new ContactEntity();
//        contactEntity.setContactNumber(contactNumber);
//        contactEntity.setContactFirstName(contactFirstName);
//        contactEntity.setContactLastname(contactLastname);
//        contactEntity.setContactTypeEnum(contactTypeEnum);
//        return contactEntity;
//    }

    public static ContactEntity create(long contactNumber,String contactFirstName,String contactLastname,
                                       ContactTypeEntity contactTypeEntity){
        var contactEntity = new ContactEntity();
        contactEntity.setContactNumber(contactNumber);
        contactEntity.setContactFirstName(contactFirstName);
        contactEntity.setContactLastname(contactLastname);
        contactEntity.setContactTypeEntity(contactTypeEntity);
        return contactEntity;
    }

}
