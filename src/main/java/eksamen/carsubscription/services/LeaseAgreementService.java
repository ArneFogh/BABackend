package eksamen.carsubscription.services;// LeaseAgreementService.java
import eksamen.carsubscription.entity.LeaseAgreement;
import eksamen.carsubscription.repository.ILeaseAgreement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaseAgreementService {

    // Antager, at du har et repository eller en service til LeaseAgreement
    private ILeaseAgreement leaseAgreementRepository;

    public LeaseAgreementService(ILeaseAgreement leaseAgreementRepository) {
        this.leaseAgreementRepository = leaseAgreementRepository;
    }

    public LeaseAgreement getLeaseAgreement(Long id) {
        return leaseAgreementRepository.findById(id).orElse(null);
    }
}
