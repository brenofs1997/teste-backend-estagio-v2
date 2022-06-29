package com.api.testebackendoperationmanager.service;

import com.api.testebackendoperationmanager.models.EquipmentPositionHistory;
import com.api.testebackendoperationmanager.models.EquipmentState;
import com.api.testebackendoperationmanager.repositories.EquipmentPositionHistoryRepository;
import com.api.testebackendoperationmanager.repositories.EquipmentStateRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EquipmentPositionHistoryService {
    final
    EquipmentPositionHistoryRepository equipmentPositionHistoryRepository;
    public EquipmentPositionHistoryService(EquipmentPositionHistoryRepository equipmentPositionHistoryRepository) {
        this.equipmentPositionHistoryRepository = equipmentPositionHistoryRepository;
    }


    public EquipmentPositionHistory save(EquipmentPositionHistory equipmentPositionHistory) {
        equipmentPositionHistoryRepository.execute(equipmentPositionHistory.getEquipment_id(),equipmentPositionHistory.getDate(),equipmentPositionHistory.getLat(),equipmentPositionHistory.getLon());
        return equipmentPositionHistory;
    }





    public List<EquipmentPositionHistory> findAll() {
        return equipmentPositionHistoryRepository.findAll();
    }

    public Optional<EquipmentPositionHistory> findById(UUID id) {
        return equipmentPositionHistoryRepository.findById(id);
    }

    public Optional<EquipmentPositionHistory> findByLatLon(Double lat) {
         equipmentPositionHistoryRepository.findByLatLon(lat);
        Optional<EquipmentPositionHistory> equipmentPositionHistoryOptional = Optional.empty();
        return  equipmentPositionHistoryOptional;
    }

    @Transactional
    public void delete(EquipmentPositionHistory equipmentPositionHistory) {
        equipmentPositionHistoryRepository.delete(equipmentPositionHistory);
    }
}
