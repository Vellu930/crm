package cz.vellus.crmapp3.model;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column
    private String city;
    @Column
    private String country;
    @Column
    private String email;
    @Column
    private String phone;

    public Person() {
    }

    public Person(String name, String city, String country, String email, String phone) {
        this.name = name;
        this.city = city;
        this.country = country;
        this.email = email;
        this.phone = phone;
    }

    public Person(String name) {
        this.setName(name);
    }

    // ------- GETTERS ---------- //
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {return phone; }

    public void setId(Integer id) {
        this.id = id;
    }

    // ------- SETTERS ---------- //
    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}