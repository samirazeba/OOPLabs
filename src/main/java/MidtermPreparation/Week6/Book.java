package MidtermPreparation.Week6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Book {
    private String title;
    private String name;
    private int year;

    public Book(String title, String name, int year) {
        this.title = title;
        this.name = name;
        this.year = year;
    }

    public String title() {
        return title;
    }
    public String publisher() {
        return name;
    }
    public int year() {
        return year;
    }

    public String toString() {
        return this.title + ", " + this.name + ", " + this.year;
    }
}
class StringUtils {
    public static boolean included (String word, String searched) {
        if (word == null || searched == null) {
            return false;
        }
        String copyOfWord = word;
        copyOfWord = copyOfWord.trim().toUpperCase();
        searched = searched.trim().toUpperCase();

        return copyOfWord.contains(searched);
    }
}
class Library extends StringUtils {
    private List<Book> books = new ArrayList<>();

    public Library () {}

    public void addBook(Book newBook) {
        books.add(newBook);
    }
    public void printBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    //using streams
    public List<Book> searchByTitleStreams(String title) {
        return books.stream()
                .filter(book -> title.equals(book.title()))
                .collect(Collectors.toList());
    }
    public ArrayList<Book> searchByTitle(String title) {
        ArrayList<Book> found = new ArrayList<>();
        for (Book book : books) {
            if (Library.included(book.title(), title)) {
                found.add(book);
            }
        }
        return found;
    }
    public ArrayList<Book> searchByPublisher(String name) {
        ArrayList<Book> found = new ArrayList<>();
        for (Book book : books) {
            if (Library.included(book.publisher(), name)) {
                found.add(book);
            }
        }
        return found;
    }
    public ArrayList<Book> searchByYear(int year) {
        ArrayList<Book> found = new ArrayList<>();
        for (Book book : books) {
            if (year == book.year()) {
                found.add(book);
            }
        }
        return found;
    }
}
class RunLibrary {
    public static void main(String[] args) {
        Book cheese = new Book ("Cheese Problem Solvet", "Woodhead Publishing", 2007);
        System.out.println(cheese.title());
        System.out.println(cheese.publisher());
        System.out.println(cheese.year());

        System.out.println(cheese);

        System.out.println("\nPART 2");
        Library library = new Library();
        library.addBook(cheese);
        Book nhl = new Book("NHL Hockey", "Stanley Kupp", 1952);
        library.addBook(nhl);
        library.addBook(new Book("Battle Axes", "Tom A. Hawk", 1851));
        library.addBook(new Book("The Stinky cheese man and Other Fairly Stupid Tales", "Penguin Group", 1992));

        library.printBooks();

        System.out.println("\nPART 3");
        System.out.println("Streams: " + library.searchByTitleStreams("NHL Hockey"));

        ArrayList<Book> result = library.searchByTitle("CHEESE");
        for (Book book: result) {
            System.out.println(book);
        }

        System.out.println("---");
        for (Book book: library.searchByPublisher("Penguin Group  ")) {
            System.out.println(book);
        }

        System.out.println("---");
        for (Book book: library.searchByYear(1851)) {
            System.out.println(book);
        }

    }
}
