package th.co.custodian.grouplease.custodian.contact.command;

import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
public class CreateContactCommand {
    @NotNull
    private long contactImageId;

    @NotNull
    private byte contactImageName;
}
