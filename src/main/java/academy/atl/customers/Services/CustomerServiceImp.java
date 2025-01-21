package academy.atl.customers.Services;

import academy.atl.customers.Entity.Customer;
import academy.atl.customers.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImp implements CustomerService{

    @Autowired
    private CustomerRepository repository;

    /*public CustomerServiceImp(){
        Customer customer1 = new Customer(1, "Oduad", "Aragón", "oduad.aragon@gmail.com", "Riva Palacio");
        Customer customer2 = new Customer(2, "Litos", "Aragón", "ingcaragon@gmail.com", "CalleAyotla");
        Customer customer3 = new Customer(3, "Ollin", "Aragón", "ollin.aragon@hotmail.com", "CalleIztacalco");
        Customer customer4 = new Customer(4, "Levi", "Aragón", "levi.aragon@hotmail.com", "Riva Palacio");

        customersList.add(customer1);
        customersList.add(customer2);
        customersList.add(customer3);
        customersList.add(customer4);
    }*/

    public Customer getCustomer(Integer id){
        Optional<Customer> customer = repository.findById(id);
        if(customer.isPresent()){
            return customer.get();
        }else{
            return null;
        }
    }
    public List<Customer> getAllCustomers(){
        //return customersList;
        List<Customer> customersList = new ArrayList<>();
        Iterable<Customer> customers = repository.findAll();
        for (Customer customer: customers) {
            customersList.add(customer);
        }
        return customersList;
    }

    public void removeCustomer(Integer id){
        /*for(Customer customer : customersList){
            if (customer.getId().equals(id)){
                customersList.remove(customer);
                break;
            }
        }*/
        repository.deleteById(id);
    }


    public void addCustomer(Customer customer){
        //customersList.add(customer);
        repository.save(customer);
    }


    public void updateCustomer(Integer id, Customer updateCustomer){
        /*for(Customer customer : customersList){
            if (customer.getId()==id){
                customersList.remove(customer);
                customersList.add(updateCustomer);
                break;
            }
        }*/
        updateCustomer.setId(id);
        repository.save(updateCustomer);
    }

    public List<Customer> searchCustomer(String email, String address){
        /*List<Customer>searchCustomer = new ArrayList<>();
        if(email != null){
            for(Customer customer: customersList){
                if (customer.getEmail().contains(email)){
                    searchCustomer.add(customer);
                }
            }
        }
        if (address!= null){
            for(Customer customer: customersList){
                if (customer.getAddress().contains(address)){
                    searchCustomer.add(customer);
                }
            }
        }
        return searchCustomer;*/
        return repository.findByEmailOrAddress(email,address);
    }
}
