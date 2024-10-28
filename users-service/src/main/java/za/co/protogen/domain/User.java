package za.co.protogen.domain;

import java.time.LocalDate;

public class User {
    private long id;
    private String firstName;
    private String LastName;
    private LocalDate dateOfBirth;
    private String rsaID;

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
