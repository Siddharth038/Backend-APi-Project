package com.example.doctorpatient.service;

import com.example.doctorpatient.entity.Doctor;
import com.example.doctorpatient.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    public List<Doctor> suggestDoctors(String city, String speciality) {
        return doctorRepository.findByCityAndSpeciality(city, speciality);
    }
    public Optional<Doctor> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }
}    
