package cz.vellus.crmapp3.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
public class Email {
    private int number;
    private String senderName;
    private String senderEmail;
    private String subject;
    private String contentBody;
    private LocalDate dateSent;

    public String dateString() {
        DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
        return dateSent.format(formatter);
    }

}
