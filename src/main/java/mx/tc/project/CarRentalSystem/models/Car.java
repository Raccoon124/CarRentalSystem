package mx.tc.project.CarRentalSystem.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "car")

public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;


    @NotNull
    @Column(name = "available")
    private boolean available;

    @NotNull
    @Column(name = "classification")
    private String classification;


    @NotNull
    @Column(name = "model")
    private int model;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "brand")
    private String brand;


    @NotNull
    @Column(name = "price")
    private int price;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "id")
    private Set<Booking> bookings;


}
