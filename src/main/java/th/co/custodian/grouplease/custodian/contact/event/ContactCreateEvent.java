package th.co.custodian.grouplease.custodian.contact.event;

import lombok.Value;

@Value
public class ContactCreateEvent {
    private long id;
    private byte name;
}
