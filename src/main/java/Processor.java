import java.io.File;

public class Processor {

    public void process(String[] arr) {
        validateParams(arr);

        File file = new File(arr.length > 1 ? arr[1] : arr[0]);
        Cache cache = new Cache();
        Calculator calculator = new Calculator(new MyReader(file), cache, file);

        if (arr[0].contains(".")) {
            calculator.findNumberOfLines();
            calculator.findNumberOfWords();
            calculator.findNumberOfBytes();
            System.out.println(cache.getBytesCount() + " " + cache.getLinesCount() + " " + cache.getWordsCount() + " " + file.getName());
        } else if (arr[0].equals("-c")) {
            calculator.findNumberOfBytes();
            System.out.println(cache.getBytesCount() + " " + file.getName());
        } else if (arr[0].equals("-l")) {
            calculator.findNumberOfLines();
            System.out.println(cache.getLinesCount() + " " + file.getName());
        } else if (arr[0].equals("-w")) {
            calculator.findNumberOfWords();
            System.out.println(cache.getWordsCount() + " " + file.getName());
        } else if (arr[0].equals("-m")) {
            calculator.findNumberOfCharacters();
            System.out.println(cache.getCharsCount() + " " + file.getName());
        } else System.out.println("Not a correct ccwc command.");
    }

    private void validateParams(String[] arr) {
        if (arr.length == 0) {
            printAndExit("Not a correct ccwc command.");
        }
        if (arr.length == 1 && !arr[0].contains(".")) {
            printAndExit("Not a correct ccwc command: File address missed.");
        }
        if (arr[0].contains("exit")) {
            printAndExit("Exited.");
        }
    }

    private void printAndExit(String msg) {
        System.out.println(msg);
        System.exit(1);
    }

}
