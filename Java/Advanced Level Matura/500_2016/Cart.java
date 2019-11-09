import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    
    private List<String> items;
    
    public Cart(List<String> items) {
        this.items = items; 
    }
    
    public List<String> getItems() {
        return this.items;
    }
    
    public int getNumOfItems() {
        return this.items.size();
    }
    
    public Map<String, Integer> getFreq() {
        Map<String, Integer> freq = new LinkedHashMap<>();
        
        for (String item : items) {
            int count = freq.containsKey(item) ? freq.get(item) + 1 : 1;
            freq.put(item, count);
        }
        
        return freq;
    }
    
    @Override
    public String toString() {
        return items.toString();
    }
    
}
