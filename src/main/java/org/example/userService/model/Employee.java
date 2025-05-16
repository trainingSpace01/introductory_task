package org.example.userService.model;

import lombok.Data;
import lombok.Value;

@Value
public class Employee {
    Long id;
    String firstName;
    String lastName;
    String phoneNumber;
    Long companyID;

    public Employee (){
        this.id = null;
        this.firstName = null;
        this.lastName = null;
        this.phoneNumber = null;
        this.companyID = null;
    }
}
