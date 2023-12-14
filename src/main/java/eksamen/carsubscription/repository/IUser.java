package eksamen.carsubscription.repository;

import eksamen.carsubscription.entity.PickupLocation;
import eksamen.carsubscription.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUser extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
