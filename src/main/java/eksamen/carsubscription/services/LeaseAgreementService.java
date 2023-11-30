package eksamen.carsubscription.services;// LeaseAgreementService.java
import eksamen.carsubscription.entity.LeaseAgreement;
import eksamen.carsubscription.repository.ILeaseAgreement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<LeaseAgreement> getAllLeaseAgreements() {
        return leaseAgreementRepository.findAll();
    }



    public LeaseAgreement createLeaseAgreement(LeaseAgreement leaseAgreement) {
        return leaseAgreementRepository.save(leaseAgreement);
    }

    public LeaseAgreement updateLeaseAgreement(Long id, LeaseAgreement updatedLeaseAgreement) {
        Optional<LeaseAgreement> existingLeaseAgreement = leaseAgreementRepository.findById(id);

        if (existingLeaseAgreement.isPresent()) {
            LeaseAgreement currentLeaseAgreement = existingLeaseAgreement.get();


            if (updatedLeaseAgreement.getCustomer() != null) {
                currentLeaseAgreement.setCustomer(updatedLeaseAgreement.getCustomer());
            }

            if (updatedLeaseAgreement.getCar() != null) {
                currentLeaseAgreement.setCar(updatedLeaseAgreement.getCar());
            }


            return leaseAgreementRepository.save(currentLeaseAgreement);
        } else {

            return null;
        }
    }


    public void deleteLeaseAgreement(Long id) {
        leaseAgreementRepository.deleteById(id);
    }

}
