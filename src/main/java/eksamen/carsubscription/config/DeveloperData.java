package eksamen.carsubscription.config;

import eksamen.carsubscription.entity.*;
import eksamen.carsubscription.repository.*;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;
import java.util.Random;
import java.util.stream.Stream;


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
        // Assuming John is a default customer if needed
        Customer defaultCustomer = new Customer("John Doe", "Default Address", "00000000", "john.doe@example.com");
        Customer customer1 = new Customer("Anders Andersen", "Bakkegårdsvej 1", "12345678", "anders.andersen@example.com");
        Customer customer2 = new Customer("Lise Nielsen", "Skovvej 2A", "23456789", "lise.nielsen@example.com");
        Customer customer3 = new Customer("Mads Pedersen", "Søndergade 3", "34567890", "mads.pedersen@example.com");
        Customer customer4 = new Customer("Anne Hansen", "Højtoftevej 4B", "45678901", "anne.hansen@example.com");
        Customer customer5 = new Customer("Jens Larsen", "Møllevej 5C", "56789012", "jens.larsen@example.com");
        Customer customer6 = new Customer("Sofie Rasmussen", "Strandgade 6", "67890123", "sofie.rasmussen@example.com");
        Customer customer7 = new Customer("Emil Christensen", "Bredgade 7A", "78901234", "emil.christensen@example.com");
        Customer customer8 = new Customer("Ida Jørgensen", "Østergade 8", "89012345", "ida.jorgensen@example.com");
        Customer customer9 = new Customer("Frederik Poulsen", "Vestergade 9B", "90123456", "frederik.poulsen@example.com");
        Customer customer10 = new Customer("Lærke Eriksen", "Nørregade 10C", "01234567", "laerke.eriksen@example.com");
        Customer customer11 = new Customer("Christian Mikkelsen", "Viborgvej 11", "11223344", "christian.mikkelsen@example.com");
        Customer customer12 = new Customer("Sarah Sørensen", "Grenåvej 12", "22334455", "sarah.sorensen@example.com");
        Customer customer13 = new Customer("Nikolaj Jensen", "Aalborggade 13A", "33445566", "nikolaj.jensen@example.com");
        Customer customer14 = new Customer("Laura Nielsen", "Randersvej 14", "44556677", "laura.nielsen@example.com");
        Customer customer15 = new Customer("Rasmus Olsen", "Horsensvej 15B", "55667788", "rasmus.olsen@example.com");
        Customer customer16 = new Customer("Amalie Madsen", "Holstebrovej 16C", "66778899", "amalie.madsen@example.com");
        Customer customer17 = new Customer("Simon Kristensen", "Odensegade 17", "77889900", "simon.kristensen@example.com");
        Customer customer18 = new Customer("Mia Pedersen", "Aarhusvej 18", "88990011", "mia.pedersen@example.com");
        Customer customer19 = new Customer("Jonas Christensen", "Esbjergvej 19", "99001122", "jonas.christensen@example.com");
        Customer customer20 = new Customer("Nina Mikkelsen", "Herninggade 20", "00112233", "nina.mikkelsen@example.com");

        customerRepo.save(defaultCustomer);
        Stream.of(customer1, customer2, customer3, customer4, customer5, customer6, customer7, customer8, customer9, customer10, customer11, customer12, customer13, customer14, customer15, customer16, customer17, customer18, customer19, customer20)
                .forEach(customerRepo::save);


        // Method to generate a random license plate
        String licensePlate = generateRandomLicensePlate();

        // For the Car instance
        Car car1 = new Car("Chevrolet", "Spark", licensePlate, 190000.00, "Benzin", "10-06-2020", 14815, "https://i.imgur.com/pVUZHHG.png");
        Car car2 = new Car("Kia", "Niro", licensePlate, 330000.0, "Elektrisk", "29-07-2021", 21532, "https://i.imgur.com/2Rk1Ydn.png");
        Car car3 = new Car("Volvo", "XC60", licensePlate, 680000.0, "Elektrisk", "18-06-2022", 19755, "https://i.imgur.com/dr6wkSq.png");
        Car car4 = new Car("Land Rover", "Defender D200", "AF76890", 1400000.0, "Diesel", "24-01-2022", 15899, "https://i.imgur.com/rgytT0G.png");
        Car car5 = new Car("Porsche", "Panamera", "BC23451", 1609000.0, "Hybrid", "07-06-2021", 19404, "https://i.imgur.com/aiYXHjK.png");
        Car car6 = new Car("Mitsubishi", "ASX", "DE94532", 350000.0, "Benzin", "06-06-2021", 16912, "https://i.imgur.com/eSB34AQ.png");
        Car car7 = new Car("Volkswagen", "ID3", "AF34567", 400000.0, "Elektrisk", "19-04-2021", 15530, "https://i.imgur.com/fcvD3gJ.png");
        Car car8 = new Car("Renault", "Austral", "BC56789", 540000.0, "Benzin", "10-06-2019", 19817, "https://i.imgur.com/utRRFEO.png");
        Car car9 = new Car("Land Rover", "Range Rover Evoque", "DE67890", 657900.0, "Hybrid", "03-04-2020", 20967, "https://i.imgur.com/U9HZ63g.png");
        Car car10 = new Car("Mercedes", "E300", "AF78901", 630000.0, "Hybrid", "19-06-2021", 24170, "https://i.imgur.com/oItVftV.png");
        Car car11 = new Car("BMW", "i3 Charged Plus", "GH89012", 225000.0, "Elektrisk", "31-03-2021", 13846, "https://i.imgur.com/ryEZ2mI.png");
        Car car12 = new Car("BMW", "i4 M50 xDrive", "IJ90123", 589000.0, "Elektrisk", "28-04-2020", 21170, "https://i.imgur.com/VWPnRdM.png");
        Car car13 = new Car("Porsche", "Taycan", "KL01234", 1690000.0, "Elektrisk", "13-03-2020", 19224, "https://i.imgur.com/tgfD2Xt.png");
        Car car14 = new Car("Volkswagen", "T-Roc", "MN12345", 250000.0, "Diesel", "08-06-2020", 28460, "https://i.imgur.com/bPxAMNG.png");
        Car car15 = new Car("Ford", "Kuga", "OP23456", 356454.0, "Hybrid", "24-01-2020", 30079, "https://i.imgur.com/86VavOE.png");
        Car car16 = new Car("Volvo", "V60", "QR34567", 457000.0, "Hybrid", "26-12-2019", 19991, "https://i.imgur.com/DqNsQlk.png");
        Car car17 = new Car("Audi", "A5", "ST45678", 664900.0, "Benzin", "30-12-2019", 30092, "https://i.imgur.com/0nE83ab.png");
        Car car18 = new Car("Volvo", "XC90", "UV56789", 780000.0, "Diesel", "02-01-2020", 22540, "https://i.imgur.com/ffYX0uV.png");
        Car car19 = new Car("Tesla", "Model S", "WX67890", 1040000.0, "Elektrisk", "02-01-2020", 26553, "https://i.imgur.com/rrFGncg.png");

        Stream.of(car1, car2, car3, car4, car5, car6, car7, car8, car9, car10, car11, car12, car13, car14, car15, car16, car17, car18, car19)
                .forEach(carRepo::save);


        //Pickup / DropOff Locations
        PickupLocation defaultPickupLocation = new PickupLocation("Vibeholmsvej 31, 2605 Brøndby", "John Doe", "22334455");
        PickupLocation fdmAarhus = new PickupLocation("Vintervej 1, 8210 Århus", "FDM Aarhus", "23456789");
        PickupLocation fdmAalborg = new PickupLocation("Atletikvej 6, 9230 Svenstrup", "FDM Aalborg", "34567890");
        PickupLocation fdmFredericia = new PickupLocation("Vesterballevej 6, 7000 Fredericia", "FDM Fredericia", "45678901");
        PickupLocation fdmSilkeborg = new PickupLocation("Bredhøjvej 5, 8600 Silkeborg", "FDM Silkeborg", "56789012");
        Stream.of(defaultPickupLocation, fdmAarhus, fdmAalborg, fdmFredericia, fdmSilkeborg)
                .forEach(pickupLocationRepo::save);



        // For the LeaseAgreement instance, use the default customer if necessary
        LeaseAgreement leaseAgreement1 = new LeaseAgreement(
                defaultCustomer,       // customer - using the default one created above
                car1,                  // car
                defaultPickupLocation, // pickupLocation - Assuming this is the same for pickup and dropoff
                defaultPickupLocation, // dropoffLocation
                "25-12-2021",          // startDate
                "25-12-2023",          // endDate
                4000,                  // monthlySubscriptionPrice
                18000,                 // agreedSubscriptionKM
                19400                  // kmDriven
        );

        LeaseAgreement leaseAgreement2 = new LeaseAgreement(
                defaultCustomer, // Assuming a default customer is used
                car2,
                defaultPickupLocation,
                defaultPickupLocation, // Assuming dropoff is the same as pickup for example
                "29-07-2021",
                "29-07-2023",
                4500,
                18000,
                16566
        );

        LeaseAgreement leaseAgreement3 = new LeaseAgreement(
                defaultCustomer,
                car3,
                defaultPickupLocation,
                defaultPickupLocation,
                "18-06-2022",
                "18-06-2023",
                5000,
                18000,
                17599
        );

        LeaseAgreement leaseAgreement4 = new LeaseAgreement(
                defaultCustomer, // Replace with actual customer object
                car4,
                defaultPickupLocation, // Replace with actual location object
                defaultPickupLocation, // Replace with actual location object
                "21-12-2022",
                "21-12-2023",
                6500,
                18000,
                19469
        );

        LeaseAgreement leaseAgreement5 = new LeaseAgreement(
                defaultCustomer, // Replace with actual customer object
                car5,
                defaultPickupLocation, // Replace with actual location object
                defaultPickupLocation, // Replace with actual location object
                "19-08-2021",
                "19-08-2023",
                9500,
                36000,
                22861
        );

        LeaseAgreement leaseAgreement6 = new LeaseAgreement(
                defaultCustomer, // Replace with actual customer object
                car6,
                defaultPickupLocation, // Replace with actual location object
                defaultPickupLocation, // Replace with actual location object
                "29-12-2021",
                "29-12-2023",
                4000,
                36000,
                29169
        );

        LeaseAgreement leaseAgreement7 = new LeaseAgreement(
                defaultCustomer, // Replace with actual customer object
                car7,
                defaultPickupLocation, // Replace with actual location object
                defaultPickupLocation, // Replace with actual location object
                "30-07-2021",
                "30-07-2023",
                4800,
                36000,
                27355
        );

        LeaseAgreement leaseAgreement8 = new LeaseAgreement(
                defaultCustomer, // Replace with actual customer object
                car8,
                defaultPickupLocation, // Replace with actual location object
                defaultPickupLocation, // Replace with actual location object
                "06-02-2021",
                "06-02-2023",
                5000,
                36000,
                26689
        );

        LeaseAgreement leaseAgreement9 = new LeaseAgreement(
                defaultCustomer, // Replace with actual customer object
                car9,
                defaultPickupLocation, // Replace with actual location object
                defaultPickupLocation, // Replace with actual location object
                "03-02-2021",
                "03-02-2023",
                5000,
                36000,
                26017
        );

        LeaseAgreement leaseAgreement10 = new LeaseAgreement(
                defaultCustomer, // Replace with actual customer object
                car10,
                defaultPickupLocation, // Replace with actual location object
                defaultPickupLocation, // Replace with actual location object
                "03-12-2021",
                "03-12-2023",
                5200,
                36000,
                27765
        );

        LeaseAgreement leaseAgreement11 = new LeaseAgreement(
                defaultCustomer, // Replace with actual customer object
                car11,
                defaultPickupLocation, // Replace with actual location object
                defaultPickupLocation, // Replace with actual location object
                "07-01-2021",
                "07-01-2023",
                5300,
                36000,
                29161
        );

        LeaseAgreement leaseAgreement12 = new LeaseAgreement(
                defaultCustomer, // Replace with actual customer object
                car12,
                defaultPickupLocation, // Replace with actual location object
                defaultPickupLocation, // Replace with actual location object
                "15-07-2021",
                "15-07-2023",
                5500,
                36000,
                24083
        );

        LeaseAgreement leaseAgreement13 = new LeaseAgreement(
                defaultCustomer, // Replace with actual customer object
                car13,
                defaultPickupLocation, // Replace with actual location object
                defaultPickupLocation, // Replace with actual location object
                "25-07-2020",
                "25-07-2023",
                10000,
                36000,
                27899
        );

        LeaseAgreement leaseAgreement14 = new LeaseAgreement(
                defaultCustomer, // Replace with actual customer object
                car14,
                defaultPickupLocation, // Replace with actual location object
                defaultPickupLocation, // Replace with actual location object
                "31-07-2020",
                "31-07-2023",
                8000,
                54000,
                45218
        );

        LeaseAgreement leaseAgreement15 = new LeaseAgreement(
                defaultCustomer, // Replace with actual customer object
                car15,
                defaultPickupLocation, // Replace with actual location object
                defaultPickupLocation, // Replace with actual location object
                "15-02-2020",
                "15-02-2023",
                5000,
                54000,
                54634
        );

        LeaseAgreement leaseAgreement16 = new LeaseAgreement(
                defaultCustomer, // Replace with actual customer object
                car16,
                defaultPickupLocation, // Replace with actual location object
                defaultPickupLocation, // Replace with actual location object
                "25-06-2020",
                "25-06-2023",
                4000,
                54000,
                47144
        );

        LeaseAgreement leaseAgreement17 = new LeaseAgreement(
                defaultCustomer, // Replace with actual customer object
                car17,
                defaultPickupLocation, // Replace with actual location object
                defaultPickupLocation, // Replace with actual location object
                "21-11-2020",
                "21-11-2023",
                7800,
                54000,
                43762
        );

        LeaseAgreement leaseAgreement18 = new LeaseAgreement(
                defaultCustomer, // Replace with actual customer object
                car18,
                defaultPickupLocation, // Replace with actual location object
                defaultPickupLocation, // Replace with actual location object
                "20-04-2020",
                "20-04-2023",
                5000,
                54000,
                44433
        );

        LeaseAgreement leaseAgreement19 = new LeaseAgreement(
                defaultCustomer, // Replace with actual customer object
                car19,
                defaultPickupLocation, // Replace with actual location object
                defaultPickupLocation, // Replace with actual location object
                "13-06-2020",
                "13-06-2023",
                8000,
                54000,
                54326
        );

        Stream.of(
                leaseAgreement1, leaseAgreement2, leaseAgreement3, leaseAgreement4, leaseAgreement5,
                leaseAgreement6, leaseAgreement7, leaseAgreement8, leaseAgreement9, leaseAgreement10,
                leaseAgreement11, leaseAgreement12, leaseAgreement13, leaseAgreement14, leaseAgreement15,
                leaseAgreement16, leaseAgreement17, leaseAgreement18, leaseAgreement19
        ).forEach(leaseAgreementRepo::save);


        Damages damages = new Damages(car3, "Lille bule på bagsiden", "2023-06-15", 500.0, leaseAgreement2);
        damageRepo.save(damages);

    }



    private String generateRandomLicensePlate() {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        // Generate two random characters
        char letter1 = letters.charAt(random.nextInt(letters.length()));
        char letter2 = letters.charAt(random.nextInt(letters.length()));
        // Generate five random digits
        int number = random.nextInt(100000);
        // Combine to form a license plate
        return String.format("%c%c%05d", letter1, letter2, number);
    }



    }


/* Customer John = new Customer("John Mogensen", "Marievej 2", "30292219", "john@example.com");
        customerRepo.save(John);

        Car Tesla = new Car("Tesla", "Model S", "NV24503", 650.334, "Electric", "02-01-2020", 15000, "https://static-assets.tesla.com/configurator/compositor?context=design_studio_2?&bkba_opt=1&view=FRONT34&size=1400&model=ms&options=$MDLS,$MTS14,$PMNG,$WS10,$APBS,$SC04,$CPF0,$TW01,$ICC00,$ST0Y&crop=1400,850,300,130&");
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

 */