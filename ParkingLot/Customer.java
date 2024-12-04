import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Customer extends Person {
    private int license_number;

    public boolean Login(FileHandling fileReader) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String enteredName = input.nextLine().trim();
        System.out.print("Enter your password: ");
        String enteredPassword = input.nextLine().trim();

        List<String> lines = fileReader.readFromFile();
        boolean isValid= false;
        for (String line : lines) {
            String[] parts = line.split(", ");
            if (parts.length == 3) {
                String storedName = parts[0].split(": ")[1].trim();
                String storedPassword = parts[2].split(": ")[1].trim();

                if (storedName.equals(enteredName) && storedPassword.equals(enteredPassword)) {
                    isValid= true;
                    break;
                }
            }
        }

        return(isValid);
    }

    public void Registration(FileHandling fileWrite) {
        String info = "Customer Name: " + getName() + ", ID: " + getId() + ", Password: " + getPassword();
        fileWrite.writeToFile(info);

    }
}