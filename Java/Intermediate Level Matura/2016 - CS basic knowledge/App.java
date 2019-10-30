import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    
    private List<Titanic> data;
    private final String FILENAME;
    private Scanner scanner;
    
    public App() {
        data = new ArrayList<>();
        FILENAME = "titanic.txt";
        scanner = new Scanner(System.in);
    }
        
    public static void main(String[] args) {
        new App().start();
    }
    public void start(){
        // Exercise #1
        readDataFromFile();
        data.forEach(System.out::println);
        
        // Exercise #2
        System.out.println("\nExcersie #2: " + data.size() + " pcs");
        
        // Exercise #3
        System.out.println("Exercise #3: " + numOfPersons());
        
        // Exercise #4
        System.out.print("\nExercise #4: Keyword: ");
        String keyword = scanner.nextLine();
        boolean results = lookForKeyword(keyword);
        System.out.println(results ? "\tResults found!" : "\tResults not found!");
        
        // Exercise #5
        System.out.println("\nExercise #5:");
        if (results) {
            listCategoriesByKeyword(keyword);
        }
        
        // Exercise #6
        List<String> resultList = moreThan60Percent();
        System.out.println("Exercise #6:");
        resultList.forEach(elem -> System.out.println("\t" + elem));
        
        // Exercise #7
        Titanic most = mostSurvivors();
        System.out.println("\nExerxise #7:" + most.getPassengerCategory());
    };
    
    public void readDataFromFile() {
        try (BufferedReader file = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            
            while ( (line = file.readLine()) != null) {
                String[] splittedLine = line.split(";");
                Titanic titanic = new Titanic(splittedLine[0], Integer.parseInt(splittedLine[1]), Integer.parseInt(splittedLine[2]));
                data.add(titanic);
            }            
        } catch (IOException e) {
            System.out.println("Error happened while reading the file: " + e.getMessage());
        }
    }
    
    public int numOfPersons() {
        int sum = 0;
        
        for (Titanic t : data) {
            sum = sum + t.getSurvivors() + t.getMissing();
        }
        
        return sum;
    }
    
    public boolean lookForKeyword(String keyWord) {
        for (Titanic t : data) {
            if (t.getPassengerCategory().contains(keyWord)) {
                return true;
            }
        }
        
        return false;
    }
    
    public void listCategoriesByKeyword(String keyword) {
        for (Titanic t : data) {
            if (t.getPassengerCategory().contains(keyword)) {
                System.out.println(" \t" + t.getPassengerCategory() + " " + (t.getSurvivors() + t.getMissing()));
            }
        }
    } 
    
    public List<String> moreThan60Percent() {
        List<String> results = new ArrayList<>();
        
        for (Titanic t : data) {
            float allPassengers = (float) (t.getSurvivors() + t.getMissing());
            if (t.getMissing() / allPassengers > 0.6 ) {
                results.add(t.getPassengerCategory());
            }
        }
        
        return results;
    }
    
    public Titanic mostSurvivors() {
        Titanic most = data.get(0);
        
        for (int i = 1; i < data.size(); ++i) {
            if (data.get(i).getSurvivors() > most.getSurvivors()) {
                most = data.get(i); 
            }
        }
         
        return most;
    }
    
}
