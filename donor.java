import java.util.*;
public class donor extends user{
    public boolean isFitforDonation;
    public boolean isEnoughWeight;
    public donor(String name, int age, String email, int contactNumber, String password){
        super(name, age, email, contactNumber, password);
        this.isFitforDonation = false;
        this.isEnoughWeight = false;
    }
    public void donateBlood(){
        //string that will account for any of the diseases a person might have for stopping him from donating blood...
        String[] diseases = {"any Fever in last 10 days ","hyper tension","HIV/AIDS",
                                "Diabetes", "Chronic Lung disease", "Heart Disease", "Blood Cancer","epilepsy",
                                " any bleeding diseases"};
        String answer;
        try{
            if (age < 18 || age > 65) {
                //if age criteria is not met than exit donation method, person cannot donate blood now...
                System.out.println("You must be between 18 and 65 years old to donate blood.");
                return;
            }
            //check if weight is enough...
            System.out.print("Enter your weight(in kgs): ");
            int weight = input.nextInt();
            if(weight >= 45){
                isEnoughWeight = true;
            }
            //check for diseases...
            for (String disease : diseases) {
                System.out.println("Do you have" + disease + "?(yes/no)");
                answer = input.next();
                if (answer.equalsIgnoreCase("yes")) {
                    System.out.println("Sorry, you are not eligible to donate blood.");
                    isFitforDonation = false;
                    return;
                }
            }
        }
        catch (NumberFormatException | InputMismatchException e){
            System.out.println("Following exception occured: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
