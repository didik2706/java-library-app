package repository;

import entity.Book;

public interface BookRepository {
    Book[] getAll();
    void create(Book book);
    boolean delete(Integer id);
}
