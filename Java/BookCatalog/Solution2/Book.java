import java.util.LinkedHashMap;
import java.util.Map;

public class Book {

    private Map<BookProperties, String>  properties = new LinkedHashMap<>();

    public Book(String title, String author, String publisher, String publishingYear) {
        properties.put(BookProperties.TITLE, title);
        properties.put(BookProperties.AUTHOR, author);
        properties.put(BookProperties.PUBLISHER, publisher);
        properties.put(BookProperties.PUBLISHING_YEAR, publishingYear);
    }

    public Map<BookProperties, String> getProperties() {
        return new LinkedHashMap<BookProperties, String>(properties);
    }

    public void setTitle(String title) {
        properties.put(BookProperties.TITLE, title);
    }

    public void setAuthor(String author) {
        properties.put(BookProperties.AUTHOR, author);
    }

    public void setPublisher(String publisher) {
        properties.put(BookProperties.PUBLISHER, publisher);

    }

    public void setPublishingYear(String publishingYear) {
        properties.put(BookProperties.PUBLISHING_YEAR, publishingYear);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (BookProperties p : properties.keySet()) {
            sb.append(properties.get(p)).append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
