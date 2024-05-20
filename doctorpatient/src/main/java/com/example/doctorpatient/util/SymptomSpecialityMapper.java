package com.example.doctorpatient.util;

import java.util.HashMap;
import java.util.Map;

public class SymptomSpecialityMapper {
    private static final Map<String, String> symptomToSpecialityMap = new HashMap<>();

    static {
        symptomToSpecialityMap.put("Arthritis", "Orthopedic");
        symptomToSpecialityMap.put("Back Pain", "Orthopedic");
        symptomToSpecialityMap.put("Tissue injuries", "Orthopedic");
        symptomToSpecialityMap.put("Dysmenorrhea", "Gynecology");
        symptomToSpecialityMap.put("Skin infection", "Dermatology");
        symptomToSpecialityMap.put("Skin burn", "Dermatology");
        symptomToSpecialityMap.put("Ear pain", "ENT specialist");
    }

    public static String getSpecialityBySymptom(String symptom) {
        return symptomToSpecialityMap.get(symptom);
    }
}
