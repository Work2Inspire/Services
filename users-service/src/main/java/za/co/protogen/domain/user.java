package za.co.protogen.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;


public class user {
    private long id;
    private String firstName;
    private String LastName;
    private LocalDate dateOfBirth;
    private String rsaID;

    @Override
    public String toString() {
        return "User{Userid='"+id+"', FirstName="+firstName+"', LastName="+LastName+"', RSAid="+rsaID+"', DOB="+dateOfBirth+" }";
    }//For better retrieval

    //getter
    public long getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return LastName;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public String getRsaID() {
        return rsaID;
    }

    //setter
    public void setId(long id) {
        this.id = id;
    }
    public void setRsaId(String rsaID) {
        this.rsaID = rsaID;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
