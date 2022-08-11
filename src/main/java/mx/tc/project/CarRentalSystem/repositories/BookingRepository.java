package mx.tc.project.CarRentalSystem.repositories;

import mx.tc.project.CarRentalSystem.models.BookingModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends CrudRepository<BookingModel,Long> {

}
