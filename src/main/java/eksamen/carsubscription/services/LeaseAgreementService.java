package eksamen.carsubscription.services;// LeaseAgreementService.java
import eksamen.carsubscription.entity.Car;
import eksamen.carsubscription.entity.Customer;
import eksamen.carsubscription.entity.LeaseAgreement;
import eksamen.carsubscription.entity.PickupLocation;
import eksamen.carsubscription.repository.ICar;
import eksamen.carsubscription.repository.ICustomer;
import eksamen.carsubscription.repository.ILeaseAgreement;
import eksamen.carsubscription.repository.IPickupLocation;
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



    public LeaseAgreement createLeaseAgreement(LeaseAgreement leaseAgreement) throws ChangeSetPersister.NotFoundException {
        // Check om bilen eksisterer ved at bruge bilens id
        Car car = leaseAgreement.getCar();
        if (car != null && car.getCarId() != null) {
            Optional<Car> carOptional = carRepository.findById(car.getCarId());

            if (carOptional.isPresent()) {
                // Hvis bilen findes, sæt bilen på leasingaftalen
                leaseAgreement.setCar(carOptional.get());

                // Check om afhentningsstedet eksisterer ved at bruge afhentningsstedets id
                PickupLocation pickupLocation = leaseAgreement.getPickupLocation();
                if (pickupLocation != null && pickupLocation.getId() != null) {
                    Optional<PickupLocation> pickupLocationOptional = pickupLocationRepository.findById(pickupLocation.getId());

                    if (pickupLocationOptional.isPresent()) {
                        // Hvis afhentningsstedet findes, sæt det på leasingaftalen
                        leaseAgreement.setPickupLocation(pickupLocationOptional.get());
                    } else {
                        // Håndter scenariet, hvor afhentningsstedet ikke findes
                        throw new ChangeSetPersister.NotFoundException();
                    }
                }

                // Check om kunden eksisterer ved at bruge kundens id
                Customer customer = leaseAgreement.getCustomer();
                if (customer != null && customer.getCustomerID() != null) {
                    Optional<Customer> customerOptional = customerRepository.findById(customer.getCustomerID());

                    if (customerOptional.isPresent()) {
                        // Hvis kunden findes, sæt kunden på leasingaftalen
                        leaseAgreement.setCustomer(customerOptional.get());
                    } else {
                        // Håndter scenariet, hvor kunden ikke findes
                        throw new ChangeSetPersister.NotFoundException();
                    }
                }

                // Gem leasingaftalen i databasen
                return leaseAgreementRepository.save(leaseAgreement);
            } else {
                // Håndter scenariet, hvor bilen ikke findes
                throw new ChangeSetPersister.NotFoundException();
            }
        } else {
            // Håndter scenariet, hvor bilen eller dens id er null
            throw new IllegalArgumentException("Car or car ID must not be null");
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
