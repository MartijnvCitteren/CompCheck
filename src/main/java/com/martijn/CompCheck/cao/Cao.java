package com.martijn.CompCheck.cao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cao {
    private int id;
    private String name;
    private int weeklyWorkHours;
    private int PtoHoursTotal;
    private int PtoHoursSellable;
    private float bonus;
    private float pensionTotal;
    private float pensionEmployer;
}
