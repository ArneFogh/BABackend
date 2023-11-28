package eksamen.carsubscription.services;

import eksamen.carsubscription.entity.PickupLocation;
import eksamen.carsubscription.repository.IPickupLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PickupLocationService {

    private final IPickupLocation pickupLocationRepository;

    @Autowired
    public PickupLocationService(IPickupLocation pickupLocationRepository) {
        this.pickupLocationRepository = pickupLocationRepository;
    }

    public List<PickupLocation> getAllPickupLocations() {
        return pickupLocationRepository.findAll();
    }

    public Optional<PickupLocation> getPickupLocationById(Long id) {
        return pickupLocationRepository.findById(id);
    }

    public PickupLocation createPickupLocation(PickupLocation pickupLocation) {
        return pickupLocationRepository.save(pickupLocation);
    }

    public PickupLocation updatePickupLocation(Long id, PickupLocation updatedPickupLocation) {
        if (pickupLocationRepository.existsById(id)) {

            return pickupLocationRepository.save(updatedPickupLocation);
        } else {
            // Behandl fejl, f.eks. kast en exception eller returner null
            return null;
        }
    }

    public void deletePickupLocation(Long id) {
        pickupLocationRepository.deleteById(id);
    }
}
