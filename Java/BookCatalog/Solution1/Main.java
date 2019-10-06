public class Main {
    private static Catalog myCatalog = new Catalog();

    public static void main(String[] args) {
        fillData();
        System.out.println(myCatalog);


        for (Book b : myCatalog.orderByYear()) {
            System.out.println(b.getYear());
        }

        myCatalog.removeBook("XXX");
        System.out.println(myCatalog);
    }

    public static void fillData() {
        Book tmpBook = new Book("Fight Club", "Chuck Palhniuk", "A", 1993);
        myCatalog.addBook(tmpBook);
        tmpBook = new Book("The Paul Street Boys", "Ferenc Molnár", "B", 1906);
        myCatalog.addBook(tmpBook);
        tmpBook = new Book("Stars of Eger", "Geza Gardonyi", "C", 1899);
        myCatalog.addBook(tmpBook);
        tmpBook = new Book("I, Robot", "Isaac Asimov", "D", 1950);
        myCatalog.addBook(tmpBook);
        tmpBook = new Book("XXX", "Isaac Asimov", "D", 1950);
        myCatalog.addBook(tmpBook);
        tmpBook = new Book("YYY", "Geza Gardonyi", "C", 1899);
        myCatalog.addBook(tmpBook);
    }
}
