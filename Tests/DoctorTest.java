
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.*;

//testing doctor class
class DoctorTest {
        private Doctor doctor;
        private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        doctor = new Doctor("Dr. Ali");
        doctor.writePrescription("1234567890", "Prescription A");
        doctor.writePrescription("9876543210", "Prescription B");
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testViewPatientProfile_existingProfile() {
        // Test viewing an existing patient profile
        String expectedProfile = "Patient Profile:\nPrescription A";
        String patientCPR = "1234567890";

        // Call the method to be tested
        doctor.viewPatientProfile(patientCPR);

        // Get the output from the console
        String consoleOutput = outputStream.toString().trim();

        // Assert that the console output matches the expected profile
        assertEquals(expectedProfile, consoleOutput);
    }

    @Test
    public void testViewPatientProfile_nonExistingProfile() {
        // Test viewing a non-existing patient profile
        String expectedOutput = "Patient profile not found.";
        String patientCPR = "000000000";

        // Call the method to be tested
        doctor.viewPatientProfile(patientCPR);

        // Get the output from the console
        String consoleOutput = outputStream.toString().trim();

        // Assert that the console output matches the expected output
        assertEquals(expectedOutput, consoleOutput);
    }

    @Test
    public void testWritePrescription() {
        // Test writing a prescription
        String expectedOutput = "Prescription written successfully.\nYou can print it...";
        String patientCPR = "2222222222";
        String prescription = "Prescription C";

        // Call the method to be tested
        doctor.writePrescription(patientCPR, prescription);

        // Get the output from the console
        String consoleOutput = outputStream.toString().trim();

        // Assert that the console output matches the expected output
        assertEquals(expectedOutput, consoleOutput);

        // Assert that the prescription is stored correctly
        assertEquals(prescription, doctor.getPatientProfile(patientCPR));
    }
}