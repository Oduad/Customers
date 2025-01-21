package academy.atl.customers.Services;

import academy.atl.customers.Entity.Customer;

import java.util.ArrayList;
import java.util.List;

public interface CustomerService {

    Customer getCustomer(Integer id);
    List<Customer> getAllCustomers();
    void removeCustomer(Integer id);
    void addCustomer(Customer customer);
    void updateCustomer(Integer id, Customer updateCustomer);
    List<Customer> searchCustomer(String email, String address);

}
