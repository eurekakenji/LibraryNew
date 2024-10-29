package ee.ivkhkdev.services;

import ee.ivkhkdev.helpers.AppHelper;
import ee.ivkhkdev.helpers.AppHelperAuthor;
import ee.ivkhkdev.model.Author;
import ee.ivkhkdev.repository.Repository;
import ee.ivkhkdev.repository.Storage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AuthorServiceTest {
    List<Author> authors;
    Service<Author> authorService;
    Repository<Author> repositoryMock;
    AppHelper<Author> appHelperAuthorMock;



    @BeforeEach
    void setUp() {
        Author author = new Author("Lev", "Tolstoi");
        authors = new ArrayList<>();
        authors.add(author);
        appHelperAuthorMock = Mockito.mock(AppHelperAuthor.class);
        when(appHelperAuthorMock.create()).thenReturn(new Author("Ivan", "Turgenev"));
        repositoryMock = Mockito.mock(Storage.class);
        authorService = new AuthorService(authors, appHelperAuthorMock, repositoryMock);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testAdd_SuccessfulAdd() {
        Author mockAuthor = new Author("Ivan", "Turgenev");
        when(appHelperAuthorMock.create()).thenReturn(mockAuthor);
        boolean result = authorService.add();
        assertTrue(result);
        assertTrue(authors.get(1).getFirstname().equals("Ivan"));
        assertEquals(mockAuthor,authors.get(0));
        verify(repositoryMock,times(1)).save(any(Author.class));
    }


    @Test
    void restAdd_CreateReturnNull() {
        authors = new ArrayList<>();
        when(appHelperAuthorMock.create()).thenReturn(null);
        boolean result = authorService.add();
        assertFalse(result);
        assertTrue(authors.isEmpty());
        verify(repositoryMock, never()).save((any()));

    }


    @Test
    void testAdd_AddExistingAuthor(){
        Author existingAuthor = new Author();
        authors = new ArrayList<>();
        authors.add(existingAuthor);
        Author newAuthor = new Author();
        when(appHelperAuthorMock.create()).thenReturn(new Author());
        boolean result = authorService.add();
        assertTrue(result);
        assertNotEquals(2, authors.size());
        assertEquals(newAuthor, authors.get(1));
        verify(repositoryMock, times(1)).save(newAuthor);
    }

    @Test
    void testPrint() {
        when(appHelperAuthorMock.printList(authors)).thenReturn(true);
        boolean result = authorService.print();
        assertTrue(result);
        verify(appHelperAuthorMock, times(1)).printList(authors);
    }

    @Test
    void testList() {
        //List<Author> result =;
    }
}