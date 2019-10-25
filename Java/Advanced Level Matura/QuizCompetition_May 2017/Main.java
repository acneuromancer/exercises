import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    
    private static Map<String, Competitor> results = new LinkedHashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    private static char[] solutions;
    
    public static void main(String[] args) {
        firstExercise();
        secondExercise();
        // char[] answers = thirdExercise();
        // fourthExercise(answers);
        // fifthExercise();
        sixthExercise();
        seventhExercise();
        
        scanner.close();
    }
    
    public static void firstExercise() {
        System.out.println("Exercise 1: Input data");
        try ( Scanner sc = new Scanner(new FileReader("valaszok.txt"))) {
            sc.useDelimiter(" ");

            solutions = sc.nextLine().toCharArray();
            System.out.println("Solution: " + new String(solutions));

            while (sc.hasNextLine()) {
                String ID = sc.next();
                sc.skip(sc.delimiter());
                char[] answers = sc.nextLine().toCharArray();
                results.put(ID, new Competitor(ID, answers));
            }
        } catch (IOException e) {
            System.out.println("An error happened while inputting data: " + e.getMessage());
        }
    }
        
    public static void secondExercise() {
        for (String ID : results.keySet()) {
            String answers = new String(results.get(ID).getAnswers());
            System.out.println("Student: " + ID + ", answers: " + answers);
        }
        
        System.out.println("\nExercise 2: " + results.size() + " student(s) took part in the quiz.");
    }
    
    public static char[] thirdExercise() {
        System.out.print("Exercise 3: enter the student's ID = ");
        String ID = scanner.nextLine();        
        char[] answers = results.get(ID).getAnswers();
        System.out.println(new String(answers) + " (the competitor's answers)");
        
        return answers;
    }
 
    public static void fourthExercise(char[] answers) {
        System.out.println("Exercise 4:");
        System.out.println(new String(solutions) + " (the correct solutions)");
        
        for (int i = 0; i < answers.length; ++i) {
            System.out.print(answers[i] == solutions[i] ? "+" : " ");
        }
        System.out.println(" (the competitor's correct answers)");
    }
    
    public static void fifthExercise() {
        System.out.println("Exercise 5: The number of the exercise = ");
        int num = scanner.nextInt();
        --num;
        int count = 0;
        
        for (String ID : results.keySet()) {
            if (results.get(ID).getAnswers()[num] == solutions[num]) {
                ++count;
            }
        }
        
        float percent = (float) count / results.size() * 100;
        System.out.format("%d people, the %.2f%% of the participants answered the exercise correctly.\n", 
                count, percent);
    }
    
    public static void sixthExercise() {
        System.out.println("Exercise 6: Calculate the competitors' scores");

        try ( FileWriter file = new FileWriter("scores.txt")) {
            for (String ID : results.keySet()) {
                int score = 0;
                Competitor currentCompetitor = results.get(ID);
                char[] answers = currentCompetitor.getAnswers();

                for (int i = 0; i < solutions.length; ++i) {
                    if (answers[i] == solutions[i]) {
                        int num = i + 1;
                        if (num <= 5) {
                            score = score + 3;
                        } else if (num >= 6 && num <= 10) {
                            score = score + 4;
                        } else if (num >= 11 && num <= 13) {
                            score = score + 5;
                        } else {
                            score = score + 6;
                        }
                    }
                }

                currentCompetitor.setScore(score);
                System.out.println(currentCompetitor);
                file.write(currentCompetitor.getID() + " " + new String(currentCompetitor.getAnswers()) + "\n");
            }
            
            // Just for test purpose
            System.out.println("JO001: " + results.get("JO001").getScore());
            System.out.println("DG490: " + results.get("DG490").getScore());
            System.out.println("UA889: " + results.get("UA889").getScore());
            System.out.println("FX387: " + results.get("FX387").getScore());
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private static void seventhExercise() {
        List<Competitor> competitors = new ArrayList<>();
        
        for (String ID : results.keySet()) {
            competitors.add(results.get(ID));
        }
        
        competitors.sort(Comparator.comparingInt(Competitor::getScore).reversed());        
       
        System.out.println("The students with the 3 best scores:");
        int numOfBestScores = 1;
        int index = 0;
        while (index < competitors.size() && numOfBestScores <= 3) {
            System.out.println(competitors.get(index).getID() + " " + competitors.get(index).getScore());
            if (competitors.get(index).getScore() == competitors.get(index+1).getScore()) {
                index++;
                continue;
            }
            ++index;
            ++numOfBestScores;
        }
    }
    
    private static class Competitor {
        private String ID;
        private char[] answers;
        private int score;

        public Competitor(String ID, char[] answers) {
            this.ID = ID;
            this.answers = answers;
        }

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public char[] getAnswers() {
            return answers;
        }

        public void setAnswers(char[] answers) {
            this.answers = answers;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }
        
        @Override
        public String toString() {
            return "ID: " + ID + " " + new String(answers) + " " + score;
        }
    }
    
}
