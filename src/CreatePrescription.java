//USE CASE 2 (CREATE PRESCRIPTIONS)

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Doctor class
 class Doctor {
    private String name;
    private Map<String, String> patientProfiles;

    public Doctor(String name) {
        this.name = name;
        this.patientProfiles = new HashMap<>();
    }

    //viewPatientProfile method
    public void viewPatientProfile(String patientCPR) {
        String profile = patientProfiles.get(patientCPR);
        if (profile != null) {
            System.out.println("Patient Profile:\n" + profile);
        }
        else {
            System.out.println("Patient profile not found.");
        }
    }

    //writePrescription method
    public void writePrescription(String patientCPR, String prescription) {
        patientProfiles.put(patientCPR, prescription);
        System.out.println("Prescription written successfully.\nYou can print it...");
    }

    public String getPatientProfile(String patientCPR) {
        return patientProfiles.get(patientCPR);
    }
}

//the main class
public class CreatePrescription {
    public static void main(String[] args) {
        //a Scanner object is created to read user input
        Scanner scanner = new Scanner(System.in);
        Doctor doctor = new Doctor("Dr. ");  //An instance of the Doctor class is created with "Dr. ".

        //greeting
        System.out.println("Hello!");


        // Prompt the doctor to select an action
        System.out.println("Select an action:");
        System.out.println("1. Schedule an appointment");
        System.out.println("2. View patient profile");

        int action = scanner.nextInt();
        scanner.nextLine(); //to read the input

        switch (action) {
            case 1:
                // Schedule an appointment 
                //in ScheduleAppoitments file (USE-CASE1)
                // ...
                break;
            case 2:
                // View patient profile and write a prescription
                //the program let the doctor/user  enter a patient CPR number, views the patient profile.
                System.out.print("Enter patient CPR: ");
                String patientCPR = scanner.nextLine();
                doctor.viewPatientProfile(patientCPR);

                //then let the doctor/user to write a prescription
                System.out.println("Write prescription (or leave blank to skip): ");
                String prescription = scanner.nextLine();
                if (!prescription.isEmpty()) {
                    doctor.writePrescription(patientCPR, prescription);
                }
                break;
            default:
                System.out.println("Invalid action.");
                break;
        }

        //closing the scanner object
        scanner.close();
    }
}

//Fatema alawi-202005764