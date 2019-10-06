public interface BookOperations {

    void addBook(Book book);

    boolean removeBook(String title);

    Book searchByTitle(String title);

    Book searchByAuthor(String author);

    Book searchByPublisher(String publisher);

    Book searchByYear(int year);

}
