package com.example.doctorpatient.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;




@Entity
@Data
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3)
    private String name;

    @NotBlank
    @Pattern(regexp = "Delhi|Noida|Faridabad")
    private String city;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 10)
    private String phone;

    @NotBlank
    @Pattern(regexp = "Orthopedic|Gynecology|Dermatology|ENT specialist")
    private String speciality;
}
