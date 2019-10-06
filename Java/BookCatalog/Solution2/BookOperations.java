public interface BookOperations {

    boolean addBook(Book book);

    boolean removeBook(BookProperties property, String value);

    Book searchByProperty(BookProperties poperty, String value);

}
