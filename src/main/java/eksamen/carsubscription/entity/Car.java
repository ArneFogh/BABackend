package eksamen.carsubscription.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bilId;

    @Column(nullable = false)
    private String bilmaerke;

    private String model; //

    @Column(nullable = false)
    private String registreringsnummer;

    @Column(nullable = false)
    private Double indkoebspris;

    @Column(nullable = false)
    private String braendstof;

    @Column(nullable = false)
    private Integer koertKmVedAbonnemtStart;


    public Car() {
    }

    public Car(String bilmaerke, String model, String registreringsnummer, Double indkoebspris, String braendstof, Integer koertKmVedAbonnemtStart) {
        this.bilmaerke = bilmaerke;
        this.model = model;
        this.registreringsnummer = registreringsnummer;
        this.indkoebspris = indkoebspris;
        this.braendstof = braendstof;
        this.koertKmVedAbonnemtStart = koertKmVedAbonnemtStart;
    }

    public String getBilmaerke() {
        return bilmaerke;
    }

    public void setBilmaerke(String bilmaerke) {
        this.bilmaerke = bilmaerke;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistreringsnummer() {
        return registreringsnummer;
    }

    public void setRegistreringsnummer(String registreringsnummer) {
        this.registreringsnummer = registreringsnummer;
    }

    public Double getIndkoebspris() {
        return indkoebspris;
    }

    public void setIndkoebspris(Double indkoebspris) {
        this.indkoebspris = indkoebspris;
    }

    public String getBraendstof() {
        return braendstof;
    }

    public void setBraendstof(String braendstof) {
        this.braendstof = braendstof;
    }

    public Integer getKoertKmVedAbonnemtStart() {
        return koertKmVedAbonnemtStart;
    }

    public void setKoertKmVedAbonnemtStart(Integer koertKmVedAbonnemtStart) {
        this.koertKmVedAbonnemtStart = koertKmVedAbonnemtStart;
    }
}
