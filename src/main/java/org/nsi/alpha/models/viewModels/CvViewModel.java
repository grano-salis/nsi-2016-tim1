package org.nsi.alpha.models.viewModels;


import org.nsi.alpha.models.Cv;

import java.util.Date;

public class CvViewModel {

    Long id;
    String surname;
    String name;
    String address;
    String email;
    String photo;
    Date dateOfBirth;
    Integer telephone;
    Integer fax;

    public CvViewModel(Cv cv) {
        id = cv.getId();
        surname = cv.getSurname();
        name = cv.getName();
        address = cv.getAddress();
        email = cv.getEmail();
        photo = cv.getPhoto();
        dateOfBirth = cv.getDateOfBirth();
        telephone = cv.getTelephone();
        fax = cv.getFax();
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

    @Override
    public String toString() {
        return "CvViewModel{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", photo='" + photo + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", telephone=" + telephone +
                ", fax=" + fax +
                '}';
    }
}
