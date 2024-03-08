package com.martijn.CompCheck.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "company", schema = "public")
public class Company {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name ="city")
    private String city;

    @Column(name = "size")
    private String size;

    @Column(name = "cao_id")
    @Nullable
    private Integer cao_id;

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getCao_id() {
        return cao_id;
    }

    @Nullable
    public void setCao_id(Integer cao_id) {
        this.cao_id = cao_id;
    }
}
