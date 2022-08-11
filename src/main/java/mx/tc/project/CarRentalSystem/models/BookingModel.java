package mx.tc.project.CarRentalSystem.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(name = "booking")
public class BookingModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(name = "booking_start_time")
    private LocalDateTime booking_start_time;

    @Column(name = "booking_end_time")
    private LocalDateTime booking_end_time;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_booking_car_id")
    private CarModel carModel;

    @Column(name = "booking_price")
    private int booking_price;

    @Column(name = "booking_date")
    private LocalDateTime booking_date;

}
