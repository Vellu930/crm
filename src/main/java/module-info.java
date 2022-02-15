module cz.vellus.crmapp3 {
    requires javafx.controls;
    requires javafx.fxml;

    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires java.sql;

    opens cz.vellus.crmapp3 to javafx.fxml;
    exports cz.vellus.crmapp3.controller;
    exports cz.vellus.crmapp3;
    opens cz.vellus.crmapp3.controller to javafx.fxml;
    opens cz.vellus.crmapp3.model to org.hibernate.orm.core, javafx.base;

}