import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    
    private final String FILE_NAME;
    private List<Cart> carts;
    private Scanner scanner;
    private String good;
    private int numOfPurchase;
    private int pcs;
    
    public Main() {
        FILE_NAME = "penztar.txt";
        carts = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    
    public static void main(String[] args) {
        new Main().start();
    }
    
    public void start() {
       exercise1();
       exercise2();
       exercise3();
       exercise4();
       exercise5();
       exercise6();
       exercise7();
       exercise8();
       scanner.close();
    }

    private void exercise1() {
        try (Scanner sc = new Scanner(new FileReader(FILE_NAME))) {
            while(sc.hasNext()) {
                List<String> items = new ArrayList<>();
                String nextItem;
                while( !(nextItem = sc.nextLine()).equals("F")) {
                    items.add(nextItem);
                }
                Cart temp = new Cart(items);
                carts.add(temp);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
//        for (Cart c : carts) {
//            System.out.println(c);
//        }
    }

    private void exercise2() {
        System.out.println("\nExercies #2");
        System.out.println("The number of checkouts: " + carts.size());
    }

    private void exercise3() {
        System.out.println("\nExercise #3");
        System.out.println("The first customer bought " + carts.get(0).getNumOfItems() + " goods.");
    }

    private void exercise4() {
        System.out.println("\nExercise #4");
        System.out.print("Enter the number of a purchase: ");
        numOfPurchase = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Enter the name of a good: ");
        good = scanner.nextLine();
        
        System.out.print("Enter the bought number of pieces: ");
        pcs = scanner.nextInt();
    }

    private void exercise5() {
        boolean first = true;
        int  counter = 0;
        
        System.out.println("\nExercise #5");
        for (int i = 0; i < carts.size(); ++i) {
            if (carts.get(i).getItems().contains(good)) {
                if (first) {
                    System.out.println("The number of the first purchase: " + (i+1));
                    first = false;
                }
                counter++;
            }
        }
        
        for (int i = carts.size()-1; i >= 0; --i) {
            if (carts.get(i).getItems().contains(good)) {
                System.out.println("The number of the last purchase: " + (i+1));
                break;
            }
        }
        
        System.out.println("It was bought at " + counter + " purchases.");
    }
    
    private void exercise6() {
        System.out.println("\nExercise #6");
        System.out.println("When buying " + pcs  + " pcs, you have to pay " + value(pcs));
    }
    
    private int value(int pcs) {
        if (pcs == 1) {
            return 500;
        }

        if (pcs == 2) {
            return 500 + 450;
        }

        return 500 + 450 + (pcs - 2) * 400;
    }

    private void exercise7() {
        Map<String, Integer> freq = carts.get(numOfPurchase - 1).getFreq();
        for (String item : freq.keySet()) {
            System.out.println(freq.get(item) + " " + item);
        }
    }
    
    private void exercise8() {
        try (FileWriter file = new FileWriter("osszeg.txt")) {
            for (int i = 0; i < carts.size(); ++i) {
                int sum =  0;
                Map<String, Integer> freq = carts.get(i).getFreq();
                for (String item : freq.keySet()) {
                    sum += value(freq.get(item));
                }
                
               String output = "" + (i+1) + " " + sum + "\n";
               file.write(output);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
