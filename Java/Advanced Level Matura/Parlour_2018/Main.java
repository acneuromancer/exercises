
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    private static List<MovementData> movementDataList = new ArrayList<>();
    private static List<Actor> actorList = new ArrayList<>();
    private static int id;
    
    public static void main(String[] args) {
        exercise1();
        exercise2();
        exercise3();
        exercise4();
        exercise5();
        exercise6();
        exercise7();
        exercise8();
    }
    
    private static void exercise1() {
        try (Scanner scanner = new Scanner(new FileReader("ajto.txt"))) {
            while(scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] splitted = line.split(" ");
                movementDataList.add(
                        new MovementData(
                                Integer.parseInt(splitted[0]),
                                Integer.parseInt(splitted[1]),
                                Integer.parseInt(splitted[2]),
                                splitted[3]
                        )
                );
            }
        } catch (IOException e) {
            System.out.println("Exception thrown while reading data: " + e.getMessage());
        }
        
        movementDataList.forEach(System.out::println);
        System.out.println();
    }
    
    private static void exercise2() {
        System.out.println("Exercise #2");
        
        for (MovementData md : movementDataList) {
            if (md.getDirection().equals("be")) {
                System.out.println("First in: " + md.getId());
                break;
            }
        }
       
        for (int i = movementDataList.size() - 1; i >= 0; --i) {
            if (movementDataList.get(i).getDirection().equals("ki")) {
                System.out.println("Last out: " + movementDataList.get(i).getId());
                break;
            }
        }
        
        System.out.println();
    }
    
    private static void exercise3() {
        for (MovementData md : movementDataList) {
            int idx = searchActor(md.getId());
            if (idx == -1) {
                actorList.add(new Actor(md.getId()));
            } else {
                actorList.get(idx).increaseCount();
            }
        }
        
        actorList.sort(Comparator.comparingInt(Actor::getId));
        
        try (FileWriter file = new FileWriter("passing_through.txt")) {
            for (Actor actor : actorList) {
                file.write(actor.getId() + " " + actor.getCount() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Exception thrown while writing the file: " + e.getMessage());
        }
    }
    
    private static int searchActor(int id) {
        for (Actor actor : actorList) {
            if (actor.getId() == id) {
                return actorList.indexOf(actor);
            }
        }
        
        return -1;
    }
    
    private static void exercise4() {
        System.out.println("\nExercise #4");
        System.out.print("Stayed in the parlour at the end: ");
        for (Actor actor : actorList) {
            if (actor.getCount() % 2 != 0) {
                System.out.print(actor.getId() + " ");
            }
        }
        System.out.println();
    }

    private static void exercise5() {
        System.out.println("\nExercise #5");
        
        int max = 0;
        int maxIndex = 0;
        int count = 0;
        
        for (int i = 0; i < movementDataList.size(); ++i) {
            if (movementDataList.get(i).getDirection().equals("be")) {
                ++count;
            } else {
                --count;
            }
            
            if (count > max) {
                max = count;
                maxIndex = i;
            }
        }
        
        MovementData maxData = movementDataList.get(maxIndex);
        
        System.out.println("It was at " + maxData.getHour() + ":" + maxData.getMin() + " when the most people were in the parlour.");
    }
    
    private static void exercise6() {
        System.out.println("\nExercise #6");
        System.out.print("Enter the ID of the person: ");
        Scanner scanner = new Scanner(System.in);
        id = scanner.nextInt();
    }
    
    private static void exercise7() {
        StringBuilder sb = new StringBuilder();
        
        for (MovementData md : movementDataList) {
            if (md.getId() == id) {
                int hour = md.getHour();
                int min = md.getMin();
                sb.append(hour < 10 ? "0" + hour : hour)
                        .append(":")
                        .append(min < 10 ? "0" + min : min);
                
                if (md.getDirection().equals("be")) {
                    sb.append("-");
                } else {
                    sb.append("\n");
                }
            }
        }
        
        System.out.println("\nExercise #7");
        System.out.println(sb);
    }
    
    public static void exercise8() {
        int period = 0;
        int enteringTimeInMinutes = 0;
        boolean isIn = false;
        
        for (MovementData md : movementDataList) {
            if (md.getId() == id) {
                if (md.getDirection().equals("be")) {
                    enteringTimeInMinutes = md.getHour() * 60 + md.getMin();
                    isIn = true;
                } else {
                    int leavingTimeInMinutes = md.getHour() * 60 + md.getMin();
                    period += leavingTimeInMinutes - enteringTimeInMinutes;
                    isIn = false;
                }
            }
        }
        
        if (isIn) {
            period += 15 * 60 - enteringTimeInMinutes;
        }
        
        String message = isIn ? "was" : "was not";
        System.out.println("Exercise #8");
        System.out.println("The observed person spent " + period + " minute(s) inside, he or she " + message + 
                " in the parlour at the end of the observation.");
    }
    
}
