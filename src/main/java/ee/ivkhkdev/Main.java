package ee.ivkhkdev;

import ee.ivkhkdev.interfaces.Input;
import ee.ivkhkdev.tools.ConsoleInput;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Input scanner = new ConsoleInput(new Scanner(System.in));
        System.out.println("JPTV23Library");
        Input inputMock = null;
        App app = new App(inputMock);
        app.run();

    }
}