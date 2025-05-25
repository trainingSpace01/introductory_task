package org.example.userService.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee {

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
