package ee.ivkhkdev.tools;

import ee.ivkhkdev.interfaces.Input;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scanner;

    public ConsoleInput(Scanner scanner) {

        this.scanner = this.scanner;
    }

    @Override
    public int nextInt() {
        return 0;
    }

    @Override
    public String nextLine() {

        return "";
    }
}

