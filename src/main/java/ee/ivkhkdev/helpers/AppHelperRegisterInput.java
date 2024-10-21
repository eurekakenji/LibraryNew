package ee.ivkhkdev.helpers;

import ee.ivkhkdev.tools.Input;
import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.model.Register;
import ee.ivkhkdev.model.User;
import ee.ivkhkdev.services.BookService;
import ee.ivkhkdev.services.UserService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class AppHelperRegisterInput {
    public Register bookBorrow(List<Book> books, List<User> users, List<Register> registers, Input input, UserService userService, BookService bookService) {
        try {
            Register register = new Register();
            userService.users(users);
            System.out.print("Pick user number from list: ");
            int numberUser = Integer.parseInt(input.nextLine());
            User user = users.get(numberUser-1);
            bookService.books(books);
            System.out.print("Pick book number from list: ");
            int numberBook = Integer.parseInt(input.nextLine());
            Book book = books.get(numberBook-1);
            register.setUser(user);
            register.setBook(book);
            register.setBookBorrowDate(LocalDate.now());
            return register;
        } catch (Exception e) {
            return null;
        }
    }

    public void listBorrowedBooks(List<Register> registers){
        if (registers.isEmpty()){
            System.out.println(" --- List of borrowed books is empty --- ");
        } else {
            System.out.println(" --- List of borrowed books --- ");
            for (int i = 0; i < registers.size(); i++){
                if (registers.get(i).getReturnBookDate() != null){
                    continue;
                }
                System.out.printf("%d. %s. %s. %d%n",
                        i+1,
                        registers.get(i).getBook().getTitle(),
                        Arrays.toString(registers.get(i).getBook().getAuthors().toArray()),
                        registers.get(i).getBook().getPublishedYear()
                );
            }
            System.out.println(" --- End of list --- ");
        }
    }

    public boolean returnBookDialog(Input input, List<Register> registers) {
        try {
            listBorrowedBooks(registers);
            System.out.print("Pick returned book number from list: ");
            int numberReturnBookRegister = Integer.parseInt(input.nextLine());
            registers.get(numberReturnBookRegister - 1).setReturnBookDate(LocalDate.now());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}