import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        File file = new File("text.txt");
        System.out.println(file.getAbsolutePath());
        MyReader myReader = new MyReader(file);

        Cache cache = new Cache();

        String input = "";

        Calculator calculator = new Calculator(myReader, cache, file);
        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            try {
                input = reader.readLine();
            } catch (IOException e) {
                System.out.println("Error happened: " + e.getLocalizedMessage());
                continue;
            }

            if (input.equals("exit")) {
                System.out.println("Exited.");
                break;
            }

            if (!input.startsWith("ccwc")) {
                System.out.println("Not a correct ccwc command.");
                continue;
            }

            String[] split = input.split(" ");

            if (split.length < 2) {
                if (split.length == 1) {
                    calculator.findNumberOfLines();
                    calculator.findNumberOfWords();
                    calculator.findNumberOfBytes();
                    System.out.println(cache.getLinesCount() + " " + cache.getWordsCount() + " " + cache.getBytesCount() + " " + file.getName());
                } else {
                    System.out.println("Not a correct ccwc command.");
                }
                continue;
            }

            if (split[1].equals("-c")) {
                calculator.findNumberOfBytes();
                System.out.println(cache.getBytesCount() + " " + file.getName());
                continue;
            }

            if (split[1].equals("-l")) {
                calculator.findNumberOfLines();
                System.out.println(cache.getLinesCount() + " " + file.getName());
                continue;
            }

            if (split[1].equals("-w")) {
                calculator.findNumberOfWords();
                System.out.println(cache.getWordsCount() + " " + file.getName());
                continue;
            }

            if (split[1].equals("-m")) {
                calculator.findNumberOfCharacters();
                System.out.println(cache.getCharsCount() + " " + file.getName());
                continue;
            }
            System.out.println("Not a correct ccwc command.");
        }

    }
}

