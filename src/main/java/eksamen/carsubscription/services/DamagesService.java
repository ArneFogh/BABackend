package eksamen.carsubscription.services;

import eksamen.carsubscription.entity.Damages;
import eksamen.carsubscription.entity.LeaseAgreement;
import eksamen.carsubscription.repository.IDamages;
import eksamen.carsubscription.repository.ILeaseAgreement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DamagesService {

    private final IDamages damagesRepository;
    private final ILeaseAgreement leaseAgreementRepo;

    @Autowired
    public DamagesService(IDamages damagesRepository, ILeaseAgreement leaseAgreementRepo) {
        this.damagesRepository = damagesRepository;
        this.leaseAgreementRepo = leaseAgreementRepo;
    }

    public List<Damages> getAllDamages() {
        return damagesRepository.findAll();
    }

    public Optional<Damages> getDamagesById(Long id) {
        return damagesRepository.findById(id);
    }

    public Damages createDamages(Damages damages) throws ChangeSetPersister.NotFoundException {
        Optional<LeaseAgreement> leaseAgreementOptional = leaseAgreementRepo.findById(damages.getLeaseAgreement().getLeaseId());

        if (leaseAgreementOptional.isPresent()) {
            LeaseAgreement leaseAgreement = leaseAgreementOptional.get();
            damages.setLeaseAgreement(leaseAgreement);
            return damagesRepository.save(damages);
        } else {

            throw new ChangeSetPersister.NotFoundException();
        }
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
