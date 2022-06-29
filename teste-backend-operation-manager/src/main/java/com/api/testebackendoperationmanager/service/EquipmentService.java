package com.api.testebackendoperationmanager.service;

import com.api.testebackendoperationmanager.models.Equipment;
import com.api.testebackendoperationmanager.models.EquipmentModel;
import com.api.testebackendoperationmanager.repositories.EquipmentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class EquipmentService {
    final
    EquipmentRepository equipmentRepository;
    public EquipmentService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }


    public Equipment save(Equipment equipment) {
        return  equipmentRepository.save(equipment);
    }

    public Page<Equipment> findAll(Pageable pageable) {
        return equipmentRepository.findAll(pageable);
    }


    public Optional<Equipment> findById(UUID id) {
        return  equipmentRepository.findById(id);
    }

    @Transactional
    public void delete(Equipment equipment) {
        equipmentRepository.delete(equipment);
    }
}
