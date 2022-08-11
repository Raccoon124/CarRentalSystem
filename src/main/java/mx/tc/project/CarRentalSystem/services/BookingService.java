package mx.tc.project.CarRentalSystem.services;

import mx.tc.project.CarRentalSystem.models.BookingModel;
import mx.tc.project.CarRentalSystem.models.CarModel;
import mx.tc.project.CarRentalSystem.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

    public ArrayList<BookingModel> getAllBooking() {
        return (ArrayList<BookingModel>) bookingRepository.findAll();
    }

    public Optional<BookingModel> getById(long booking_id) {
        return bookingRepository.findById(booking_id);
    }

    public boolean deleteById(Long booking_id){
        try {
            bookingRepository.deleteById(booking_id);
            return true;
        }catch (Exception err){
            return false;
        }
    }



}
