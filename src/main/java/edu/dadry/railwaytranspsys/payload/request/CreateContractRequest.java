package edu.dadry.railwaytranspsys.payload.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateContractRequest {
    private int sumOfInsurance;
    private String typeOfCargo;
    private int timeToTransport;
    private String startStation;
    private String finishStation;
    private int cost;
    private int weight;
    private LocalDate date;
}
