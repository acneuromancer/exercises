import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    
    private List<Country> countries;
    
    public Main() {
        countries = new ArrayList<>();
    }
    
    public static void main(String[] args) {
        new Main().start();
    }
    
    public void start() {
        exercise2();
        exercise3();
        exercise4();
        exercise5();
        exercise6();
        exercise7();
        exercise8();
    }

    private void exercise2() {
        try (Scanner scanner = new Scanner(new FileReader("EUcsatlakozas.txt"))) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] split = line.split(";");
                countries.add(new Country(split[0], split[1]));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
//        countries.forEach(System.out::println);
//        
//        countries.forEach(c -> {
//            System.out.println(c.getYear());
//        });
    }

    private void exercise3() {
        System.out.println("Exercise #3: The number of the member countries of the EU: " + countries.size() + " pc(s).");
    }

    private void exercise4() {
        var numOfCountries = 0;
        for (Country country : countries) {
            if (country.getYear() == 2007) {
                ++numOfCountries;
            }
        }
        
        System.out.println("Exercise #4: In 2007 " + numOfCountries + " countries have joined.");
    }

    private void exercise5() {
        for (Country country : countries) {
            if (country.getName().equals("Magyarorsz�g")) {
                System.out.println("Exercise #5: The join date of Hungary: " + country.getDate());
                break;
            }
        }
    }

    private void exercise6() {
        for (Country country : countries) {
            if (country.getName().equals("Magyarorsz�g")) {
                if (Integer.parseInt(country.getDate().substring(5, 7)) == 5) {
                    System.out.println("Exercise #6: The join was in May.");
                }
                break;
            }
        }
    }

    private void exercise7() {
        var latestYear = countries.get(0).getYear();
        var index = 0;
        
        for (int i = 1; i < countries.size(); ++i) {
            if (countries.get(i).getYear() > latestYear) {
                latestYear = countries.get(i).getYear();
                index = i;
            }
        }
        
        System.out.println("Exercise #7: Last joined: " + countries.get(index).getName());
    }

    private void exercise8() {
        Map<Integer, Integer> freq = new TreeMap<>();
        
        for (Country country : countries) {
            int counter =  freq.containsKey(country.getYear()) ? freq.get(country.getYear()) + 1 : 1;
            freq.put(country.getYear(), counter);
        }
        
        for (Integer year : freq.keySet()) {
            System.out.println(year + " - " + freq.get(year));
        }
    }
    
}
