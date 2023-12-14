package eksamen.carsubscription.api;

import eksamen.carsubscription.entity.LeaseAgreement;
import eksamen.carsubscription.services.LeaseAgreementService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:3000")
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


    @GetMapping("/leaseAgreement")
    public ResponseEntity<List<LeaseAgreement>> getAllLeaseAgreements() {
        List<LeaseAgreement> leaseAgreements = leaseAgreementService.getAllLeaseAgreements();
        return new ResponseEntity<>(leaseAgreements, HttpStatus.OK);
    }



    @PostMapping("/leaseAgreement/create")
    public ResponseEntity<LeaseAgreement> createLeaseAgreement(@RequestBody LeaseAgreement leaseAgreement) throws ChangeSetPersister.NotFoundException {
        LeaseAgreement createdLeaseAgreement = leaseAgreementService.createLeaseAgreement(leaseAgreement);
        return new ResponseEntity<>(createdLeaseAgreement, HttpStatus.CREATED);
    }


    @PutMapping("/leaseAgreement/update/{id}")
    public ResponseEntity<LeaseAgreement> updateLeaseAgreement(
            @PathVariable Long id,
            @RequestBody LeaseAgreement updatedLeaseAgreement) {
        LeaseAgreement updated = leaseAgreementService.updateLeaseAgreement(id, updatedLeaseAgreement);

        return updated != null ?
                new ResponseEntity<>(updated, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/leaseAgreement/delete/{id}")
    public ResponseEntity<Void> deleteLeaseAgreement(@PathVariable Long id) {
        leaseAgreementService.deleteLeaseAgreement(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
