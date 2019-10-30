public class Titanic {
    
    private String passengerCategory;
    private int survivors;
    private int missing;
    
    public Titanic(String passengerCategory, int survivors, int missing) {
        this.passengerCategory = passengerCategory;
        this.survivors = survivors;
        this.missing = missing;
    }

    public String getPassengerCategory() {
        return passengerCategory;
    }

    public void setPassengerCategory(String passengerCategory) {
        this.passengerCategory = passengerCategory;
    }

    public int getSurvivors() {
        return survivors;
    }

    public void setSurvivors(int survivors) {
        this.survivors = survivors;
    }

    public int getMissing() {
        return missing;
    }

    public void setMissing(int missing) {
        this.missing = missing;
    }
    
    @Override
    public String toString() {
        return passengerCategory + " " + survivors + " " + missing;
    }
    
}
