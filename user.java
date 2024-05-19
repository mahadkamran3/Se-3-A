import java.util.*;
public class user {
    Scanner input = new Scanner(System.in);

    public String name;
    public int age;
    public String email;
    public int contactNumber;
    public String password;
    public String organization;
    public String hospitalName;
    public int quantityNeeded;

    //constructor to initialize a donor...
    public user(String name, int age, String email, int contactNumber, String password) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.contactNumber = contactNumber;
        this.password = password;
    }
    //in case of an individual patient this constructor is called...
    public user(String name, int age, String email, int contactNumber, int quantityNeeded, String password) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.contactNumber = contactNumber;
        this.quantityNeeded = quantityNeeded;
        this.password = password;
    }
    //in case of the requester is a hospital this constructor is called...
    public user(String name, int age, String email, int contactNumber, String password, String hospitalName, int quantityNeeded) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.contactNumber = contactNumber;
        this.password = password;
        this.hospitalName = hospitalName;
        this.quantityNeeded = quantityNeeded;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }
    public boolean isValidEmail() {
        return email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,}");
    }

    public boolean isValidPassword() {
        return password.length() >= 8;
    }

    public void resetPassword(String newPassword) {
        this.password = newPassword;
    }

    public boolean signIn(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }

    public void displayUserInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        System.out.println("Contact Number: " + contactNumber);
        System.out.println("Organization: " + organization);
    }
    public void updateUserInfo(String name, int age, String email, int contactNumber, String organization) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.contactNumber = contactNumber;
        this.organization = organization;
    }
    public boolean signIn() {
        System.out.println("Enter your email:");
        String emailInput = input.next();

        System.out.println("Enter your password:");
        String passwordInput = input.next();

        return this.email.equals(emailInput) && this.password.equals(passwordInput);
    }

    public void requestBlood() {

        System.out.println("Enter the blood group you need:");
        String bloodGroup = input.nextLine();
    
        blood requestedBlood = new blood(bloodGroup);
    
        System.out.println("You have requested blood of group " + requestedBlood.getBloodGroup() + ".");
        System.out.println("Please release the requested blood from the storage facility.");
    
        input.close();
    }
}
