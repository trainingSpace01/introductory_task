package org.example.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "firstname")
    String firstName;

    @Column (name = "lastname")
    String lastName;

    @Column (name = "phonenumber")
    String phoneNumber;

    @Column (name = "companyid")
    Long companyID;
}