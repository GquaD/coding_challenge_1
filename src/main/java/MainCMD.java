import java.io.File;

public class MainCMD {
    //need to place text.txt and runMain.bat files into classes folder
    public static void main(String[] args) {
        File file = new File("text.txt");
        //System.out.println(file.getAbsolutePath());
        MyReader myReader = new MyReader(file);

        Cache cache = new Cache();

        StringBuilder sb = new StringBuilder();
        for (String s : args) sb.append(s).append(" ");

        String input = sb.toString();

        Calculator calculator = new Calculator(myReader, cache, file);

        if (input.equals("exit")) {
            System.out.println("Exited.");
            System.exit(1);
        } else if (!input.startsWith("ccwc")) {
            System.out.println("Not a correct ccwc command.");
            System.exit(1);
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
        } else if (split[1].equals("-c")) {
            calculator.findNumberOfBytes();
            System.out.println(cache.getBytesCount() + " " + file.getName());
        } else if (split[1].equals("-l")) {
            calculator.findNumberOfLines();
            System.out.println(cache.getLinesCount() + " " + file.getName());
        } else if (split[1].equals("-w")) {
            calculator.findNumberOfWords();
            System.out.println(cache.getWordsCount() + " " + file.getName());
        } else if (split[1].equals("-m")) {
            calculator.findNumberOfCharacters();
            System.out.println(cache.getCharsCount() + " " + file.getName());
        } else System.out.println("Not a correct ccwc command.");
    }
}

