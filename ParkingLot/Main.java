import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Admin p = new Admin();
        Customer c=new Customer();
        FileHandling fileHandling = new FileHandling();
        Scanner input = new Scanner(System.in);
        System.out.print("Are you Admin or Customer: ");
        String position = input.nextLine();

        if(position.equals("Admin")){


            System.out.println("Log in as a Admin:");
            while (true){
                if (p.Login(fileHandling)) {
                    System.out.println("Login successful!");
                    break;
                }
                else {
                    System.out.println("Invalid login. return try...");

                }

            }
        }
        else if(position.equals("Customer")){
            System.out.println("Log in as a customer:");
            if (c.Login(fileHandling)) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Invalid login. Starting registration...");



                System.out.println("Enter your name: ");
                c.setName(input.nextLine());

                while (true) {
                    System.out.print("Enter your Password: ");
                    c.setPassword(input.nextLine());
                    if (c.getPassword().length() < 8) {
                        System.out.println("Password is too short");
                    } else {
                        break;
                    }
                }

                System.out.print("Enter your ID: ");
                c.setId(input.nextInt());

                c.Registration(fileHandling);

                System.out.println("Registration complete!\n");
                input.close();
            }

        }
        else
            System.out.println("Invalid input");




    }
}