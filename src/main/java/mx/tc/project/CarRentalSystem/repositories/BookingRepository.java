package mx.tc.project.CarRentalSystem.repositories;

import mx.tc.project.CarRentalSystem.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {


    @Query("select b from Booking b where b.car.id = :var_param")
    public abstract List<Booking> finBookingByIdCar(@Param("var_param")Long id);




}
