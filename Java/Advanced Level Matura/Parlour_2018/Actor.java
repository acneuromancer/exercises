public class Actor {

    private int Id;
    private int count;
    
    public Actor(int Id) {
        this.Id = Id;
        this.count = 1;
    }
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void increaseCount() {
        ++this.count;
    }
    
    @Override
    public String toString() {
        return Id + ": " + count;
    }
    
}
