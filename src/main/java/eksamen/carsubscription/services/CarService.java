package eksamen.carsubscription.services;

import eksamen.carsubscription.entity.Car;
import eksamen.carsubscription.repository.ICar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final ICar carRepository;

    @Autowired
    public CarService(ICar carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Optional<Car> getCarById(Long id) {
        return carRepository.findById(id);
    }

    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    public Car updateCar(Long id, Car updatedCar) {
        Optional<Car> existingCarOptional = carRepository.findById(id);

        if (existingCarOptional.isPresent()) {
            Car existingCar = existingCarOptional.get();
            existingCar.setCarBrand(updatedCar.getCarBrand());
            existingCar.setModel(updatedCar.getModel());
            existingCar.setLicensePlate(updatedCar.getLicensePlate());
            existingCar.setPrice(updatedCar.getPrice());
            existingCar.setFuel(updatedCar.getFuel());
            existingCar.setDrivenKilometersAtSubscriptionStart(updatedCar.getDrivenKilometersAtSubscriptionStart());
            existingCar.setUrlPhoto(updatedCar.getUrlPhoto());

            return carRepository.save(existingCar);
        }

        return null;
    }


    public boolean deleteCar(Long id) {
        if (carRepository.existsById(id)) {
            carRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
