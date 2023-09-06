import java.io.File;
import java.util.List;
import java.util.StringTokenizer;

public class Calculator {
    private MyReader myReader;
    private Cache cache;
    private File file;

    public Calculator(MyReader reader, Cache cache, File file) {
        this.myReader = reader;
        this.cache = cache;
        this.file = file;
    }

    public void findNumberOfBytes() {
        if (myReader.isModified()) {
            cache = new Cache();
        }
        if (cache.getBytesCount() == 0) {
            cache.setBytesCount(file.length());
        }
    }

    public void findNumberOfLines() {
        if (myReader.isModified()) {
            cache = new Cache();
        }
        if (cache.getLinesCount() == 0) cache.setLinesCount(myReader.getReader().lines().count());
    }

    public void findNumberOfWords() {
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
    }

    public void findNumberOfCharacters() {
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
    }
}
