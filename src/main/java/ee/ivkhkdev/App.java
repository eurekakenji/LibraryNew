package ee.ivkhkdev;

import ee.ivkhkdev.interfaces.Input;
import ee.ivkhkdev.service.CustomerService;

import java.util.Scanner;


public class App {
    private Input input;

    public App(Input inputMock) {
        this.input = input;
    }

    public void run() {
        boolean repeat = true;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("List of tasks:");
            System.out.println("0. leave program");
            System.out.println("1. add user");
            System.out.print("enter task number: ");
            int task = scanner.nextInt();
            switch(task){
                case 0:
                    System.out.println("Exiting program...");
                    repeat = false;
                    break;
                case 1:
                    System.out.println("1. add user");
                    CustomerService customerService = new CustomerService();
                    customerService.createCustomer();
                    break;
                default:
                    System.out.println("Choose a number from the list of tasks!");

            }
        }while (repeat);
        System.out.println("Goodbye! :3");
    }

}