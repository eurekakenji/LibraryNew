package ee.ivkhkdev;
import ee.ivkhkdev.interfaces.Input;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

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
    public void testInvalidTaskNumber() {

        when(inputMock.nextInt()).thenReturn(5, 0);

        App app = new App(inputMock);

        app.run();

        assertTrue(App.customers[0].getName().equals("Ivan") && outContent.toString().contains("Goodbye! :3"));
    }
    @org.jetbrains.annotations.NotNull
    private String normalizeString(String input) {
        return input.trim().replaceAll("\\r\\n", "\n").replaceAll("\\s+$", "");
    }
}
