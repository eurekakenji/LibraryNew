package ee.ivkhkdev.model;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class LibraryCard {
    private UUID id;
    private Book book;
    private User user;
    private LocalDate borrowedBookDate;
    private LocalDate returnedBookDate;

    public LibraryCard() {
        this.id = UUID.randomUUID();
    }

    public LibraryCard(LocalDate returnedBookDate, LocalDate borrowedBookDate, User user, Book book, UUID id) {
        this.returnedBookDate = returnedBookDate;
        this.borrowedBookDate = borrowedBookDate;
        this.user = user;
        this.book = book;
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getBorrowedBookDate() {
        return borrowedBookDate;
    }

    public void setBorrowedBookDate(LocalDate borrowedBookDate) {
        this.borrowedBookDate = borrowedBookDate;
    }

    public LocalDate getReturnedBookDate() {
        return returnedBookDate;
    }

    public void setReturnedBookDate(LocalDate returnedBookDate) {
        this.returnedBookDate = returnedBookDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LibraryCard that = (LibraryCard) o;
        return Objects.equals(id, that.id) && Objects.equals(book, that.book) && Objects.equals(user, that.user) && Objects.equals(borrowedBookDate, that.borrowedBookDate) && Objects.equals(returnedBookDate, that.returnedBookDate);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(book);
        result = 31 * result + Objects.hashCode(user);
        result = 31 * result + Objects.hashCode(borrowedBookDate);
        result = 31 * result + Objects.hashCode(returnedBookDate);
        return result;
    }
}
