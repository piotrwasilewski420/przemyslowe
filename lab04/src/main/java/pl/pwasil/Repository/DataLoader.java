package pl.pwasil.Repository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class DataLoader implements CommandLineRunner {

    private final List<Car> cars = new ArrayList<>();

    @Override
    public void run(String... args) throws Exception {
        cars.add(new Car("Mazda", UUID.randomUUID()));
        cars.add(new Car("Toyota", UUID.randomUUID()));
        cars.add(new Car("Honda", UUID.randomUUID()));
        cars.add(new Car("Nissan", UUID.randomUUID()));
        cars.add(new Car("Subaru", UUID.randomUUID()));
        cars.add(new Car("Mitsubishi", UUID.randomUUID()));
        cars.add(new Car("Suzuki", UUID.randomUUID()));
    }

    public List<Car> getCars() {
        return cars;
    }
}
