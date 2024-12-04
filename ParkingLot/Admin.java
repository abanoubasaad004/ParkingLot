import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Admin extends Person {


    public boolean Login(FileHandling fileReader) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String enteredName = input.nextLine().trim();
        System.out.print("Enter your password: ");
        String enteredPassword = input.nextLine().trim();

        List<String> lines = fileReader.readFromFile();
        boolean isValid = false;

        for (String line : lines) {
            // Check if the line contains admin information
            if (line.contains("Admin Name: ") && line.contains("Password: ")) {
                // Extract the name
                int nameStartIndex = line.indexOf("Admin Name: ") + "Admin Name: ".length();
                int nameEndIndex = line.indexOf(", Password:"); // Assuming the format is "Admin Name: admin, Password: password"
                String storedName = line.substring(nameStartIndex, nameEndIndex).trim();

                // Extract the password
                int passwordStartIndex = line.indexOf("Password: ") + "Password: ".length();
                String storedPassword = line.substring(passwordStartIndex).trim();



                // Check if the entered credentials match the stored credentials
                if (storedName.equals(enteredName) && storedPassword.equals(enteredPassword)) {
                    isValid = true;
                    break;
                }
            }
        }

        return isValid;
    }
}