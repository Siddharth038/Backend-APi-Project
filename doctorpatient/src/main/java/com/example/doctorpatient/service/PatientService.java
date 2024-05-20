package com.example.doctorpatient.service;

import com.example.doctorpatient.entity.Patient;
import com.example.doctorpatient.repository.PatientRepository;
import com.example.doctorpatient.repository.DoctorRepository;
import com.example.doctorpatient.entity.Doctor;
import com.example.doctorpatient.util.SymptomSpecialityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

   
    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }
    public Map<String, Object> suggestDoctors(Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new RuntimeException("Patient not found"));
        String symptom = patient.getSymptom();
        String city = patient.getCity();

        String speciality = SymptomSpecialityMapper.getSpecialityBySymptom(symptom);
        if (speciality == null) {
            throw new RuntimeException("Invalid symptom");
        }

        List<Doctor> doctors = doctorRepository.findByCityAndSpeciality(city, speciality);

        Map<String, Object> response = new HashMap<>();
        if (doctors.isEmpty()) {
            if (city.equalsIgnoreCase("Delhi") || city.equalsIgnoreCase("Noida") || city.equalsIgnoreCase("Faridabad")) {
                response.put("message", "There isn’t any doctor present at your location for your symptom");
            } else {
                response.put("message", "We are still waiting to expand to your location");
            }
        } else {
            response.put("doctors", doctors);
        }

        return response;
    }
}
