package eksamen.carsubscription.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "damages")
public class Damages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long damageId;

    @ManyToOne
    @JoinColumn(name = "carId", nullable = false)
    private Car car;

    @ManyToOne
    @JoinColumn(name = "leaseId", nullable = false)
    private LeaseAgreement leaseAgreement;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private String registrationDate;

    @Column(nullable = false)
    private Double repairCost;

    // Constructors, Getters, and Setters...


    public Damages() {
    }

    public Damages(Car car, String description, String registrationDate, Double repairCost, LeaseAgreement leaseAgreement) {
        this.car = car;
        this.description = description;
        this.registrationDate = registrationDate;
        this.repairCost = repairCost;
        this.leaseAgreement = leaseAgreement;

    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Double getRepairCost() {
        return repairCost;
    }

    public void setRepairCost(Double repairCost) {
        this.repairCost = repairCost;
    }

    public Long getDamage_id() {
        return damageId;
    }

    public void setDamage_id(Long damage_id) {
        this.damageId = damage_id;
    }

    public LeaseAgreement getLeaseAgreement() {
        return leaseAgreement;
    }

    public void setLeaseAgreement(LeaseAgreement leaseAgreement) {
        this.leaseAgreement = leaseAgreement;
    }
}

