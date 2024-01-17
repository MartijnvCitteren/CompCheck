package com.martijn.CompCheck.cao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cao", schema ="public")
public class Cao {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="weekly_work_hours")
    private int weeklyWorkHours;

    @Column(name="pto_hours_total")
    private int PtoHoursTotal;

    @Column(name="pto_hours_sellable")
    private int PtoHoursSellable;

    @Column(name="bonus")
    private float bonus;

    @Column(name="pension_total")
    private float pensionTotalPercentage;

    @Column(name="pension_employer")
    private float pensionEmployerPercentage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeeklyWorkHours() {
        return weeklyWorkHours;
    }

    public void setWeeklyWorkHours(int weeklyWorkHours) {
        this.weeklyWorkHours = weeklyWorkHours;
    }

    public int getPtoHoursTotal() {
        return PtoHoursTotal;
    }

    public void setPtoHoursTotal(int ptoHoursTotal) {
        PtoHoursTotal = ptoHoursTotal;
    }

    public int getPtoHoursSellable() {
        return PtoHoursSellable;
    }

    public void setPtoHoursSellable(int ptoHoursSellable) {
        PtoHoursSellable = ptoHoursSellable;
    }

    public float getBonus() {
        return bonus;
    }

    public void setBonus(float bonus) {
        this.bonus = bonus;
    }

    public float getPensionTotalPercentage() {
        return pensionTotalPercentage;
    }

    public void setPensionTotalPercentage(float pensionTotalPercentage) {
        this.pensionTotalPercentage = pensionTotalPercentage;
    }

    public float getPensionEmployerPercentage() {
        return pensionEmployerPercentage;
    }

    public void setPensionEmployerPercentage(float pensionEmployerPercentage) {
        this.pensionEmployerPercentage = pensionEmployerPercentage;
    }
}
