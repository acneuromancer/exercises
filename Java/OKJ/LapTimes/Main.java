package laptimes;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    private List<RaceData> races;
    private String racingDriverName;
    
    public Main() {
        races = new ArrayList<>();
    }

    public static void main(String[] args) {
        new Main().start();
    }

    private void start() {
        exercise2();
        exercise3();
        exercise4();
        exercise5();
        exerxise6();
    }

    private void exercise2() {
        try (Scanner scanner = new Scanner(new FileReader("autoverseny.csv"))) {
            scanner.nextLine();
            
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] split = line.split(";");
                RaceData rd = new RaceData(
                        split[0],
                        split[1],
                        Integer.parseInt(split[2]),
                        split[3],
                        split[4],
                        Integer.parseInt(split[5])
                );
                races.add(rd);
            }
            
            // races.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void exercise3() {
        System.out.println("Exercise #3: " + races.size());
    }

    private void exercise4() {
        for (RaceData rd : races) {
            if (rd.getName().equals("Fürge Ferenc") && rd.getRaceTrack().equals("Gran Prix Circuit") && rd.getLap() == 3) {
                System.out.println("Exercise #4: " + rd.getSeconds() + " secs");
            }
        }
    }
    
    private void exercise5() {
        System.out.println("Enter the name of a racing driver:");
        Scanner scanner = new Scanner(System.in);
        racingDriverName = scanner.nextLine();
    }

    private void exerxise6() {
        var raceTrack = "";
        var bestTime = "";
        var bestSecs = Integer.MAX_VALUE;
        
        for (RaceData rd : races) {
            if (rd.getName().equals(racingDriverName)) {
                if (rd.getSeconds() < bestSecs) {
                    raceTrack = rd.getRaceTrack();
                    bestTime = rd.getLapTime();
                    bestSecs = rd.getSeconds();
                }
            }
        }
        
        if (raceTrack == "" ) {
            System.out.println("No such racing driver");
        } else {
            System.out.println("Exercise #6: " + raceTrack + ", " + bestTime);
        }
    }
    
}
