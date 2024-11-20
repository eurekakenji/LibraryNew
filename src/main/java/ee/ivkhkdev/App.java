package ee.ivkhkdev;

import ee.ivkhkdev.interfaces.Input;
import ee.ivkhkdev.model.Author;
import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.model.LibraryCard;
import ee.ivkhkdev.model.User;
import ee.ivkhkdev.interfaces.Service;
import ee.ivkhkdev.services.LibraryCardService;

public class App {
    private final Service<LibraryCard> libraryCardService;
    private Input input;
    private Service<User> userService;
    private Service<Book> bookService;
    private Service<Author> authorService;

    public App(Input input, Service<Book> bookService, Service<User> userService, Service<Author> authorService, Service<LibraryCard> libraryCardService) {
        this.input = input;
        this.bookService = bookService;
        this.userService = userService;
        this.authorService = authorService;
        this.libraryCardService = libraryCardService;
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
            System.out.println("6. Borrow book");
            System.out.println("7. Return book");
            System.out.println("8. Edit book");
            System.out.println("9. Edit user");
            System.out.print("Enter number from list: ");
            int task = Integer.parseInt(input.nextLine()); // Используем input
            switch (task) {
                case 0:
                    System.out.println("Exiting program...");
                    repeat = false;
                    break;
                case 1:
                    System.out.println("Adding user...");
                    if(userService.add()){
                        System.out.println("User added");
                    }else{
                        System.out.println("Was unable to add user");
                    };
                    break;
                case 2:
                    if(userService.print()){
                        System.out.println("----------- End of list -----------");
                    }
                    break;
                case 3:
                    System.out.println("Adding book...");
                    if(bookService.add()){
                        System.out.println("Book added");
                    }else {
                        System.out.println("Was unable to add book");
                    }
                    break;
                case 4:
                    if(bookService.print()){
                        System.out.println("----------- End of list -----------");
                    }
                    break;
                case 5:
                    System.out.println("Adding author...");
                    if(authorService.add()){
                        System.out.println("Author added");
                    }else{
                        System.out.println("Was unable to add author");
                    };
                    break;
                case 6:
                    System.out.println("Borrowing book...");
                    if(libraryCardService.add()){
                        System.out.println("Book borrowed");
                    }else{
                        System.out.println("Was unable to borrow book");
                    };
                    break;
                case 7:
                    System.out.println("Returning book...");
                    if(((LibraryCardService)libraryCardService).returnBook()){
                        System.out.println("Book returned");
                    }else{
                        System.out.println("Was unable to return book");
                    };
                    break;
                case 8:
                    System.out.println("Editing book...");
                    if(bookService.edit()){
                        System.out.println("Book edited");
                    }else {
                        System.out.println("Was unable to edit book");
                    }
                    break;
                case 9:
                    System.out.println("Editing user...");
                    if(userService.edit()){
                        System.out.println("User edited");
                    }else {
                        System.out.println("Was unable to edit user");
                    }
                    break;
                default:
                    System.out.println("Enter a valid task!");
                    break;
            }
            System.out.println("==============================");
        } while (repeat);
        System.out.println("Goodbye! :3");
    }
}