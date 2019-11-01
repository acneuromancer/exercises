public class WordData {

    private String wordToFind;
    private int row;
    private int column;
    private int direction;

    public WordData(String wordToFind, int row, int column, int direction) {
        this.wordToFind = wordToFind;
        this.row = row;
        this.column = column;
        this.direction = direction;
    }

    public String getWordToFind() {
        return wordToFind;
    }

    public void setWordToFind(String wordToFind) {
        this.wordToFind = wordToFind;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return wordToFind + " " + row + " " + column + " " + direction;
    }

}
