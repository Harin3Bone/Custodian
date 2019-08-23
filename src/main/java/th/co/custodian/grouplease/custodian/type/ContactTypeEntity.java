package th.co.custodian.grouplease.custodian.type;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class ContactTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long contactTypeId;

    @NotNull(message = "cannot be null")
    @Column(name = "contact_type")
    private String contactType;

    public static ContactTypeEntity create(String contactType){
        var contactTypeEntity = new ContactTypeEntity();
        contactTypeEntity.setContactType(contactType);
        return contactTypeEntity;
    }
}
