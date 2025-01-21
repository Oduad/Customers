package academy.atl.customers.Controllers;

import academy.atl.customers.Entity.Customer;
import academy.atl.customers.Services.CustomerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CustomerController {
    @Autowired
    private CustomerServiceImp service;

    @GetMapping("/customer/{id}")   // Traer un cliente específico
    public Customer getCustomer(@PathVariable Integer id){
        return service.getCustomer(id);
    }

    @GetMapping("/customer")        // Traer todos los clientes
    public List<Customer> getAllCustomers(){
        return service.getAllCustomers();
    }

    @DeleteMapping("/customer/{id}")
    public void removeCustomer(@PathVariable Integer id){
        service.removeCustomer(id);
    }

    @PostMapping("/customer")
    public void addCustomer(Customer customer){
        service.addCustomer(customer);
    }

    @PutMapping("/customer/{id}")
    public void updateCustomer(@PathVariable Integer id,
                               @RequestBody Customer updateCustomer){
        service.updateCustomer(id,updateCustomer);
    }

    @GetMapping("customer/search")
    public List<Customer> searchCustomer(@RequestParam(name = "email", required = false) String email,
                                         @RequestParam(name = "address", required = false) String address){
        return service.searchCustomer(email,address);
    }

}
