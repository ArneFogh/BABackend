package eksamen.carsubscription.config;

import eksamen.carsubscription.entity.*;
import eksamen.carsubscription.repository.*;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;


@Controller
public class DeveloperData implements ApplicationRunner {
    private final ICustomer customerRepo;
    private final ICar carRepo;
    private final IPickupLocation pickupLocationRepo;
    private final ILeaseAgreement leaseAgreementRepo;
    private final IDamages damageRepo;

    public DeveloperData(ICustomer customerRepo, ICar carRepo,
                         IPickupLocation pickupLocationRepo,
                         ILeaseAgreement leaseAgreementRepo,
                         IDamages damageRepo) {
        this.customerRepo = customerRepo;
        this.carRepo = carRepo;
        this.pickupLocationRepo = pickupLocationRepo;
        this.leaseAgreementRepo = leaseAgreementRepo;
        this.damageRepo = damageRepo;
    }

    @Override
    public void run(ApplicationArguments args) {

        Customer John = new Customer("John Mogensen", "Marievej 2", "30292219", "john@example.com");
        customerRepo.save(John);

        Car Tesla = new Car("Tesla", "Model S", "NV24503", 650.334, "Electric", 15000, "https://static-assets.tesla.com/configurator/compositor?context=design_studio_2?&bkba_opt=1&view=FRONT34&size=1400&model=ms&options=$MDLS,$MTS14,$PMNG,$WS10,$APBS,$SC04,$CPF0,$TW01,$ICC00,$ST0Y&crop=1400,850,300,130&");
        carRepo.save(Tesla);

        PickupLocation pickupLocation = new PickupLocation("123 Main St", "Jane Doe", "555-1234");
        pickupLocationRepo.save(pickupLocation);

        LeaseAgreement leaseAgreement = new LeaseAgreement(
                John,
                Tesla,
                pickupLocation,
                pickupLocation, // assuming dropoff is the same as pickup for example
                "21112023", // start date
                "21112024", // end date, set appropriately
                999, // monthly price
                20000, // agreed KM
                500 // km driven
        );
        leaseAgreementRepo.save(leaseAgreement);

        Damages damage = new Damages(
                Tesla,
                "Scratch on rear bumper", "21-11-2023", // registration date
                299.99 // repair cost
        );
        damageRepo.save(damage);
    }
}
