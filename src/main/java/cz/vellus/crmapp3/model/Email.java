package cz.vellus.crmapp3.model;

import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

public class Email {
    private long number;
    private String [] senders;
    private String [] receivers;
    private String subject;
    private MimeMultipart mimeMultipart;
    private MimeBodyPart mimeBodyPart;
    private String contentText;

    public Email() {
    }

// ---------------- GETTERS ----------------------- //
    public long getNumber() {
        return number;
    }

    public String[] getSenders() { return senders; }

    public String[] getReceivers() {
        return receivers;
    }

    public String getSubject() {
        return subject;
    }

    public MimeMultipart getMimeMultipart() {
        return mimeMultipart;
    }

    public MimeBodyPart getMimeBodyPart() {
        return mimeBodyPart;
    }

    public String getContentText() {
        return contentText;
    }

// ---------------- SETTERS ----------------------- //
    public void setNumber(long number) {
        this.number = number;
    }

    public void setSenders(String[] senders) {
        this.senders = senders;
    }

    public void setReceivers(String[] receivers) {
        this.receivers = receivers;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setMimeMultipart(MimeMultipart mimeMultipart) {
        this.mimeMultipart = mimeMultipart;
    }

    public void setMimeBodyPart(MimeBodyPart mimeBodyPart) {
        this.mimeBodyPart = mimeBodyPart;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText;
    }
}
