package com.api.testebackendoperationmanager.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "equipment_position_history")
public class EquipmentPositionHistory {


    @Id
    private UUID equipment_id;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private Double  lat;

    @Column(nullable = false)
    private Double  lon;

    public UUID getEquipment_id() {
        return equipment_id;
    }

    public void setEquipment_id(UUID equipment_id) {
        this.equipment_id = equipment_id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }
}
