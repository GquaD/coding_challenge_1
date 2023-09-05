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
                System.out.println("Not a correct ccwc command.");
                continue;
            }

            if (split[1].equals("-c")) {
                if (myReader.isModified()) {
                    cache = new Cache();
                }
                if (cache.getBytesCount() == 0) {
                    cache.setBytesCount(file.length());
                }

                System.out.println(cache.getBytesCount() + " " + file.getName());
                continue;
            }

            if (split[1].equals("-l")) {
                if (myReader.isModified()) {
                    cache = new Cache();
                }
                if (cache.getLinesCount() == 0) cache.setLinesCount(myReader.getReader().lines().count());
                System.out.println(cache.getLinesCount() + " " + file.getName());
                continue;
            }

            if (split[1].equals("-w")) {
                if (myReader.isModified()) {
                    cache = new Cache();
                }
                long count = 0;
                if (cache.getWordsCount() == 0) {
                    List<String> list = myReader.getReader().lines().toList();
                    for (String s : list) {
                        StringTokenizer st = new StringTokenizer(s);
                        int tokensNum = st.countTokens();
                        count += tokensNum;
                    }
                    cache.setWordsCount(count);
                }
                System.out.println(cache.getWordsCount() + " " + file.getName());
                continue;
            }

            if (split[1].equals("-m")) {
                if (myReader.isModified()) {
                    cache = new Cache();
                }
                long count = 0;
                if (cache.getWordsCount() == 0) {
                    List<String> list = myReader.getReader().lines().toList();
                    for (String s : list) {
                        count += s.length();
                    }
                    cache.setCharsCount(count);
                }
                System.out.println(cache.getCharsCount() + " " + file.getName());
                continue;
            }
            System.out.println("Not a correct ccwc command.");
        }

    }
}

