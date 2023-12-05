package com.martijn.CompCheck.company;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    private int id;
    private String name;
    private String city;
    private String size;
    private int cao_id;
}
