package ee.ivkhkdev;

import ee.ivkhkdev.interfaces.Input;
import ee.ivkhkdev.model.Author;
import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.model.User;
import ee.ivkhkdev.interfaces.Service;;

public class App {
    private Input input;
    private Service<User> userService;
    private Service<Book> bookService;
    private Service<Author> authorService;


    public App(Input input, Service<User> userService,Service<Book> bookService,Service<Author> authorService) {

        this.userService = userService;
        this.authorService = authorService;
        this.bookService = bookService;
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
                    if(userService.print()){
                        System.out.println("----------- end of list -----------");
                    }
                    break;
                case 3:
                    System.out.println("Adding book");
                    if(bookService.add()){
                        System.out.println("Book added");
                    }else {
                        System.out.println("Failed to add book");
                    }
                    break;
                case 4:
                    if(bookService.print()){
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