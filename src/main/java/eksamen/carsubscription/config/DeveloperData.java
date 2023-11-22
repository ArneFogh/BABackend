package eksamen.carsubscription.config;

import eksamen.carsubscription.entity.Customer;
import eksamen.carsubscription.repository.ICustomer;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

@Controller
public class DeveloperData implements ApplicationRunner {
    ICustomer customerRepo;

    public DeveloperData(ICustomer customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Customer John = new Customer("john mogensen", "marievej 2", "30292219", "madsrunge");

        customerRepo.save(John);



    }
}
