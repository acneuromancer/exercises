import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book b1, Book b2) {
        int b1PublishingYear = Integer.valueOf(b1.getProperties().get(BookProperties.PUBLISHING_YEAR));
        int b2PublishingYear = Integer.valueOf(b2.getProperties().get(BookProperties.PUBLISHING_YEAR));

        return Integer.compare(b1PublishingYear, b2PublishingYear);
    }


}
