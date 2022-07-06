package org.studentProfile.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "student")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "age")
    private  Integer age;

    @Column(name = "notionalCode")
    private Long notionalCode;

    @Column(name = "bornDate")
    private Date bornDate;

    @Column(name = "fatherName")
    private String fathername;



}
