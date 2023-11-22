package eksamen.carsubscription.repository;


import eksamen.carsubscription.entity.PickupLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPickupLocation extends JpaRepository<PickupLocation, Long> {
}