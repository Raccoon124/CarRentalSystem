package mx.tc.project.CarRentalSystem.services;

import mx.tc.project.CarRentalSystem.models.Booking;
import mx.tc.project.CarRentalSystem.models.Car;
import mx.tc.project.CarRentalSystem.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;


    public Booking saveBooking(Booking booking){

        return bookingRepository.save(booking);
    }


    public List<Booking> getAllBooking(){
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Long id){
        return  bookingRepository.findById(id).orElse(null);
    }

    public List<Booking> getBookingByCarId(Long id){
        return bookingRepository.finBookingByIdCar(id);
    }

    public String deleteById(Long id){
        bookingRepository.deleteById(id);
        return "Booking removed";
    }

    public Booking updateBooking(Booking booking){
        Booking existingBooking = bookingRepository.findById(booking.getId()).orElse(null);
        existingBooking.setTicket(booking.getTicket());
        existingBooking.setBooking_end_time( booking.getBooking_end_time());
        existingBooking.setBooking_start_time(booking.getBooking_start_time());
        existingBooking.setDate(booking.getDate());

        return bookingRepository.save(existingBooking);
    }



}
