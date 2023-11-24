package eksamen.carsubscription.api;

import eksamen.carsubscription.entity.LeaseAgreement;
import eksamen.carsubscription.services.LeaseAgreementService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LeaseAgreementController {

    private LeaseAgreementService leaseAgreementService;

    public LeaseAgreementController(LeaseAgreementService leaseAgreementService) {
        this.leaseAgreementService = leaseAgreementService;
    }





@GetMapping("/leaseAgreement/{id}")
    public LeaseAgreement getLeaseAgreement(@PathVariable Long id){
        return leaseAgreementService.getLeaseAgreement(id);
    }
}
