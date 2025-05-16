package org.example.userService.model;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
public class Employee {
    Long id;
    String firstName;
    String lastName;
    String phoneNumber;
    Long companyID;

    public Employee(Long id, String firstName, String lastName, String phoneNumber, Long companyID) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.companyID = companyID;
    }
}
