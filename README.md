
## 🏥 Doctor-Patient Backend API

Welcome to the Doctor-Patient Backend API! This project provides a backend solution for a platform where doctors can register their patients through a mobile or web portal.

## 🚀 The Task


Build backend APIs to achieve tasks like:

- Adding a doctor & their speciality 🩺
- Adding a patient & their symptom 🏥
- Suggesting the doctor based on patient’s symptom 💡

📋 Doctor’s Entity

In our database, we will have the following details for doctors:

- Name
- City
- Email
- Phone Number
- Speciality

### Cities 🏙️
- Delhi
- Noida
- Faridabad

### Specialities 🩺
- Orthopedic
- Gynecology
- Dermatology
- ENT Specialist

A doctor can be added or removed from the platform.

📋 Patient’s Entity

In our database, we will have the following details for patients:

- Name
- City
- Email
- Phone Number
- Symptom

### Cities 🏙️
- Can have any value

Symptoms 🤒
- Arthritis, Back Pain, Tissue Injuries (Orthopedic)
- Dysmenorrhea (Gynecology)
- Skin Infection, Skin Burn (Dermatology)
- Ear Pain (ENT Specialist)

A patient can be added or removed from the platform.

🛠️ Validations

The following fields should have the mentioned validations at the backend:

- **Name**: At least 3 characters
- **City**: Maximum 20 characters
- **Email**: Valid email address
- **Phone Number**: At least 10 digits

💡 Suggesting Doctors

There will be an API that will accept a patient ID and suggest doctors based on the patient's location and symptom.

### Example 1:
If a patient has Arthritis, all Orthopedic doctors in the patient's location will be suggested.

### Important Note:
This suggesting doctor API is the core evaluating API where the logic needs to be working. The suggested doctor should be based on the symptom of the patient that links to the doctor's speciality.

### Edge-Case 1:
If there isn’t any doctor in that location (outside Delhi, Noida, Faridabad), the response should be:
```
"We are still waiting to expand to your location"
```

### Edge-Case 2:
If there isn’t any doctor for that symptom in that location, the response should be:
```
"There isn’t any doctor present at your location for your symptom"
```
## 🛠️ Technology Stack

- **Spring Boot**: For core functionalities
- **Hibernate**: For database operations

🌟 How to Run the Project

1. Clone the repository
   ```bash
   git clone https://github.com/Siddharth038/Backend-APi-Project.git
   ```
2. Navigate to the project directory
   ```bash
   cd Backend-APi-Project
   ```
3. Build the project
   ```bash
   mvn clean install
   ```
4. Run the application
   ```bash
   mvn spring-boot:run
   ```

## 🤝 Contribution

Feel free to fork this repository and contribute by submitting a pull request. Let's make healthcare management easier together!
