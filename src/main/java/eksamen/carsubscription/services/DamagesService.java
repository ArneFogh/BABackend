package eksamen.carsubscription.services;

import eksamen.carsubscription.entity.Damages;
import eksamen.carsubscription.repository.IDamages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DamagesService {

    private final IDamages damagesRepository;

    @Autowired
    public DamagesService(IDamages damagesRepository) {
        this.damagesRepository = damagesRepository;
    }

    public List<Damages> getAllDamages() {
        return damagesRepository.findAll();
    }

    public Optional<Damages> getDamagesById(Long id) {
        return damagesRepository.findById(id);
    }

    public Damages createDamages(Damages damages) {
        return damagesRepository.save(damages);
    }

    public Damages updateDamages(Long id, Damages updatedDamages) {
        Optional<Damages> existingDamagesOptional = damagesRepository.findById(id);

        if (existingDamagesOptional.isPresent()) {
            Damages existingDamages = existingDamagesOptional.get();


            existingDamages.setDescription(updatedDamages.getDescription());
            existingDamages.setRegistrationDate(updatedDamages.getRegistrationDate());
            existingDamages.setRepairCost(updatedDamages.getRepairCost());


            if (!existingDamages.getCar().equals(updatedDamages.getCar())) {
                existingDamages.setCar(updatedDamages.getCar());
            }


            return damagesRepository.save(existingDamages);
        } else {
            return null;
        }
    }


    public void deleteDamages(Long id) {
        damagesRepository.deleteById(id);
    }
}
