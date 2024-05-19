import java.util.*;

public class storageFacility {
    private Map<String, Integer> bloodInventory;
    private boolean hasAirConditioner;
    private boolean hasRefrigerator;
    private boolean hasEmergencyGenerator;

    public storageFacility() {
        bloodInventory = new HashMap<>();
        hasAirConditioner = false;
        hasRefrigerator = false;
        hasEmergencyGenerator = false;
    }

    public void addBlood(String bloodGroup, int quantity) {
        bloodInventory.put(bloodGroup, bloodInventory.getOrDefault(bloodGroup, 0) + quantity);
    }

    public int getBloodQuantity(String bloodGroup) {
        return bloodInventory.getOrDefault(bloodGroup, 0);
    }

    public void setAirConditioner(boolean hasAirConditioner) {
        this.hasAirConditioner = hasAirConditioner;
    }

    public void setRefrigerator(boolean hasRefrigerator) {
        this.hasRefrigerator = hasRefrigerator;
    }

    public void setEmergencyGenerator(boolean hasEmergencyGenerator) {
        this.hasEmergencyGenerator = hasEmergencyGenerator;
    }
    //checks if any facaility is needed...
    public void evaluateFacility() {
        Scanner input = new Scanner(System.in);
        System.out.println("Does the storage facility need evaluation? (yes/no)");
        String answer = input.nextLine();

        if (answer.equalsIgnoreCase("yes")) {
            System.out.println("Please provide details of the required products and quantities:");
            System.out.println("Enter product name (or 'done' to finish):");
            String productName = input.nextLine();

            while (!productName.equalsIgnoreCase("done")) {
                System.out.println("Enter quantity:");
                int quantity = input.nextInt();
                input.nextLine(); // Consume the newline character

                System.out.println("Product: " + productName + ", Quantity: " + quantity);

                System.out.println("Enter product name (or 'done' to finish):");
                productName = input.nextLine();
            }
        } else {
            System.out.println("Evaluation not required.");
        }
    }
    //display the facility details...
    public void displayFacilityDetails() {
        System.out.println("Storage Facility Details:");
        System.out.println("Blood Inventory:");
        for (Map.Entry<String, Integer> entry : bloodInventory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("Air Conditioner: " + (hasAirConditioner ? "Available" : "Not Available"));
        System.out.println("Refrigerator: " + (hasRefrigerator ? "Available" : "Not Available"));
        System.out.println("Emergency Generator: " + (hasEmergencyGenerator ? "Available" : "Not Available"));
    }
}