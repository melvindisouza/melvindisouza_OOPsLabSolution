package jan29;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Employee
{
String firstName,lastName, department;
Employee(String fName, String lName)
{
    firstName=fName;
    lastName=lName;
}
}


class CredentialService extends Employee
{
    private String password;
    private String emailAddress;

    CredentialService(String fName, String lName) {
        super(fName, lName);
    }

    public void generatePassword()
    {
        Random random = new Random();
        char[] lowerCase = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char[] number = "0123456789".toCharArray();
        char[] symbols = "!#$%^&*?".toCharArray();
        password =    String.valueOf(lowerCase[random.nextInt(lowerCase.length)])
                    + String.valueOf(upperCase[random.nextInt(upperCase.length)])
                    + String.valueOf(number[random.nextInt(number.length)])
                    + String.valueOf(symbols[random.nextInt(symbols.length)])
                    + String.valueOf(number[random.nextInt(number.length)])
                    + String.valueOf(upperCase[random.nextInt(upperCase.length)])
                    + String.valueOf(symbols[random.nextInt(symbols.length)])
                    +String.valueOf(lowerCase[random.nextInt(lowerCase.length)]);

    }
    public void generateEmailAddress(String fName, String lName, String department)
    {
        emailAddress= fName.toLowerCase(Locale.ROOT)+lName.toLowerCase(Locale.ROOT)+"@"+department.toLowerCase(Locale.ROOT)+".xyz.com";
    }
    public void showCredentials()
    {
        System.out.println(" Dear Melvin your generated credentials are");
        System.out.println(" Email Address: " + emailAddress );
        System.out.println(" Password: " + password );
    }
}

class Application
{
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int department;
        do{
        System.out.println("Please enter the department from the following");
        System.out.println("1. Technical");
        System.out.println("2. HR");
        System.out.println("3. Admin");
        System.out.println("4. Legal");
            department=scanner.nextInt();
            CredentialService cred = new CredentialService("Melvin", "Disouza");
        switch (department){
            case 1:
                cred.department= "technical";
                cred.generateEmailAddress(cred.firstName, cred.lastName, cred.department);
                cred.generatePassword();
                cred.showCredentials();
                break;
            case 2: cred.department= "HR";
                cred.generateEmailAddress(cred.firstName, cred.lastName, cred.department);
                cred.generatePassword();
                cred.showCredentials();
                break;
            case 3: cred.department= "Admin";
                cred.generateEmailAddress(cred.firstName, cred.lastName, cred.department);
                cred.generatePassword();
                cred.showCredentials();
                break;
            case 4: cred.department= "Legal";
                cred.generateEmailAddress(cred.firstName, cred.lastName, cred.department);
                cred.generatePassword();
                cred.showCredentials();
                break;
            default:
                System.out.println("Incorrect input provided");
        }

        }while(department>4);
    }
}


