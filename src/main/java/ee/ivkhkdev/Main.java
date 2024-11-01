package ee.ivkhkdev;

import ee.ivkhkdev.interfaces.AppHelper;
import ee.ivkhkdev.helpers.AppHelperAuthor;
import ee.ivkhkdev.helpers.AppHelperBook;
import ee.ivkhkdev.helpers.AppHelperUser;
import ee.ivkhkdev.input.ConsoleInput;
import ee.ivkhkdev.interfaces.Input;
import ee.ivkhkdev.model.Author;
import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.model.User;
import ee.ivkhkdev.interfaces.Repository;
import ee.ivkhkdev.repository.Storage;
import ee.ivkhkdev.services.AuthorService;
import ee.ivkhkdev.services.BookService;
import ee.ivkhkdev.interfaces.Service;
import ee.ivkhkdev.services.UserService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Input input = new ConsoleInput(new Scanner(System.in));

        Repository<Author> authorRepository = new Storage<>("authors");
        Repository<User> userRepository = new Storage<>("users");
        Repository<Book> bookRepository = new Storage<>("books");

        List<Author> authors = authorRepository.load();
        List<User> users = userRepository.load();
        List<Book> books = bookRepository.load();

        AppHelper<Author> appHelperAuthor = new AppHelperAuthor(input);
        AppHelper<User> appHelperUser = new AppHelperUser(input);

        Service<Author> authorService = new AuthorService(authors,appHelperAuthor,authorRepository);

        AppHelper<Book> appHelperBook = new AppHelperBook(input, authorService);

        Service<User> userService = new UserService(users,appHelperUser,userRepository);
        Service<Book> bookService = new BookService(books,appHelperBook,bookRepository);

        App app = new App(input, userService, bookService, authorService);
        app.run();
    }
}