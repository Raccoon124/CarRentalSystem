package mx.tc.project.CarRentalSystem.controllers;

import mx.tc.project.CarRentalSystem.models.BookingModel;
import mx.tc.project.CarRentalSystem.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @GetMapping(path = "/allBooking")
    public ArrayList<BookingModel> getAllBooking(){
        return bookingService.getAllBooking();
    }

    @GetMapping(path="/{id}")
    public Optional<BookingModel> getById(@PathVariable("id")Long id){
        return this.bookingService.getById(id);
    }


}
