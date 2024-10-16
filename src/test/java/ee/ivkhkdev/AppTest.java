package ee.ivkhkdev;
import ee.ivkhkdev.interfaces.Input;
import ee.ivkhkdev.model.Customer;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class AppTest {

    private Input inputMock;
    private ByteArrayOutputStream outContent;
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        inputMock = Mockito.mock(Input.class);

        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void testExitProgram() {
        when(inputMock.nextInt()).thenReturn(0);

        App app = new App(inputMock);

        app.run();
        assertTrue(outContent.toString().contains("Goodbye! :3"));
    }

    @Test
    public void testRunInvalidTaskNumber() {
        when(inputMock.nextLine()).thenReturn("5", "0");

        App app = new App(inputMock);
        app.run();

        assertTrue(outContent.toString().contains("Выберите номер из списка задач!") && outContent.toString().contains("До свидания! :)"));
    }

    @Test
    public void testAddCustomer() {

        when(inputMock.nextLine()).thenReturn("1", "Ivan","Ivanov", "56565656","0");

        App app = new App(inputMock);
        app.run();

        Customer expected = new Customer("Ivan", "Ivanov", "56565656");
        assertTrue(App.customers[0].getName().equals("Ivan") && outContent.toString().contains("Goodbye! :3"));
    }
}
