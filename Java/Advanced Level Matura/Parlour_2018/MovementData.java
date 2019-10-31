public class MovementData {

    private int hour;
    private int min;
    private int id;
    private String direction;
    
    public MovementData(int hour, int min, int id, String direction) {
        this.hour = hour;
        this.min = min;
        this.id = id;
        this.direction = direction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return id + " " + hour + " " + min + " " + direction;
    }
    
}
