package ee.ivkhkdev.tools.impl;

import ee.ivkhkdev.tools.Input;

import java.util.Scanner;

public class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public String nextLine() {
        return scanner.nextLine();
    }
}
