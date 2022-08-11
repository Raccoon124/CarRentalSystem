package mx.tc.project.CarRentalSystem.repositories;

import mx.tc.project.CarRentalSystem.models.CarModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CarRepository extends CrudRepository<CarModel, Long> {
    public abstract ArrayList<CarModel> findByName(String name);
    public abstract ArrayList<CarModel> findByModel(Integer model);


}
