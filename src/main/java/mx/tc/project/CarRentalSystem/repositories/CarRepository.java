package mx.tc.project.CarRentalSystem.repositories;

import mx.tc.project.CarRentalSystem.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Car findCarByName(String name);

}
