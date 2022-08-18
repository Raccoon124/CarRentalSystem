package mx.tc.project.CarRentalSystem.controllers;

import mx.tc.project.CarRentalSystem.models.Booking;
import mx.tc.project.CarRentalSystem.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.xml.ws.http.HTTPBinding;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/allBooking")
    public List<Booking> findAllBooking() {
        return bookingService.getAllBooking();
    }

    @GetMapping("/car/{id}")
    public List<Booking> getBookingByCarId(@PathVariable Long id) {
        return bookingService.getBookingByCarId(id);
    }
    @GetMapping("/{id}")
    public Booking finBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }

    @PostMapping("/addBooking")
    public Booking addBooking(@RequestBody Booking booking) {
        return bookingService.saveBooking(booking);
    }

    @PutMapping("/update")
    public Booking updateBooking(@RequestBody Booking booking) {
        return bookingService.updateBooking(booking);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBooking(@PathVariable Long id) {
        return bookingService.deleteById(id);
    }

}
