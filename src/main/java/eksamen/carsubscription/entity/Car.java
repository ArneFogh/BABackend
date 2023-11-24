package eksamen.carsubscription.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carId;

    @Column(nullable = false)
    private String carBrand;

    private String model; //

    @Column(nullable = false)
    private String licensePlate;

    @Column(nullable = false)
    private Double Price;

    @Column(nullable = false)
    private String Fuel;

    @Column(nullable = false)
    private Integer drivenKilometersAtSubscriptionStart;


    public Car() {
    }

    public Car(String carBrand, String model, String licensePlate, Double price, String fuel, Integer drivenKilometersAtSubscriptionStart) {
        this.carBrand = carBrand;
        this.model = model;
        this.licensePlate = licensePlate;
        Price = price;
        Fuel = fuel;
        this.drivenKilometersAtSubscriptionStart = drivenKilometersAtSubscriptionStart;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public String getFuel() {
        return Fuel;
    }

    public void setFuel(String fuel) {
        Fuel = fuel;
    }

    public Integer getDrivenKilometersAtSubscriptionStart() {
        return drivenKilometersAtSubscriptionStart;
    }

    public void setDrivenKilometersAtSubscriptionStart(Integer drivenKilometersAtSubscriptionStart) {
        this.drivenKilometersAtSubscriptionStart = drivenKilometersAtSubscriptionStart;
    }
}