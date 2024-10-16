package ee.ivkhkdev.model;

import java.util.UUID;

public class Customer {
    private UUID id;
    private String name;
    private String surname;
    private String phone;

    public Customer() {
        this.id = UUID.randomUUID();
    }
    public Customer(String name, String surname, String phone) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
    }
    
    public UUID getId() {

        return id;
    }

    public void setId(UUID id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getSurname() {

        return surname;
    }

    public void setSurname(String surname) {

        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {

        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;
        return id.equals(customer.id) && name.equals(customer.name) && surname.equals(customer.surname) && phone.equals(customer.phone);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + phone.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + name + '\'' +
                ", lastName='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }


}
