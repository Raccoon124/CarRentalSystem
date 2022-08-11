package mx.tc.project.CarRentalSystem.controllers;

import mx.tc.project.CarRentalSystem.exeption.ResourceNotFoundException;
import mx.tc.project.CarRentalSystem.models.CarModel;
import mx.tc.project.CarRentalSystem.repositories.CarRepository;
import mx.tc.project.CarRentalSystem.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/cars")
@CrossOrigin
public class CarController {

    @Autowired
    CarService carService;
    CarRepository carRepository;


    //get all cars
    @GetMapping(path = "/allCars")
    public ArrayList<CarModel> getAllCars(){
        return carService.getAllCars();
    }

    // get employee by id rest api
    @GetMapping(path="/{id}")
    public Optional<CarModel> getById(@PathVariable("id")Long id){
        return this.carService.getByIDCar(id);
    }

    @GetMapping("/model/query")
    public ArrayList<CarModel> getCarByModel(@RequestParam("model") Integer model){
        return this.carService.getByModel(model);
    }

    @GetMapping("/name/query")
    public ArrayList<CarModel> getByName(@RequestParam("name") String name){
        return this.carService.getByName(name);
    }


    @PutMapping("/cars/{id}")
    public ResponseEntity<CarModel> updateEmployee(@PathVariable Long id, @RequestBody CarModel carDetails){
        CarModel carModel = carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        carModel.setName(carModel.getName());
        carModel.setModel(carModel.getModel());
        carModel.setAvailable(carModel.isAvailable());
        carModel.setClassification(carModel.getClassification());


        CarModel updatedEmployee = carRepository.save(carModel);
        return ResponseEntity.ok(updatedEmployee);
    }




}
