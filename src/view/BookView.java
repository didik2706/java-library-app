package view;

import service.BookService;
import util.Input;

public class BookView {
    private BookService bookService;

    public BookView(BookService bookService) {
        this.bookService = bookService;
    }

    public void showAllBooks() {
        System.out.println("==== List of Books ====");
        bookService.getAllBooks();

        // menu
        System.out.println("==== Menu ====");
        System.out.println("1. Create Book");
        System.out.println("2. Delete Book");
        System.out.println("x. Exit");
        String menu = Input.fetchInput("Please choose menu");

        while (true) {
            switch (menu) {
                case "1" -> createNewBook();
                case "2" -> deleteBook();
                case "x" -> System.exit(0);
                default -> showAllBooks();
            }
        }
    }

    public void createNewBook() {
        System.out.println("==== Create New Book ====");
        String title = Input.fetchInput("Input book title");
        String author = Input.fetchInput("Input book author");

        bookService.createBook(title, author);
        System.out.println("New book created successfully");
        showAllBooks();
    }

    public void deleteBook() {
        System.out.println("==== Delete Book ====");
        bookService.getAllBooks();
        String id = Input.fetchInput("Please input book id");

        bookService.deleteBook(Integer.parseInt(id));
        showAllBooks();
    }
}
