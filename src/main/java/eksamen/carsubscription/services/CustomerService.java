package eksamen.carsubscription.services;// CustomerService.java
import eksamen.carsubscription.entity.Customer;
import eksamen.carsubscription.repository.ICustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
