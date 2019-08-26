package th.co.custodian.grouplease.custodian.contact.command;

import lombok.Value;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Value
public class AddContactCommand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long contactImageId;

    @NotNull(message = "image file cannot be null")
    @Column
    private byte contactImageName;
}
