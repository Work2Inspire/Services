package za.co.protogen.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import javax.persistence.Column;
import java.time.LocalDate;

@Entity
@Table(name = "Users")
public class User {
    @Id
    private Long id;
    @Column(name = "First_Name")
    private String firstName;
    @Column(name = "Last_Name")
    private String lastName;
    @Column(name = "Date_Of_Birth")
    private LocalDate dateOfBirth;
    @Column(name = "RSA_ID")
    private String rsaId;

    @Override
    public String toString() {
        return "User{id='"+id+"', FirstName="+firstName+"', LastName="+lastName+"', RSAid="+rsaId+"', DOB="+dateOfBirth+" }";
    }//For better retrieval

    //getter
    public Long getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public String getRsaId() {
        return rsaId;
    }

    //setter
    public void setId(Long id) {
        this.id = id;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public void setRsaId(String rsaId) {
        this.rsaId = rsaId;
    }
}
