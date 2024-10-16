package ee.ivkhkdev;

import ee.ivkhkdev.interfaces.Input;
import ee.ivkhkdev.model.Customer;
import ee.ivkhkdev.service.CustomerService;

import java.beans.Customizer;


public class App {
    public static Customer[] customers = new Customer[100];
    private Input input;

    public App(Input inputMock) {
        this.input = input;
    }

    public void run() {
        boolean repeat = true;
        do{
            System.out.println("List of tasks:");
            System.out.println("0. leave program");
            System.out.println("1. add user");
            System.out.print("enter task number: ");
            int task = Integer.parseInt(input.nextLine());
            switch(task){
                case 0:
                    System.out.println("Exiting program...");
                    repeat = false;
                    break;
                case 1:
                    System.out.println("1. add user");
                    CustomerService customizerService = new CustomerService();
                    customizerService.createCustomer(input);
                    break;
                default:
                    System.out.println("Choose a number from the list of tasks!");
                    break;

            }
        }while (repeat);
        System.out.println("Goodbye! :3");
    }

}