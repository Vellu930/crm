package cz.vellus.crmapp3.model;

import javax.mail.Message;

public class User {
    private String name;
    private String email;
    private String password;
    private Person[] clients;
    private Event[] events;
    private Task[] tasks;
    private Message[] messages;

    public User(String name, String email, String password, Person[] clients, Event[] events, Task[] tasks, Message[] messages) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.clients = clients;
        this.events = events;
        this.tasks = tasks;
        this.messages = messages;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Person[] getClients() {
        return clients;
    }

    public Event[] getEvents() {
        return events;
    }

    public Task[] getTasks() {
        return tasks;
    }

    public Message[] getMessages() {
        return messages;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setClients(Person[] clients) {
        this.clients = clients;
    }

    public void setEvents(Event[] events) {
        this.events = events;
    }

    public void setTasks(Task[] tasks) {
        this.tasks = tasks;
    }

    public void setMessages(Message[] messages) {
        this.messages = messages;
    }
}
