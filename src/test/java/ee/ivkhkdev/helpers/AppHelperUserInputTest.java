package ee.ivkhkdev.helpers;

import ee.ivkhkdev.model.User;
import ee.ivkhkdev.tools.Input;
import ee.ivkhkdev.tools.impl.ConsoleInput;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AppHelperUserInputTest {

    Input inputMock;
    AppHelperUserInput appHelperUserInput = new AppHelperUserInput();
    @BeforeEach
    void setUp() {
        inputMock = Mockito.mock(ConsoleInput.class);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createUser() {
        when(inputMock.nextLine()).thenReturn("Ivan", "Ivanov","123456","ivan@jktv23.ee");
        User actual = appHelperUserInput.createUser(inputMock);
        User expected = new User("Ivan", "Ivanov","123456","ivan@jktv23.ee");
        assertEquals(actual.getFirstname(), expected.getFirstname());
        assertEquals(actual.getLastname(), expected.getLastname());
        assertEquals(actual.getPhone(), expected.getPhone());
    }
}