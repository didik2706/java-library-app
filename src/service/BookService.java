package service;

public interface BookService {
    void getAllBooks();
    void createBook(String title, String author);
    void deleteBook(Integer id);
}
