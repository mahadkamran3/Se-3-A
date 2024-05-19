public class requestorHospital extends user{
    //if a hospital requests blood then it is initialized as per this constructor...
    public requestorHospital(String name, int age, String email, int contactNumber, String password, String hospitalName, int quantityNeeded){
        super(name, age, email, contactNumber, password, hospitalName,quantityNeeded);
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
