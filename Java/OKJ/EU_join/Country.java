public class Country {
    private String name;
    private String date;
    
    public Country(String countryName, String yearOfJoining) {
        this.name = countryName;
        this.date = yearOfJoining;
    }

    public String getName() {
        return name;
    }

    public void setName(String countryName) {
        this.name = countryName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String yearOfJoining) {
        this.date = yearOfJoining;
    }
    
    public int getYear() {
        return Integer.parseInt(date.substring(0, 4));
    }
    
    @Override
    public String toString() {
        return name + " " + date;
    }
    
}
