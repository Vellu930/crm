package cz.vellus.crmapp3.model;

import java.util.Date;

public class Email {
    private int number;
    private String senderName;
    private String senderEmail;
    private String subject;
    private String contentBody;
    private String dateSent;


    public Email() {
    }

    public Email(String senderName, String subject, String contentBody, String date) {
        this.senderName = senderName;
        this.subject = subject;
        this.contentBody = contentBody;
        this.dateSent = date;
    }
    // ---------------- GETTERS ----------------------- //

    public int getNumber() {
        return number;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public String getSubject() {
        return subject;
    }

    public String getContentBody() {
        return contentBody;
    }

    public String getDateSent() {
        return dateSent;
    }


    // ---------------- SETTERS ----------------------- //


    public void setNumber(int number) {
        this.number = number;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setContentBody(String contentBody) {
        this.contentBody = contentBody;
    }

    public void setDateSent(String dateSent) {
        this.dateSent = dateSent;
    }
}
