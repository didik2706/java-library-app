package repository;

import entity.Book;

public class BookRepositoryImpl implements BookRepository {
    private Book[] books = new Book[10];

    @Override
    public Book[] getAll() {
        return books;
    }

    private boolean isFullBook() {
        boolean isFull = true;
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                isFull = false;
            }
        }

        return isFull;
    }

    private void resizeIsFull() {
        if (isFullBook()) {
            Book[] tempBook = books;
            books = new Book[books.length * 2];

            for (int i = 0; i < books.length; i++) {
                books[i] = tempBook[i];
            }
        }
    }

    @Override
    public void create(Book book) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = book;
                break;
            }
        }
    }

    @Override
    public boolean delete(Integer id) {
        if ((id - 1) > books.length) {
            return false;
        } else if (books[id - 1] == null) {
            return false;
        } else {
            for (int i = (id - 1); i < books.length; i++) {
                if (i == books.length - 1) {
                    books[i] = null;
                } else {
                    books[i] = books[i + 1];
                }
            }

            return true;
        }
    }
}
