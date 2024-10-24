package ee.ivkhkdev.helpers;

import ee.ivkhkdev.input.Input;
import ee.ivkhkdev.model.Author;
import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.services.Service;

import java.util.List;

public class AppHelperBook implements AppHelper<Book> {

    private final Input input;
    private final Service<Author> authorService;

    public AppHelperBook(Input input, Service<Author> authorService) {
        this.input = input;
        this.authorService = authorService;
    }

    @Override
    public Book create() {
        Book book = new Book();
        try {
            System.out.print("Book title: ");
            book.setTitle(input.nextLine());
            authorService.printList();
            System.out.print("Add author to list? (y/n): ");
            String addAuthorChoose = input.nextLine();
            if(addAuthorChoose.equals("y")){
                System.out.println("Exiting task...");
                return null;
            }
                System.out.print("Amount of authors in book: ");
            int countBookAuthors = Integer.parseInt(input.nextLine());
            for (int i = 0; i < countBookAuthors; i++){
                System.out.printf("Choose author number (%d author out of %d%n): ", i+1,countBookAuthors);
                int numberAuthor = Integer.parseInt(input.nextLine());
                book.getAuthors().add(authorService.list().get(numberAuthor-1));
            }
            System.out.print("Year of publishing: ");
            book.setPublishedYear(Integer.parseInt(input.nextLine()));
            return book;

        }catch (Exception e){
            return null;
        }
    }




    @Override
    public boolean printList(List<Book> books) {
        try {
            if(books.size() == 0) return false;
            for(int i = 0; i < books.size(); i++){
                StringBuilder sbAuthors = new StringBuilder();
                for (int j = 0; j < books.get(i).getAuthors().size(); j++) {
                    sbAuthors.append(books.get(i).getAuthors().get(j).getFirstname());
                    sbAuthors.append(" ");
                    sbAuthors.append(books.get(i).getAuthors().get(j).getLastname());
                    sbAuthors.append(". ");
                }
                System.out.printf("%d. %s. %s%d%n", i+1,books.get(i).getTitle(),sbAuthors.toString(),books.get(i).getPublishedYear());
            }
            return true;
        }catch (Exception e){
            System.out.println("Error: "+e.toString());
            return false;
        }
    }
}
