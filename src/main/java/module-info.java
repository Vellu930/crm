module cz.vellus.crmapp3 {
    requires javafx.controls;
    requires javafx.fxml;

    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires java.sql;
    requires java.mail;
    requires com.google.api.client;
    requires com.google.api.client.auth;
    requires com.google.api.client.extensions.java6.auth;
    requires com.google.api.client.extensions.jetty.auth;
    requires google.api.client;
    requires com.google.api.client.json.gson;
    requires google.api.services.gmail.v1.rev110;
    requires com.google.gson;
    requires org.apache.commons.codec;

    opens cz.vellus.crmapp3 to javafx.fxml;
    exports cz.vellus.crmapp3.controller;
    exports cz.vellus.crmapp3;
    opens cz.vellus.crmapp3.controller to javafx.fxml;
    opens cz.vellus.crmapp3.model to org.hibernate.orm.core, javafx.base;

}