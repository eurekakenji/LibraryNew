package ee.ivkhkdev;

import ee.ivkhkdev.helpers.*;
import ee.ivkhkdev.interfaces.Input;
import ee.ivkhkdev.interfaces.impl.ConsoleInput;
import ee.ivkhkdev.model.Author;
import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.model.User;
import ee.ivkhkdev.repositories.Repository;
import ee.ivkhkdev.services.AuthorService;
import ee.ivkhkdev.services.UserService;
import ee.ivkhkdev.services.BookService;
import ee.ivkhkdev.storages.Storage;
import java.util.List;
import java.util.Scanner;

public class App {
    private Input input;
    public List<User> users;
    public List<Book> books;
    public List<Author> authors;

    private AppHelper appHelperAuthor;
    private AppHelper appHelperBook;
    private AppHelper appHelperUser;
    private Repository<Author> authorRepository;
    private Repository<User> userRepository;
    private Repository<Book> bookRepository;
    private UserService userService;
    private BookService bookService;
    private AuthorService authorService;

    // Теперь в конструктор передается Input вместо Scanner
    public App() {
        userRepository = new Storage<>("users");
        bookRepository = new Storage<>("books");
        authorRepository = new Storage<>("authors");

        this.users = this.userRepository.load();
        this.authors = this.authorRepository.load();
        this.books = this.bookRepository.load();
        this.input = new ConsoleInput(new Scanner(System.in));

        appHelperUser = new AppHelperUser(input);
        appHelperAuthor = new AppHelperAuthor(input);

        userService = new UserService(users,appHelperUser,userRepository);
        authorService = new AuthorService(authors,appHelperAuthor,authorRepository);
        appHelperBook = new AppHelperBook(input,authorService);
        bookService = new BookService(books,appHelperBook,bookRepository);
    }

    public void run() {
        boolean repeat = true;
        System.out.println("======= JPTV23Library =========");
        do {
            System.out.println("List of tasks:");
            System.out.println("0. Exit program");
            System.out.println("1. Add user");
            System.out.println("2. List of users");
            System.out.println("3. Add book");
            System.out.println("4. List of books");
            System.out.println("5. Add author");
            System.out.print("Enter task number: ");
            int task = Integer.parseInt(input.nextLine()); // Используем input
            switch (task) {
                case 0:
                    System.out.println("exiting program...");
                    repeat = false;
                    break;
                case 1:
                    System.out.println("Adding user");
                    if(userService.add()){
                        System.out.println("User added");
                    }else{
                        System.out.println("Failed to add user");
                    };
                    break;
                case 2:
                    if(userService.printList()){
                        System.out.println("----------- end of list -----------");
                    }
                    break;
                case 3:
                    System.out.println("Adding book");
                    if(bookService.add()){
                        System.out.println("Book addded");
                    }else {
                        System.out.println("Failed to add book");
                    }
                    break;
                case 4:
                    if(bookService.printList()){
                        System.out.println("----------- end of list -----------");
                    }
                    break;
                case 5:
                    System.out.println("Adding author");
                    if(authorService.add()){
                        System.out.println("Added author");
                    }else{
                        System.out.println("Failed to add author");
                    };
                    break;
                default:
                    System.out.println("Pick a number from the list!");
                    break;
            }
            System.out.println("==============================");
        } while (repeat);
        System.out.println("Goodbye! :3");
    }
}