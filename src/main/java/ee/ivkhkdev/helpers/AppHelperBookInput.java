package ee.ivkhkdev.helpers;

import ee.ivkhkdev.model.Author;
import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.tools.Input;

import java.util.Arrays;
import java.util.List;

public class AppHelperBookInput {
    public Book createBook(Input input){
        try {
            System.out.println("===== New book =====");
            Book book = new Book();
            System.out.println("Book Title: ");
            book.setTitle(input.nextLine());
            System.out.println("Author(s): ");
            System.out.print("Amount of authors in book: ");
            int countAuthors = Integer.parseInt(input.nextLine());
            for (int i = 0; i < countAuthors; i++){
                Author author = new Author();
                System.out.printf("Author %d:%n", i+1);
                System.out.print("Author first name: ");
                author.setFirstname(input.nextLine());
                System.out.print("Author surname: ");
                author.setLastname(input.nextLine());
                book.getAuthors().add(author);
            }
            System.out.print("year of publishing: ");
            book.setPublishedYear(Integer.parseInt(input.nextLine()));
            return book;
        }catch (Exception e){
            System.out.println("Error: "+e.toString());
            return null;
        }
    }

    public void printBooks(List<Book> books) {
        if (books.isEmpty()){
            System.out.println(" --- The list is empty --- ");
        } else {
            System.out.println(" --- List of books --- ");
            for (int i = 0; i < books.size(); i++){
                System.out.printf("%d. %s. %s. %d%n",
                        i+1,
                        books.get(i).getTitle(),
                        Arrays.toString(books.get(i).getAuthors().toArray()),
                        books.get(i).getPublishedYear()
                );
            }
            System.out.println(" --- End of list --- ");
        }
    }
}