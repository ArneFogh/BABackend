package eksamen.carsubscription.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "damages")
public class Damages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long damage_id;

    @ManyToOne
    @JoinColumn(name = "carId", nullable = false)
    private Car car;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private String registrationDate;

    @Column(nullable = false)
    private Double repairCost;

    // Constructors, Getters, and Setters...


    public Damages() {
    }

    public Damages(Car car, String description, String registrationDate, Double repairCost) {
        this.car = car;
        this.description = description;
        this.registrationDate = registrationDate;
        this.repairCost = repairCost;
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
}

