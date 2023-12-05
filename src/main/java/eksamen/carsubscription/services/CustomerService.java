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
        Optional<Customer> existingCustomer = customerRepository.findById(id);

        if (existingCustomer.isPresent()) {
            Customer currentCustomer = existingCustomer.get();


            currentCustomer.setName(updatedCustomer.getName());
            currentCustomer.setAddress(updatedCustomer.getAddress());
            currentCustomer.setPhoneNumber(updatedCustomer.getPhoneNumber());
            currentCustomer.setEmail(updatedCustomer.getEmail());


            return customerRepository.save(currentCustomer);
        } else {
            return null;
        }
    }



    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}

