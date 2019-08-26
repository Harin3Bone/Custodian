package th.co.custodian.grouplease.custodian.contact.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AbstractAggregateRoot;
import th.co.custodian.grouplease.custodian.contact.command.CreateContactCommand;
import th.co.custodian.grouplease.custodian.contact.event.ContactCreateEvent;
import th.co.custodian.grouplease.custodian.contact.view.ContactTypeEnum;
import th.co.custodian.grouplease.custodian.document.DocumentEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@Data
@Entity(name = "Contact")
@Table(name = "contact")
public class ContactEntity extends AbstractAggregateRoot {
    @Id
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

    @NotNull(message = "contact type cannot be null")
    @Enumerated(EnumType.STRING)
    @Column(name = "contact_type")
    private ContactTypeEnum contactTypeEntity;

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

    public ContactEntity(CreateContactCommand command){
        setContactId(command.getContactImageId());
        registerEvent(new ContactCreateEvent(command.getContactImageId(),command.getContactImageName()));
    }

}
