package com.api.testebackendoperationmanager.repositories;

import com.api.testebackendoperationmanager.models.EquipmentPositionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public interface EquipmentPositionHistoryRepository extends JpaRepository<EquipmentPositionHistory,UUID> {
    @Modifying
    @Query(value = "INSERT INTO equipment_position_history (equipment_id,date,lat,lon) values (:equipment_id,:date,:lat,:lon)", nativeQuery = true)
    @Transactional
    void execute(@Param("equipment_id") UUID equipment_id, @Param("date")LocalDate date,@Param("lat") Double lat,@Param("lon") Double lon);

    @Modifying
    @Query(value = "SELECT * FROM equipment_position_history WHERE lat = ':lat'", nativeQuery = true)
    @Transactional
    void findByLatLon(@Param("lat") Double lat);

}
