package org.nsi.alpha.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "CV", schema = "NSI01")
public class Cv implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    Long id;
    @Column(name = "SURNAME")
    String surname;
    @Column(name = "NAME")
    String name;
    @Column(name = "ADDRESS")
    String address;
    @Column(name = "EMAIL")
    String email;
    @Column(name = "PHOTO")
    String photo;
    @Column(name = "DATE_OF_BIRTH")
    Date dateOfBirth;
    @Column(name = "TELEPHONE")
    Integer telephone;
    @Column(name = "FAX")
    Integer fax;
    @Column(name = "USERNAME")
    String username;

    public Cv() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public Integer getFax() {
        return fax;
    }

    public void setFax(Integer fax) {
        this.fax = fax;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Cv{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", photo='" + photo + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", telephone=" + telephone +
                ", fax=" + fax +
                ", username='" + username + '\'' +
                '}';
    }
}
