import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreatePrescriptionTest {
    @Test
    public void testCreatePrescription() {
        // Prepare the input for the test
        String input = "2\n123456\nTest Prescription\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Redirect console output to capture it
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Run the main method to simulate user interaction
        CreatePrescription.main(new String[0]);

        // Restore standard input and output
        System.setIn(System.in);
        System.setOut(System.out);

        // Verify the output
        String expectedOutput = "Hello!\n" +
                "Select an action:\n" +
                "1. Schedule an appointment\n" +
                "2. View patient profile\n" +
                "Enter patient CPR: \n" +
                "Write prescription (or leave blank to skip): \n" +
                "Prescription written successfully.\n" +
                "You can print it...\n";
        assertEquals(expectedOutput, outputStream.toString());
    }
}
