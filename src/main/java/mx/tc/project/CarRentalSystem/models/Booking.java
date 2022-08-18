package mx.tc.project.CarRentalSystem.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "ticket")
    private Long ticket;

    @Temporal(TemporalType.TIMESTAMP)
    @Type(type = "date")
    @Column(name = "booking_end_time")
    private Date booking_end_time;

    @Temporal(TemporalType.TIMESTAMP)
    @Type(type = "date")
    @Column(name = "booking_start_time")
    private Date booking_start_time;

    @Temporal(TemporalType.TIMESTAMP)
    @Type(type = "date")
    @Column(name = "booking_date")
    private Date date;

    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "fk_id_car")
    private Car car;

    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "fk_id_user")
    private User user;




}
