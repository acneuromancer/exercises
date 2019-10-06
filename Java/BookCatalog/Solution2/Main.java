public class Main {

    private static Catalog myCatalog = new Catalog();

    public static void main(String[] args) {
        filldata();

        System.out.println(myCatalog.searchByProperty(BookProperties.TITLE, "The Paul Street Boys"));
        System.out.println("Removing the one published in 1906...");
        System.out.println(myCatalog.removeBook(BookProperties.PUBLISHING_YEAR, "1906"));
        System.out.println(myCatalog);

        for (Book b : myCatalog.orderByYear()) {
            System.out.println(b.getProperties().get(BookProperties.PUBLISHING_YEAR));
        }
	}

	public static void filldata() {
        Book tmpBook = new Book("Fight Club", "Chuck Palhniuk", "A", "1993");
        myCatalog.addBook(tmpBook);

        tmpBook = new Book("The Paul Street Boys", "Ferenc Molnár", "B", "1906");
        myCatalog.addBook(tmpBook);

        tmpBook = new Book("Stars of Eger", "Geza Gardonyi", "C", "1899");
        myCatalog.addBook(tmpBook);

        tmpBook = new Book("I, Robot", "Isaac Asimov", "D", "1950");
        myCatalog.addBook(tmpBook);

        tmpBook = new Book("XXX", "Isaac Asimov", "D", "1950");
        myCatalog.addBook(tmpBook);

        tmpBook = new Book("YYY", "Geza Gardonyi", "C", "1899");
        myCatalog.addBook(tmpBook);
    }

}
