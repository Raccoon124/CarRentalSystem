package mx.tc.project.CarRentalSystem.services;

import mx.tc.project.CarRentalSystem.models.Car;
import mx.tc.project.CarRentalSystem.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {


    @Autowired
    private CarRepository carRepository;

    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car getCarById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    public Car getCarByName(String name) {
        return carRepository.findCarByName(name);
    }

    public String deleteById(Long id) {

        carRepository.deleteById(id);
        return "Car removed";
    }


    public Car updateCar(Car car) {
        Car existingCar = carRepository.findById(car.getId()).orElse(null);
        assert existingCar != null;
        existingCar.setAvailable(car.isAvailable());
        existingCar.setClassification(car.getClassification());
        existingCar.setModel(car.getModel());
        existingCar.setName(car.getName());
        existingCar.setPrice(car.getPrice());
        return carRepository.save(existingCar);
    }


}
