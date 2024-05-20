package com.example.doctorpatient.repository;

import com.example.doctorpatient.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
