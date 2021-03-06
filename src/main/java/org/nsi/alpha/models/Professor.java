package org.nsi.alpha.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by edenasevic on 11/2/16.
 */

@Entity
@Table(name = "PROFESSORS", schema = "NSI01")
public class Professor implements Serializable{
    private static final long serialVersionUID = 1L;

    /*jdbc:oracle:thin:@//80.65.65.66:1521/etflab*/

    @Id
    @Column(name="ID")
    Long id;
    @Column(name="LASTNAME")
    String lastName;
    @Column(name="FIRSTNAME")
    String firstName;
    @Column(name="ADDRESS")
    String address;
    @Column(name="BIRTHDATE")
    Date birthDate;
    @Column(name="PHOTO")
    String photo;
    @Column(name="NOTES")
    String notes;
    @Column(name="YEARSOFEXPERIENCE")
    Integer yearsOfExperience;
    @Column(name="NUMBEROFPUBLICATIONS")
    Integer numberOfPublications;
    @Column(name="NUMBEROFBOOKS")
    Integer numberOfBooks;
    @Column(name="CURRENTCATEGORY")
    Integer currentCategory;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public Integer getNumberOfPublications() {
        return numberOfPublications;
    }

    public void setNumberOfPublications(Integer numberOfPublications) {
        this.numberOfPublications = numberOfPublications;
    }

    public Integer getNumberOfBooks() {
        return numberOfBooks;
    }

    public void setNumberOfBooks(Integer numberOfBooks) {
        this.numberOfBooks = numberOfBooks;
    }

    public Integer getCurrentCategory() {
        return currentCategory;
    }

    public void setCurrentCategory(Integer currentCategory) {
        this.currentCategory = currentCategory;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", address='" + address + '\'' +
                ", birthDate=" + birthDate +
                ", photo='" + photo + '\'' +
                ", notes='" + notes + '\'' +
                ", yearsOfExperience=" + yearsOfExperience +
                ", numberOfPublications=" + numberOfPublications +
                ", numberOfBooks=" + numberOfBooks +
                ", currentCategory=" + currentCategory +
                '}';
    }
}
