package eksamen.carsubscription.services;// LeaseAgreementService.java
import eksamen.carsubscription.entity.Car;
import eksamen.carsubscription.entity.Customer;
import eksamen.carsubscription.entity.LeaseAgreement;
import eksamen.carsubscription.entity.PickupLocation;
import eksamen.carsubscription.repository.ICar;
import eksamen.carsubscription.repository.ICustomer;
import eksamen.carsubscription.repository.ILeaseAgreement;
import eksamen.carsubscription.repository.IPickupLocation;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeaseAgreementService {


    private ILeaseAgreement leaseAgreementRepository;
    private ICar carRepository;
    private IPickupLocation pickupLocationRepository;
    private ICustomer customerRepository;

    public LeaseAgreementService(ILeaseAgreement leaseAgreementRepository, ICar carRepository, IPickupLocation pickupLocationRepository, ICustomer customerRepository) {
        this.leaseAgreementRepository = leaseAgreementRepository;
        this.carRepository = carRepository;
        this.pickupLocationRepository = pickupLocationRepository;
        this.customerRepository = customerRepository;
    }

    public LeaseAgreement getLeaseAgreement(Long id) {
        return leaseAgreementRepository.findById(id).orElse(null);
    }

    public List<LeaseAgreement> getAllLeaseAgreements() {
        return leaseAgreementRepository.findAll();
    }



    public LeaseAgreement createLeaseAgreement(LeaseAgreement leaseAgreement) {
        try {
            // Validate IDs
            Long customerId = leaseAgreement.getCustomer().getCustomerID();
            Long carId = leaseAgreement.getCar().getCarId();
            Long pickupLocationId = leaseAgreement.getPickupLocation().getId();
            Long dropoffLocationId = leaseAgreement.getDropoffLocation().getId();

            // Ensure customer, car, pickupLocation, and dropoffLocation exist
            Customer customer = customerRepository.findById(customerId).orElseThrow(EntityNotFoundException::new);
            Car car = carRepository.findById(carId).orElseThrow(EntityNotFoundException::new);

            // Assuming PickupLocationRepository extends JpaRepository<PickupLocation, Long>
            PickupLocation pickupLocation = pickupLocationRepository.findById(pickupLocationId).orElseThrow(EntityNotFoundException::new);
            PickupLocation dropoffLocation = pickupLocationRepository.findById(dropoffLocationId).orElseThrow(EntityNotFoundException::new);

            // Set associations
            leaseAgreement.setCustomer(customer);
            leaseAgreement.setCar(car);
            leaseAgreement.setPickupLocation(pickupLocation);
            leaseAgreement.setDropoffLocation(dropoffLocation);

            // Save the lease agreement
            return leaseAgreementRepository.save(leaseAgreement);
        } catch (EntityNotFoundException e) {
            throw new RuntimeException("One or more entities not found: " + e.getMessage());
        }
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
