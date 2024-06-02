package edu.dadry.railwaytranspsys.payload.request;

import lombok.Data;

@Data
public class CreateDispatcherRequest {
    private String name;
    private String surname;
    private String middlename;
    private String company;
    private String address;
    private String phoneNumber;
    private int experience;
}
