package ee.ivkhkdev.tools;

import ee.ivkhkdev.model.Customer;

import java.util.Scanner;

public class InputCustomer {
    public Customer newCustomer() {
        Customer customer = new Customer();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter customer name: ");
        customer.setName(scanner.nextLine());
        System.out.print("Enter customer surname: ");
        customer.setSurname(scanner.nextLine());
        System.out.print("Enter customer phone number: ");
        customer.setPhone(scanner.nextLine());

        return customer;
    }
}
