import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Catalog implements BookOperations{

    private List<Book> bookList;
    private final static BookComparator YEAR_ORDER = new BookComparator();

    public Catalog() {
        bookList = new ArrayList<>();
    }

    @Override
    public boolean addBook(Book book) {
        return bookList.add(book);
    }

    @Override
    public boolean removeBook(BookProperties property, String value) {
        return bookList.remove(searchByProperty(property, value));
    }

    @Override
    public Book searchByProperty(BookProperties property, String value) {
        for (Book book : bookList) {
            if (book.getProperties().get(property).equals(value)) {
                return book;
            }
        }
        System.out.println("No book in the list with " + property.toString() + " " + value);
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Book b : bookList) {
            sb.append(b).append("\n");
        }
        return sb.toString();
    }

    public List<Book> orderByYear() {
        List<Book> tmp = new ArrayList<>(bookList);
        Collections.sort(tmp, YEAR_ORDER);
        return tmp;
    }

}
