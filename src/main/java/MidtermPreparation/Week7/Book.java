package MidtermPreparation.Week7;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

record Book(String title, String author, int year, boolean status) {
}
class LibraryCatalog {
    private List<Book> books;

    public LibraryCatalog(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Optional<Book> checkAvailability (String title) {
        return books.stream()
                .filter(book -> book.title().equals(title))
                .findFirst()
                .filter(book -> book.status());
    }
    public Optional<Book> firstAvailable (String author) {
        return books.stream()
                .filter(book -> book.author().equals(author))
                .findFirst();
    }
    public void updateStatus (String title, boolean status) {
        books.stream()
                .filter(book -> book.title().equals(title))
                .findFirst()
                .ifPresent(book ->
                        book = new Book(book.title(), book.author(), book.year(), status));
    }

}
class RunLibrary {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book ("The Great Gatsby", "F. Scott Fitzgerald", 1925, true),
                new Book ("To Kill a Mockingbird", "Harper Lee", 1960, false),
                new Book ("1984", "George Orwell", 1949, true)
        );
        LibraryCatalog lc = new LibraryCatalog(books);

        Optional<Book> availableBook = lc.checkAvailability("1984");
        System.out.println("Is '1984' available? " + availableBook.isPresent());

        Optional<Book> findFirstAvailable = lc.firstAvailable("J.D. Salinger");
        System.out.println("First available book by J.D Salinger: " + findFirstAvailable.orElse(null));

        lc.updateStatus("To Kill a Mockingbird", true);
        System.out.println("Updated availability of 'To Kill a Mockingbird'");

        System.out.println("Updated Book List");
        lc.getBooks().forEach(book -> System.out.println(book.title() + " - Available: " + book.status()));
    }
}