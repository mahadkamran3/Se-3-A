import java.util.*;
public class controller {
    Scanner input = new Scanner(System.in);
    private user currentUser;

    public controller() {
        // null value constructor...
    }
    public void datbaseConnection(){
        try {
            DataBase db = new DataBase();
            db.connectingToDataBase("Semester Project OOP-SE-3-A", "postgres", "25082004");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void register() {
        System.out.println("Enter your name:");
        String name = input.nextLine();

        System.out.println("Enter your age:");
        int age = input.nextInt();
        input.nextLine(); // Consume the newline character

        System.out.println("Enter your email:");
        String email = input.nextLine();

        if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            throw new IllegalArgumentException("Invalid email format");
        }

        System.out.println("Enter your password:");
        String password = input.nextLine();

        System.out.println("Are you a donor, individual requester, or a hospital? (donor/individual/hospital):");
        String userType = input.nextLine();

        if (userType.equalsIgnoreCase("donor")) {
            currentUser = new donor(name, age, email, 0, password); // Assuming contact number is not required for registration
            System.out.println("Donor registered successfully!");
        } else if (userType.equalsIgnoreCase("individual")) {
            System.out.println("Enter the quantity of blood needed:");
            int quantityNeeded = input.nextInt();
            input.nextLine(); // Consume the newline character
            currentUser = new user(name, age, email, 0, quantityNeeded, password); // Assuming contact number is not required for registration
            System.out.println("Individual requester registered successfully!");
        } else if (userType.equalsIgnoreCase("hospital")) {
            System.out.println("Enter the hospital name:");
            String hospitalName = input.nextLine();
            System.out.println("Enter the quantity of blood needed:");
            int quantityNeeded = input.nextInt();
            input.nextLine(); // Consume the newline character
            currentUser = new requestorHospital(name, age, email, 0, password, hospitalName, quantityNeeded); // Assuming contact number is not required for registration
            System.out.println("Hospital requester registered successfully!");
        } else {
            System.out.println("Invalid user type. Please choose from donor, individual, or hospital.");
        }
    }

    public void signIn() {
        System.out.println("Enter your email:");
        String email = input.nextLine();

        System.out.println("Enter your password:");
        String password = input.nextLine();

        if (currentUser != null && currentUser.signIn(email, password)) {
            System.out.println("Sign in successful!");
        } else {
            System.out.println("Invalid email or password.");
        }
    }

    public void changePassword() {
        if (currentUser == null) {
            System.out.println("Please sign in first.");
            return;
        }

        System.out.println("Enter your new password:");
        String newPassword = input.nextLine();
        currentUser.resetPassword(newPassword);
        System.out.println("Password changed successfully!");
    }

    public void displayUserInfo() {
        if (currentUser == null) {
            System.out.println("Please sign in first.");
            return;
        }

        currentUser.displayUserInfo();
    }

    public void updateUserInfo() {
        if (currentUser == null) {
            System.out.println("Please sign in first.");
            return;
        }

        System.out.println("Enter your new name:");
        String name = input.nextLine();

        System.out.println("Enter your new age:");
        int age = input.nextInt();
        input.nextLine(); // Consume the newline character

        System.out.println("Enter your new email:");
        String email = input.nextLine();

        System.out.println("Enter your new contact number:");
        int contactNumber = input.nextInt();
        input.nextLine(); // Consume the newline character

        System.out.println("Enter your new organization (enter \"NULL\" if you're an individual):");
        String organization = input.nextLine();

        currentUser.updateUserInfo(name, age, email, contactNumber, organization);
        System.out.println("User information updated successfully!");
    }

    public void donateBlood() {
        if (currentUser == null) {
            System.out.println("Please sign in first.");
            return;
        }

        if (currentUser instanceof donor) {
            ((donor) currentUser).donateBlood();
        } else {
            System.out.println("You are not a registered donor.");
        }
    }

    public void requestBlood() {
        if (currentUser == null) {
            System.out.println("Please sign in first.");
            return;
        }

        currentUser.requestBlood();
    }
}
