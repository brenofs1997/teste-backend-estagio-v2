package com.api.testebackendoperationmanager.service;

import com.api.testebackendoperationmanager.models.EquipmentState;
import com.api.testebackendoperationmanager.repositories.EquipmentStateRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EquipmentStateService {
    final
    EquipmentStateRepository equipmentStateRepository;
    public EquipmentStateService(EquipmentStateRepository equipmentStateRepository) {
        this.equipmentStateRepository = equipmentStateRepository;
    }


    public EquipmentState save(EquipmentState equipmentState) {
        return  equipmentStateRepository.save(equipmentState);
    }


    public Page<EquipmentState> findAll(Pageable pageable) {
        return equipmentStateRepository.findAll(pageable);
    }
}
