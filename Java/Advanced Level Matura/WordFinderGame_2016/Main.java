import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private List<WordData> wordList;
    private int maxLength;
    private char[][] wordMatrix;

    public Main() {
        wordList = new ArrayList<>();
        wordMatrix = new char[16][16];
    }

    public static void main(String[] args) {
        new Main().start();
    }

    private void start() {
        exercise1();
        exercise2();
        exercise3();
        exercise4();
        exercise5();
        exercise6();
        exercise7();
    }

    private void exercise1() {
        try (Scanner scanner = new Scanner(new FileReader("szavak.txt"))) {
            while(scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] split = line.split("\\*");
                WordData wordData = new WordData(
                        split[0],
                        Integer.parseInt(split[1]),
                        Integer.parseInt(split[2]),
                        Integer.parseInt(split[3])
                );
                wordList.add(wordData);
            }

            wordList.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("An exception has been thrown while reading the file in: " + e.getMessage());
        }
    }

    private void exercise2() {
        System.out.println("\nExercise #1 - number of words: " + wordList.size() + " pcs");
    }

    private void exercise3() {
        maxLength = 0;
        for (WordData wd : wordList) {
            if (wd.getWordToFind().length() > maxLength) {
                maxLength = wd.getWordToFind().length();
            }
        }

        System.out.println("Exercise #2: The length of the longest word: " + maxLength + " pieces of characters.");
    }

    private void exercise4() {
        System.out.println("Exercise #3 - The longest word(s): ");
        for (WordData wd : wordList) {
            if (wd.getWordToFind().length() == maxLength)  {
                System.out.println("\t" + wd.getWordToFind());
            }
        }
    }

    private void exercise5() {
        for (WordData wd : wordList) {
            String currentWord = wd.getWordToFind();
            int row = wd.getRow();
            int col = wd.getColumn();

            for (char letter : currentWord.toCharArray()) {
                wordMatrix[row][col] = letter;

                switch (wd.getDirection()) {
                    case 1:
                        ++col; break;
                    case 2:
                        --row; ++col; break;
                    case 3:
                        --row; break;
                    case 4:
                        --row; --col; break;
                    case 5:
                        --col; break;
                    case 6:
                        ++row; --col; break;
                    case 7:
                        ++row; break;
                    case 8:
                        ++row; ++col;
                }
            }
        }
    }

    private void exercise6() {
        System.out.println("Exercise #5 - Print the words");

        for (int row = 0; row < wordMatrix.length; ++row) {
            for (int col = 0; col < wordMatrix[row].length; ++col) {
                System.out.print(wordMatrix[row][col] == 0 ? '#' : wordMatrix[row][col]);
            }
            System.out.println();
        }
    }

    private void exercise7() {
        Random random = new Random();

        for (int row = 0; row < wordMatrix.length; ++row) {
            for (int col = 0; col < wordMatrix[row].length; ++col) {
                if (wordMatrix[row][col] == 0) {
                    wordMatrix[row][col] = (char) (random.nextInt(122-97+1)+ 97);
                }
            }
        }

        try (FileWriter file = new FileWriter("game.txt")) {
            for (int row = 0; row < wordMatrix.length; ++row) {
                for (int col = 0; col < wordMatrix[row].length; ++col) {
                    file.write(wordMatrix[row][col]);
                }
                file.write('\n');
            }

        } catch (IOException e) {
            System.out.println("An error occured while writing the file out.");
        }
    }

}
