package edu.dadry.railwaytranspsys.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Dispatcher dispatcher;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private User user;

    private int sumOfInsurance;
    private String typeOfCargo;
    private int timeToTransport;
    private String startStation;
    private String finishStation;
    private int cost;
    private int weight;
    private LocalDate date;

}