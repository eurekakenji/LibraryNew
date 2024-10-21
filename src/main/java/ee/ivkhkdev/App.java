package ee.ivkhkdev;

import ee.ivkhkdev.helpers.AppHelperRegisterInput;
import ee.ivkhkdev.helpers.AppHelperUserInput;
import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.model.Register;
import ee.ivkhkdev.model.User;
import ee.ivkhkdev.repository.Repository;
import ee.ivkhkdev.services.BookService;
import ee.ivkhkdev.helpers.AppHelperBookInput;
import ee.ivkhkdev.services.RegisterService;
import ee.ivkhkdev.services.UserService;
import ee.ivkhkdev.storages.Storage;
import ee.ivkhkdev.tools.Input;

import java.util.List;

public class App {
    List<Book> books;
    List<User> users;
    List<Register> registers;

    private final Input input;
    private final Repository<Book> repositoryBook;
    private final Repository<User> repositoryUser;
    private final Repository<Register> repositoryRegister;

    private final BookService bookService;
    private final UserService userService;
    private final RegisterService registerService;
    private final AppHelperBookInput appHelperBookInput;
    private final AppHelperUserInput appHelperUserInput;
    private final AppHelperRegisterInput appHelperRegisterInput;


    public App(Input input) {
        this.input = input;
        this.repositoryBook = new Storage<>("books");
        this.repositoryUser = new Storage<>("users");
        this.repositoryRegister = new Storage<>("register");
        this.appHelperBookInput = new AppHelperBookInput();
        this.appHelperUserInput = new AppHelperUserInput();
        this.appHelperRegisterInput = new AppHelperRegisterInput();
        books = repositoryBook.load();
        this.bookService = new BookService(books, input, appHelperBookInput, repositoryBook);
        this.userService = new UserService(users, input, appHelperUserInput, repositoryUser);
        this.registerService = new RegisterService(books, users, registers, input, repositoryRegister, appHelperRegisterInput);
        users = repositoryUser.load();
        registers = repositoryRegister.load();
    }

    public void run() {
        boolean repeat = true;
        System.out.println("--------------- JKTV23 library --------------");
        do {
            System.out.println("list of tasks: ");
            System.out.println("0. Exit program");
            System.out.println("1. Add book");
            System.out.println("2. Add reader");
            System.out.println("3. List of books");
            System.out.println("4. List of readers");
            System.out.println("5. Give out book");
            System.out.println("6. Return book");
            System.out.print("Pick a task number: ");
            int task = Integer.parseInt(input.nextLine());
            switch (task) {
                case 0:
                    repeat = false;
                    break;
                case 1:
                    if(bookService.addBook()){
                        System.out.println("Book added");
                    } else {
                        System.out.println("Failed to add book");
                    }
                    break;
                case 2:
                    if(userService.addUser()){
                        System.out.println("Reader added");
                    } else {
                        System.out.println("Failed to add reader");
                    }
                    break;
                case 3:
                    bookService.books(books);
                    break;
                case 4:
                    userService.users(users);
                    break;
                case 5:
                    if (registerService.bookBorrow(books, userService, bookService)) {
                        System.out.println("Book borrowed");
                    } else {
                        System.out.println("Failed to borrow book");
                    }
                    break;
                case 6:
                    if (registerService.returnBook(input, registers)) {
                        System.out.println("Book returned");
                    }else{
                        System.out.println("Failed to return book");
                    }
                    break;
                default:
                    System.out.println("Pick a valid task number!");
            }
        }while (repeat);
        System.out.println("Goodbye!");

    }
}