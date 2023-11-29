package eksamen.carsubscription.repository;

import eksamen.carsubscription.entity.Damages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDamages extends JpaRepository<Damages, Long> {
}