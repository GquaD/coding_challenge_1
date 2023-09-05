public class Cache {
    private long bytesCount;
    private long wordsCount;
    private long linesCount;

    private long charsCount;

    public long getCharsCount() {
        return charsCount;
    }

    public void setCharsCount(long charsCount) {
        this.charsCount = charsCount;
    }

    public long getBytesCount() {
        return bytesCount;
    }

    public void setBytesCount(long bytesCount) {
        this.bytesCount = bytesCount;
    }

    public long getWordsCount() {
        return wordsCount;
    }

    public void setWordsCount(long wordsCount) {
        this.wordsCount = wordsCount;
    }

    public long getLinesCount() {
        return linesCount;
    }

    public void setLinesCount(long linesCount) {
        this.linesCount = linesCount;
    }
}
