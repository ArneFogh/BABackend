package eksamen.carsubscription.repository;

import eksamen.carsubscription.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomer extends JpaRepository<Customer, Long> {
}