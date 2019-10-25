import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    private List<TimedSubtitle> subtitles;
    
    Main() {
        subtitles = new ArrayList<>();
    }
    
    public static void main(String[] args) {
        new Main().start();
    }
    
    public void start() {
        readDataFromFile("feliratok.txt");
        subtitles.forEach(System.out::println);
        
        System.out.println("Exercise 5 - The number of subtitles: " + subtitles.size());
        
        int mostWordsIndex = 0;
        int mostWords = subtitles.get(0).numberOfWords();
        
        for (int i = 1; i < subtitles.size(); ++i) {
            if (subtitles.get(i).numberOfWords() > mostWords) {
                mostWordsIndex = i;
                mostWords = subtitles.get(i).numberOfWords();
            }
        }
        
        System.out.println("The subtitle consisting the most words: " + mostWordsIndex + 
                ", the number of its words: " + mostWords);
        System.out.println(subtitles.get(mostWordsIndex));
        
        for (TimedSubtitle subtitle : subtitles) {
            System.out.println(subtitle.srtTiming());
        }
        
        writeSrt("subtitle.srt");
        
    }
    
    public void readDataFromFile(String fileName) {
        try (Scanner scanner = new Scanner(new FileReader(fileName))) {
            
            while(scanner.hasNextLine()) {
                String time = scanner.nextLine();
                String subtitle = scanner.nextLine();
                subtitles.add(new TimedSubtitle(time, subtitle));
            }
        } catch (IOException e) {
            System.out.println("Exception thrown while reading the file: " + e.getMessage());
        }
    }
    
    public void writeSrt(String fileName) {
        try (FileWriter file = new FileWriter(fileName)) {
            for (int i = 0; i < subtitles.size(); ++i) {
                TimedSubtitle subtitle = subtitles.get(i);
                file.write((i+1) + "\n");
                file.write(subtitles.get(i).srtTiming() + "\n");
                file.write(subtitles.get(i).getSubtitle()+ "\n");
                file.write("\n");
            }
        } catch (IOException e) {
            System.out.println("Exception thrown while writing the file: " + e.getMessage());
        }
    }
    
}
