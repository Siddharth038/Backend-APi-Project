package com.example.doctorpatient.controller;

import com.example.doctorpatient.entity.Patient;
import com.example.doctorpatient.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping
    public ResponseEntity<Patient> addPatient(@Valid @RequestBody Patient patient) {
        Patient savedPatient = patientService.addPatient(patient);
        return ResponseEntity.ok(savedPatient);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
         Optional<Patient> optionalPationt = patientService.getPatientById(id);
         if (optionalPationt.isPresent()) {
            Patient patient= optionalPationt.get();
            return ResponseEntity.ok(patient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/suggest-doctors")
    public ResponseEntity<Map<String, Object>> suggestDoctors(@PathVariable Long id) {
        Map<String, Object> response = patientService.suggestDoctors(id);
        return ResponseEntity.ok(response);
    }
}
