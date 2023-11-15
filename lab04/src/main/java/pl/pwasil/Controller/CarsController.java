package pl.pwasil.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.pwasil.Service.CarsService;
import pl.pwasil.Repository.Car;

import java.net.URI;

@RestController
@RequestMapping("/cars")
public class CarsController {
    private final CarsService carsService;
    public CarsController(CarsService carsService) {
        this.carsService = carsService;
    }
    @GetMapping
    public ResponseEntity getAllCars() {
        return ResponseEntity.ok(carsService.getAllCars());
    }
    @GetMapping("/{id}")
    public ResponseEntity getCarById(@PathVariable("id") String id) {
        try {
            Car car = carsService.getCarById(id);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(new Message(e.getMessage()), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(carsService.getCarById(id));
    }
    @PostMapping
    public ResponseEntity addCar(@RequestBody Car car) {
        Car createdCar = carsService.addCar(car);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdCar.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCar(@PathVariable("id") String id) {
        try {
            Car car = carsService.getCarById(id);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(new Message(e.getMessage()), HttpStatus.NOT_FOUND);
        }
        carsService.deleteCar(id);
        return ResponseEntity.accepted().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity updateCar(@PathVariable("id") String id, @RequestBody Car car) {
        try {
            Car carToUpdate = carsService.getCarById(id);
            carsService.updateCar(carToUpdate, car);
            return ResponseEntity.accepted().build();
        } catch (RuntimeException e) {
            return new ResponseEntity<>(new Message(e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }
}
