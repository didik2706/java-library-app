package util;

import entity.Book;
import exception.ValidationException;

public class Validator {
    public static void validate(Book book) throws ValidationException {
        if (book.getTitle().isEmpty() || book.getAuthor().isEmpty()) {
            throw new ValidationException("Title and Book cannot be empty");
        } else if (book.getTitle().isBlank() || book.getAuthor().isBlank()) {
            throw new ValidationException("Title and Book cannot be blank");
        }
    }
}
