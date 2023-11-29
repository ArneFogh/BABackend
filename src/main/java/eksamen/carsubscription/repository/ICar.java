package eksamen.carsubscription.repository;

import eksamen.carsubscription.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICar extends JpaRepository<Car, Long> {
}