import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Catalog implements BookOperations {

    private List<Book> books;
    private static final Comparator<Book> YEAR_ORDER;

    static {
        YEAR_ORDER = new Comparator<>() {
            @Override
            public int compare(Book b1, Book b2) {
                return b1.getYear() < b2.getYear() ? -1:
                        b1.getYear() > b2.getYear() ? 1 : 0;
            }
        };
    }

    public Catalog() {
        books = new ArrayList<>();
    }

    @Override
    public void addBook(Book book) {
        books.add(book) ;
    }

    @Override
    public boolean removeBook(String title) {
        return books.remove(searchByTitle(title));
    }

    @Override
    public Book searchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public Book searchByAuthor(String author) {
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public Book searchByPublisher(String publisher) {
        for (Book book : books) {
            if (book.getPublisher().equals(publisher)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public Book searchByYear(int year) {
        for (Book book : books) {
            if (book.getYear() == year) {
                return book;
            }
        }
        return null;
    }

    public List<Book> orderByYear() {
        List<Book> tmp = new ArrayList<>(books);
        Collections.sort(tmp, YEAR_ORDER);
        return tmp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Book b : books) {
            sb.append(b).append("\n");
        }
        return sb.toString();
    }

}
