package eksamen.carsubscription.repository;

import eksamen.carsubscription.entity.LeaseAgreement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILeaseAgreement extends JpaRepository<LeaseAgreement, Long> {
}