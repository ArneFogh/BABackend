package eksamen.carsubscription.api;

import eksamen.carsubscription.entity.Damages;
import eksamen.carsubscription.services.DamagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "https://localhost:3000/")
@RestController

public class DamagesController {

    private final DamagesService damagesService;

    @Autowired
    public DamagesController(DamagesService damagesService) {
        this.damagesService = damagesService;
    }

    @GetMapping("/damages")
    public ResponseEntity<List<Damages>> getAllDamages() {
        List<Damages> damages = damagesService.getAllDamages();
        return new ResponseEntity<>(damages, HttpStatus.OK);
    }

    @GetMapping("/damages/{id}")
    public ResponseEntity<Damages> getDamagesById(@PathVariable Long id) {
        Optional<Damages> damages = damagesService.getDamagesById(id);
        return damages.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/damages/create")
    public ResponseEntity<Damages> createDamages(@RequestBody Damages damages) throws ChangeSetPersister.NotFoundException {
        Damages createdDamages = damagesService.createDamages(damages);
        return new ResponseEntity<>(createdDamages, HttpStatus.CREATED);
    }


    @PutMapping("/damages/update/{id}")
    public ResponseEntity<Damages> updateDamages(@PathVariable Long id, @RequestBody Damages updatedDamages) {
        Damages updated = damagesService.updateDamages(id, updatedDamages);
        return updated != null ?
                new ResponseEntity<>(updated, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/damages/delete/{id}")
    public ResponseEntity<Void> deleteDamages(@PathVariable Long id) {
        damagesService.deleteDamages(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
