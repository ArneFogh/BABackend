package eksamen.carsubscription.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "lease_agreements")
public class LeaseAgreement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lease_id;

    @ManyToOne
    @JoinColumn(name = "customerId", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "carId", nullable = false)
    private Car car;

    @ManyToOne
    @JoinColumn(name = "pickupLocationId", nullable = false)
    private PickupLocation pickupLocation;

    @ManyToOne
    @JoinColumn(name = "dropoffLocationId", nullable = false)
    private PickupLocation dropoffLocation;

    @Column(nullable = false)
    private String startDate;

    @Column(nullable = false)
    private String endDate;

    @Column(nullable = false)
    private Integer monthlySubscriptionPrice;

    @Column(nullable = false)
    private Integer agreedSubscriptionKM;

    @Column(nullable = false)
    private Integer kmDriven;

    // Constructors, Getters, and Setters...


    public LeaseAgreement() {
    }

    public LeaseAgreement(Customer customer, Car car, PickupLocation pickupLocation, PickupLocation dropoffLocation, String startDate, String endDate, Integer monthlySubscriptionPrice, Integer agreedSubscriptionKM, Integer kmDriven) {
        this.customer = customer;
        this.car = car;
        this.pickupLocation = pickupLocation;
        this.dropoffLocation = dropoffLocation;
        this.startDate = startDate;
        this.endDate = endDate;
        this.monthlySubscriptionPrice = monthlySubscriptionPrice;
        this.agreedSubscriptionKM = agreedSubscriptionKM;
        this.kmDriven = kmDriven;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public PickupLocation getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(PickupLocation pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public PickupLocation getDropoffLocation() {
        return dropoffLocation;
    }

    public void setDropoffLocation(PickupLocation dropoffLocation) {
        this.dropoffLocation = dropoffLocation;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getMonthlySubscriptionPrice() {
        return monthlySubscriptionPrice;
    }

    public void setMonthlySubscriptionPrice(Integer monthlySubscriptionPrice) {
        this.monthlySubscriptionPrice = monthlySubscriptionPrice;
    }

    public Integer getAgreedSubscriptionKM() {
        return agreedSubscriptionKM;
    }

    public void setAgreedSubscriptionKM(Integer agreedSubscriptionKM) {
        this.agreedSubscriptionKM = agreedSubscriptionKM;
    }

    public Integer getKmDriven() {
        return kmDriven;
    }

    public void setKmDriven(Integer kmDriven) {
        this.kmDriven = kmDriven;
    }

    public Long getLease_id() {
        return lease_id;
    }

    public void setLeaseId(Long lease_id) {
        this.lease_id = lease_id;
    }
}

