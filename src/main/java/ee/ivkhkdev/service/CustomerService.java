package ee.ivkhkdev.service;


import ee.ivkhkdev.model.Customer;

public class CustomerService {
    public void createCustomer() {
        Customer customer = new Customer("Ivan", "Ivanov", "12345678");

    }
}
