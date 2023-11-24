package eksamen.carsubscription.api;// CustomerController.java
import eksamen.carsubscription.entity.Customer;
import eksamen.carsubscription.repository.ICustomer;
import eksamen.carsubscription.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class CustomerController {
private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomer(@PathVariable Long id){
        return customerService.getCustomer(id);
    }


}
