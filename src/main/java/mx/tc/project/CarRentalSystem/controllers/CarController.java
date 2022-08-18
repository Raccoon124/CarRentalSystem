package mx.tc.project.CarRentalSystem.controllers;


import mx.tc.project.CarRentalSystem.models.Car;
import mx.tc.project.CarRentalSystem.services.BookingService;
import mx.tc.project.CarRentalSystem.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;
    private BookingService bookingService;

    @PostMapping("/addCar")
    public Car addCar(@RequestBody Car car) {
        return carService.saveCar(car);
    }

    @GetMapping("/allCars")
    public List<Car> findAllCar() {

        return carService.getAllCars();
    }

    @GetMapping("/{id}")
    public Car finCarById(@PathVariable Long id) {
        return carService.getCarById(id);
    }

    @GetMapping("/name/{name}")
    public Car findCarByName(@PathVariable String name) {
        return carService.getCarByName(name);
    }

    @PutMapping("/update")
    public Car updateCar(@RequestBody Car car) {
        return carService.updateCar(car);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCar(@PathVariable Long id) {
        return carService.deleteById(id);
    }
}
