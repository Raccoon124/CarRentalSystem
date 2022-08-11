package mx.tc.project.CarRentalSystem.services;

import mx.tc.project.CarRentalSystem.models.CarModel;
import mx.tc.project.CarRentalSystem.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;
    public ArrayList<CarModel> getAllCars(){
        return (ArrayList<CarModel>) carRepository.findAll();
    }
    public Optional<CarModel> getByIDCar(Long id){
        return carRepository.findById(id);
    }
    public ArrayList<CarModel> getByModel(Integer model){
        return carRepository.findByModel(model);
    }
    public ArrayList<CarModel> getByName(String name){
        return carRepository.findByName(name);
    }

}
