package pl.pwasil.Service;

import org.springframework.stereotype.Service;
import pl.pwasil.Repository.Car;
import pl.pwasil.Repository.DataLoader;
import java.util.List;
import java.util.UUID;

@Service
public class CarsService {
    private final List<Car> cars;
    public CarsService(DataLoader dataLoader) {
        this.cars = dataLoader.getCars();
    }
    public List<Car> getAllCars() {
        return cars;
    }
    public Car addCar(Car carName) {
        Car car = new Car(carName.getName());
        car.setId(UUID.randomUUID());
        cars.add(car);
        return car;
    }
    public Car getCarById(String id) {
        return cars.stream()
                .filter(car -> car.getId().toString().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Car not found"));
    }

    public Car deleteCar(String id) {
        try {
            Car car = getCarById(id);
            cars.remove(car);
            return car;
        } catch (RuntimeException e) {
            throw new RuntimeException("Car not found");
        }
    }
    public Car updateCar(Car carToUpdate, Car car) {
        carToUpdate.setName(car.getName());
        return carToUpdate;
    }
}
