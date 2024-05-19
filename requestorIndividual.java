public class requestorIndividual extends user{
    //this initializes an individual that actually makes the request for blood...
    public requestorIndividual(String name, int age, String email, int contactNumber, int quantityNeeded, String password) {
        super(name, age, email, contactNumber, quantityNeeded,password);
    }
    @Override
    public void requestBlood() {

        System.out.println("Enter the blood group you need:");
        String bloodGroup = input.nextLine();

        blood requestedBlood = new blood(bloodGroup);

        System.out.println("You have requested blood of group " + requestedBlood.getBloodGroup() + ".");
        System.out.println("Please release the requested blood from the storage facility.");

        input.close();
    }
}
