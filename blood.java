import java.time.*;
public class blood {
    public String bloodGroup;
    public String ironLevel;
    public String rhFactor;
    public LocalDate collectionDate;
    public LocalDate expiryDate;
    public boolean isAvailable;
    //constructor to  initialize blood group so that the blood can be stored
    public blood(String bloodGroup, LocalDate collectionDate, LocalDate expiryDate){
        this.bloodGroup = bloodGroup;
        this.collectionDate = collectionDate;
        this.expiryDate = expiryDate;
    }
    //constructor to initialize blood in terms of blood group...
    public blood(String bloodGroup){
        this.bloodGroup = bloodGroup;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public String getIronLevel() {
        return ironLevel;
    }

    public String getRhFactor() {
        return rhFactor;
    }

    public LocalDate getCollectionDate() {  return collectionDate; }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public void setIronLevel(String ironLevel) {
        this.ironLevel = ironLevel;
    }

    public void setRhFactor(String rhFactor) {
        this.rhFactor = rhFactor;
    }
    public void setCollectionDate(LocalDate collectionDate) {
        this.collectionDate = collectionDate;
    }
    public void setExpiryDate(LocalDate expiryDate){
        this.expiryDate = expiryDate;
    }

    public boolean isAvailable(){
        return this.isAvailable;
    }
}