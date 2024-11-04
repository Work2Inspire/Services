package za.co.protogen.utility;

import za.co.protogen.domain.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class Constant {
    public static List<user> users = new ArrayList<>();
    static {
// Add mock data
        user user1 = new user();
        user1.setId(1L);
        user1.setFirstName("John");
        user1.setLastName("Doe");
        user1.setDateOfBirth(LocalDate.of(1990, 1, 1));
        user1.setRsaId("1234567890123");
        users.add(user1);
        user user2 = new user();
        user2.setId(2L);
        user2.setFirstName("Jane");
        user2.setLastName("Smith");
        user2.setDateOfBirth(LocalDate.of(1985, 6, 15));
        user2.setRsaId("9876543210987");
        users.add(user2);
// Add more users as needed
    }
}
