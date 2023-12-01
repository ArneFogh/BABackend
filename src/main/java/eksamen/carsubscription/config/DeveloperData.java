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
        customerRepo.save(defaultCustomer);

        // Method to generate a random license plate
        String licensePlate = generateRandomLicensePlate();

        // For the Car instance
        Car car1 = new Car("Chevrolet", "Spark", licensePlate, 190000.00, "Benzin", "10-06-2020", 14815, "https://autodominicana.rent/wp-content/uploads/2023/07/Chevrolet-Spark.webp");
        Car car2 = new Car("Kia", "Niro", licensePlate, 330000.0, "Elektrisk", "29-07-2021", 21532, "https://www.motortrend.com/uploads/sites/5/2020/06/2020-kia-niro-copy.png");
        Car car3 = new Car("Volvo", "XC60", licensePlate, 680000.0, "Elektrisk", "18-06-2022", 19755, "https://images.dealer.com/ddc/vehicles/2023/Volvo/XC60%20Recharge%20Plug-In%20Hybrid/SUV/perspective/front-left/2023_76.png");
        Car car4 = new Car("Land Rover", "Defender D200", "AF76890", 1400000.0, "Diesel", "24-01-2022", 15899, "https://assets.meinauto.de/f_auto,q_auto:eco,w_1200/prod/landrover/defender/4/3suv-hse/landrover_21defender90edn1st4wdsu4b_angularfront_gondwana-stone-metallic");
        Car car5 = new Car("Porsche", "Panamera", "BC23451", 1609000.0, "Hybrid", "07-06-2021", 19404, "https://platform.cstatic-images.com/xlarge/in/v2/stock_photos/b2cf8532-1c6f-4d30-8d6a-bcd65561491b/94a5b315-b5dd-4595-a6d7-d9159ecc5e46.png");
        Car car6 = new Car("Mitsubishi", "ASX", "DE94532", 350000.0, "Benzin", "06-06-2021", 16912, "https://www.leasingmarkt.de/wplm/wp-content/uploads/2020/03/mitsubishi-asx-top-frontansicht.png");
        Car car7 = new Car("Volkswagen", "ID3", "AF34567", 400000.0, "Elektrisk", "19-04-2021", 15530, "https://www.electrifying.com/files/OBioRr46YqxuA9gU/ID3--ProS.png");
        Car car8 = new Car("Renault", "Austral", "BC56789", 540000.0, "Benzin", "10-06-2019", 19817, "https://hapi.hessel.dk/assets/2641_319e7715-af21-4cc5-b90c-10006504220e/%7BIMAGE-SIZE%7D/austral-tech-YNM-2.png");
        Car car9 = new Car("Land Rover", "Range Rover Evoque", "DE67890", 657900.0, "Hybrid", "03-04-2020", 20967, "https://www.motortrend.com/uploads/sites/10/2019/08/2020-land-rover-range-rover-evoque-first-edition-suv-angular-front.png");
        Car car10 = new Car("Mercedes", "E300", "AF78901", 630000.0, "Hybrid", "19-06-2021", 24170, "https://hapi.hessel.dk/assets/2641_847a3ac6-79a4-42b1-bf59-99610b1b162c/%7BIMAGE-SIZE%7D/E-st-197U.webp");
        Car car11 = new Car("BMW", "i3 Charged Plus", "GH89012", 225000.0, "Elektrisk", "31-03-2021", 13846, "https://billeder.bilbasen.dk/bilinfo/fb95bdc5-ac67-46a9-a0b3-a016aed7dd09.png?class=S1600X1600");
        Car car12 = new Car("BMW", "i4 M50 xDrive", "IJ90123", 589000.0, "Elektrisk", "28-04-2020", 21170, "https://bmw-canada-public.s3.ca-central-1.amazonaws.com/production/inventory-vehicle/WBY33AW01RFR53309_HighRes_Front.png");
        Car car13 = new Car("Porsche", "Taycan", "KL01234", 1690000.0, "Elektrisk", "13-03-2020", 19224, "https://d2ivfcfbdvj3sm.cloudfront.net/7fc965ab77efe6e0fa62e4ca1ea7673bb65a4154031e3d8e88cb10/stills_0640_png/MY2022/50058/50058_st0640_116.png");
        Car car14 = new Car("Volkswagen", "T-Roc", "MN12345", 250000.0, "Diesel", "08-06-2020", 28460, "https://images.prismic.io/shacarlacca/ZmVhODg5NGYtYWRkOC00Nzk3LWJiMDMtYjQ5ODUxODJhZmU2_2e230c52-77c1-4a28-a401-a411d6cfb170rulecf-450.png?auto=compress,format&rect=0,0,450,300&w=450&h=300");
        Car car15 = new Car("Ford", "Kuga", "OP23456", 356454.0, "Hybrid", "24-01-2020", 30079, "https://firstlease.dk/media/gsji2wmy/ford-kuga-2020-01.png");
        Car car16 = new Car("Volvo", "V60", "QR34567", 457000.0, "Hybrid", "26-12-2019", 19991, "https://gomore.imgix.net/uploads/leasing/offer/image/29537/volvo-v60-plug-in-hybrid_GoMore_1675437984.png?ixlib=rails-2.1.2&w=410&h=273&fit=clip&auto=format,compress&dpr=2.625");
        Car car17 = new Car("Audi", "A5", "ST45678", 664900.0, "Benzin", "30-12-2019", 30092, "https://mediaservice.audi.com/media/fast/H4sIAAAAAAAAAFvzloG1tIiBOTrayfuvpGh6-m1zJgaGigIGBgZGoDhTtNOaz-I_2DhCHsCEtzEwF-SlMwJZKUycmbmJ6an6QD4_I3taTmV-aUkxO0grz6s5mzjO37oztWXu-ZcKa7PnsrE4lTCwAnUxugEJ5j1Agm8bkOCUZgCTIPOmgogeEJ_JgZmBgbUCyIhkAAE-vtKinILEosRcvfLMlJIMQQ0DIoEwu4triKOnTzAAFU2r-ukAAAA?wid=850");
        Car car18 = new Car("Volvo", "XC90", "UV56789", 780000.0, "Diesel", "02-01-2020", 22540, "https://cas.volvocars.com/image/dynamic/MY24_2317/256/exterior-v3/RC/73500/RC0000/R121/TC05/_/2G03/TJ02/TP05/LR02/JT02/GR02/T102/NP03/TM04/JG02/_/EV02/JB0C/T21C/LF05/_/VP07/UF02/FH02/_/_/_/TR02/_/default.png?market=gb&client=gox-graph%7Ccar-selector-ssr&angle=4&bg=00000000&w=768&bg=f0f0f0");
        Car car19 = new Car("Tesla", "Model S", "WX67890", 1040000.0, "Elektrisk", "02-01-2020", 26553, "https://static-assets.tesla.com/configurator/compositor?context=design_studio_2?&bkba_opt=1&view=FRONT34&size=1400&model=ms&options=$MDLS,$MTS14,$PMNG,$WS10,$APBS,$SC04,$CPF0,$TW01,$ICC00,$ST0Y&crop=1400,850,300,130&");

        Stream.of(car1, car2, car3, car4, car5, car6, car7, car8, car9, car10, car11, car12, car13, car14, car15, car16, car17, car18, car19)
                .forEach(carRepo::save);


        //Pickup / DropOff Locations
        PickupLocation defaultPickupLocation = new PickupLocation("Vibeholmsvej 31, 2605 Brøndby", "John Doe", "22334455");
        pickupLocationRepo.save(defaultPickupLocation);
        PickupLocation defaultDropoffLocation = new PickupLocation("Vibeholmsvej 31, 2605 Brøndby", "John Doe", "22334455");
        pickupLocationRepo.save(defaultDropoffLocation);


        // For the LeaseAgreement instance, use the default customer if necessary
        LeaseAgreement leaseAgreement1 = new LeaseAgreement(
                defaultCustomer,       // customer - using the default one created above
                car1,                  // car
                defaultPickupLocation, // pickupLocation - Assuming this is the same for pickup and dropoff
                defaultDropoffLocation, // dropoffLocation
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
                defaultDropoffLocation, // Assuming dropoff is the same as pickup for example
                "29-07-2021",
                "29-07-2023",
                4500,
                18000,
                21532
        );

        LeaseAgreement leaseAgreement3 = new LeaseAgreement(
                defaultCustomer,
                car3,
                defaultPickupLocation,
                defaultDropoffLocation,
                "18-06-2022",
                "18-06-2023",
                5000,
                18000,
                19755
        );

        LeaseAgreement leaseAgreement4 = new LeaseAgreement(
                defaultCustomer, // Replace with actual customer object
                car4,
                defaultPickupLocation, // Replace with actual location object
                defaultDropoffLocation, // Replace with actual location object
                "21-12-2022",
                "21-12-2023",
                6500,
                18000,
                15899
        );

        LeaseAgreement leaseAgreement5 = new LeaseAgreement(
                defaultCustomer, // Replace with actual customer object
                car5,
                defaultPickupLocation, // Replace with actual location object
                defaultDropoffLocation, // Replace with actual location object
                "19-08-2021",
                "19-08-2023",
                9500,
                36000,
                19404
        );

        LeaseAgreement leaseAgreement6 = new LeaseAgreement(
                defaultCustomer, // Replace with actual customer object
                car6,
                defaultPickupLocation, // Replace with actual location object
                defaultDropoffLocation, // Replace with actual location object
                "29-12-2021",
                "29-12-2023",
                4000,
                36000,
                16912
        );

        LeaseAgreement leaseAgreement7 = new LeaseAgreement(
                defaultCustomer, // Replace with actual customer object
                car7,
                defaultPickupLocation, // Replace with actual location object
                defaultDropoffLocation, // Replace with actual location object
                "30-07-2021",
                "30-07-2023",
                4800,
                36000,
                15530
        );

        LeaseAgreement leaseAgreement8 = new LeaseAgreement(
                defaultCustomer, // Replace with actual customer object
                car8,
                defaultPickupLocation, // Replace with actual location object
                defaultDropoffLocation, // Replace with actual location object
                "06-02-2021",
                "06-02-2023",
                5000,
                36000,
                19817
        );

        LeaseAgreement leaseAgreement9 = new LeaseAgreement(
                defaultCustomer, // Replace with actual customer object
                car9,
                defaultPickupLocation, // Replace with actual location object
                defaultDropoffLocation, // Replace with actual location object
                "03-02-2021",
                "03-02-2023",
                5000,
                36000,
                20967
        );

        LeaseAgreement leaseAgreement10 = new LeaseAgreement(
                defaultCustomer, // Replace with actual customer object
                car10,
                defaultPickupLocation, // Replace with actual location object
                defaultDropoffLocation, // Replace with actual location object
                "03-12-2021",
                "03-12-2023",
                5200,
                36000,
                24170
        );

        LeaseAgreement leaseAgreement11 = new LeaseAgreement(
                defaultCustomer, // Replace with actual customer object
                car11,
                defaultPickupLocation, // Replace with actual location object
                defaultDropoffLocation, // Replace with actual location object
                "07-01-2021",
                "07-01-2023",
                5300,
                36000,
                13846
        );

        LeaseAgreement leaseAgreement12 = new LeaseAgreement(
                defaultCustomer, // Replace with actual customer object
                car12,
                defaultPickupLocation, // Replace with actual location object
                defaultDropoffLocation, // Replace with actual location object
                "15-07-2021",
                "15-07-2023",
                5500,
                36000,
                21170
        );

        LeaseAgreement leaseAgreement13 = new LeaseAgreement(
                defaultCustomer, // Replace with actual customer object
                car13,
                defaultPickupLocation, // Replace with actual location object
                defaultDropoffLocation, // Replace with actual location object
                "25-07-2020",
                "25-07-2023",
                10000,
                36000,
                19224
        );

        LeaseAgreement leaseAgreement14 = new LeaseAgreement(
                defaultCustomer, // Replace with actual customer object
                car14,
                defaultPickupLocation, // Replace with actual location object
                defaultDropoffLocation, // Replace with actual location object
                "31-07-2020",
                "31-07-2023",
                8000,
                54000,
                28460
        );

        LeaseAgreement leaseAgreement15 = new LeaseAgreement(
                defaultCustomer, // Replace with actual customer object
                car15,
                defaultPickupLocation, // Replace with actual location object
                defaultDropoffLocation, // Replace with actual location object
                "15-02-2020",
                "15-02-2023",
                5000,
                54000,
                30079
        );

        LeaseAgreement leaseAgreement16 = new LeaseAgreement(
                defaultCustomer, // Replace with actual customer object
                car16,
                defaultPickupLocation, // Replace with actual location object
                defaultDropoffLocation, // Replace with actual location object
                "25-06-2020",
                "25-06-2023",
                4000,
                54000,
                19991
        );

        LeaseAgreement leaseAgreement17 = new LeaseAgreement(
                defaultCustomer, // Replace with actual customer object
                car17,
                defaultPickupLocation, // Replace with actual location object
                defaultDropoffLocation, // Replace with actual location object
                "21-11-2020",
                "21-11-2023",
                7800,
                54000,
                30092
        );

        LeaseAgreement leaseAgreement18 = new LeaseAgreement(
                defaultCustomer, // Replace with actual customer object
                car18,
                defaultPickupLocation, // Replace with actual location object
                defaultDropoffLocation, // Replace with actual location object
                "20-04-2020",
                "20-04-2023",
                5000,
                54000,
                22540
        );

        LeaseAgreement leaseAgreement19 = new LeaseAgreement(
                defaultCustomer, // Replace with actual customer object
                car19,
                defaultPickupLocation, // Replace with actual location object
                defaultDropoffLocation, // Replace with actual location object
                "13-06-2020",
                "13-06-2023",
                8000,
                54000,
                26553
        );

        Stream.of(
                leaseAgreement1, leaseAgreement2, leaseAgreement3, leaseAgreement4, leaseAgreement5,
                leaseAgreement6, leaseAgreement7, leaseAgreement8, leaseAgreement9, leaseAgreement10,
                leaseAgreement11, leaseAgreement12, leaseAgreement13, leaseAgreement14, leaseAgreement15,
                leaseAgreement16, leaseAgreement17, leaseAgreement18, leaseAgreement19
        ).forEach(leaseAgreementRepo::save);




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