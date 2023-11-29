package eksamen.carsubscription.services;// CustomerService.java
import eksamen.carsubscription.entity.Customer;
import eksamen.carsubscription.repository.ICustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private ICustomer customerRepository;

    @Autowired
    public CustomerService(ICustomer customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }


    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        if (customerRepository.existsById(id)) {

            return customerRepository.save(updatedCustomer);
        } else {

            return null;
        }
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}

