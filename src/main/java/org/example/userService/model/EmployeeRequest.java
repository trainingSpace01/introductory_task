package org.example.userService.model;

import lombok.Data;

@Data
public class EmployeeRequest {
    String firstName;
    String lastName;
    String phoneNumber;
    Long companyID;
}
