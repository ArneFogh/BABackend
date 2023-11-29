package eksamen.carsubscription.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "pickup_locations")
public class PickupLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String address;

    @Column(nullable = false, length = 255)
    private String contactPerson;

    @Column(nullable = false, length = 20)
    private String phone;

    public PickupLocation() {
    }

    public PickupLocation(String address, String contactPerson, String phone) {
        this.address = address;
        this.contactPerson = contactPerson;
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
