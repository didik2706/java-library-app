package service;

import entity.Book;
import exception.ValidationException;
import repository.BookRepository;
import util.Validator;

public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void getAllBooks() {
        Book[] books = bookRepository.getAll();
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                System.out.println(i + 1 + ". " + books[i].getTitle() + " | Author : " + books[i].getAuthor() );
            }
        }
    }

    @Override
    public void createBook(String title, String author) {
        try {
            // validate input
            Validator.validate(new Book(title, author));

            bookRepository.create(new Book(title, author));
        } catch (ValidationException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void deleteBook(Integer id) {
        boolean isSuccess = bookRepository.delete(id);
        if (isSuccess) {
            System.out.println("Failed delete book");
        } else {
            System.out.println("Failed delete book");
        }
    }
}
