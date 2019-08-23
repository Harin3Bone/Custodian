package th.co.custodian.grouplease.custodian.contact;

import lombok.Data;

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
    private String contactNumber;

    @NotNull(message = "contact number cannot be null")
    @Column(name = "contact_firstname")
    private String contactFirstName;

    @NotNull(message = "contact number cannot be null")
    @Column(name = "contact_lastname")
    private String contactLastname;

    @NotNull(message = "contact number cannot be null")
    @Enumerated(EnumType.STRING)
    @Column(name = "contact_type")
    private ContactType contactType;

    @NotNull(message = "contact number cannot be null")
    @Column(name = "contact_file")
    private String contactFile;

    @NotNull(message = "contact number cannot be null")
    @Column(name = "contact_reference")
    private String contactRef;
}
