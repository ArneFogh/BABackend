package eksamen.carsubscription.api;

import eksamen.carsubscription.entity.PickupLocation;
import eksamen.carsubscription.services.PickupLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "https://localhost:3000/")
@RestController

public class PickupLocationController {

    private final PickupLocationService pickupLocationService;

    @Autowired
    public PickupLocationController(PickupLocationService pickupLocationService) {
        this.pickupLocationService = pickupLocationService;
    }

    @GetMapping("/pickupLocation")
    public ResponseEntity<List<PickupLocation>> getAllPickupLocations() {
        List<PickupLocation> pickupLocations = pickupLocationService.getAllPickupLocations();
        return new ResponseEntity<>(pickupLocations, HttpStatus.OK);
    }

    @GetMapping("/pickupLocation/{id}")
    public ResponseEntity<PickupLocation> getPickupLocationById(@PathVariable Long id) {
        Optional<PickupLocation> pickupLocation = pickupLocationService.getPickupLocationById(id);
        return pickupLocation.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/pickupLocation/create")
    public ResponseEntity<PickupLocation> createPickupLocation(@RequestBody PickupLocation pickupLocation) {
        PickupLocation createdPickupLocation = pickupLocationService.createPickupLocation(pickupLocation);
        return new ResponseEntity<>(createdPickupLocation, HttpStatus.CREATED);
    }

    @PutMapping("/pickupLocation/update/{id}")
    public ResponseEntity<PickupLocation> updatePickupLocation(
            @PathVariable Long id,
            @RequestBody PickupLocation updatedPickupLocation) {
        PickupLocation updated = pickupLocationService.updatePickupLocation(id, updatedPickupLocation);

        return updated != null ?
                new ResponseEntity<>(updated, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/pickupLocation/delete/{id}")
    public ResponseEntity<Void> deletePickupLocation(@PathVariable Long id) {
        pickupLocationService.deletePickupLocation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
