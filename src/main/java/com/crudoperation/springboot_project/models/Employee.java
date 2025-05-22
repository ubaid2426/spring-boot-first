package com.crudoperation.springboot_project.models;
import jakarta.validation.constraints.NotBlank;
//package com.crudoperation.springboot_project.payload;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name")
    //first name validate
//    @NotBlank(message = "First name is required")
    @NotBlank(message = "First name is required")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email_id")
    private String emailId;

    // Getters and setters
//    public String getFirstName() {
//        return firstName;
//    }

}
