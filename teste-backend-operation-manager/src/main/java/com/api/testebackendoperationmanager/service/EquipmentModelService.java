package com.api.testebackendoperationmanager.service;

import com.api.testebackendoperationmanager.models.EquipmentModel;
import com.api.testebackendoperationmanager.models.EquipmentPositionHistory;
import com.api.testebackendoperationmanager.repositories.EquipmentModelRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class EquipmentModelService {
    final
    EquipmentModelRepository equipmentModelRepository;
    public EquipmentModelService(EquipmentModelRepository equipmentModelRepository) {
        this.equipmentModelRepository = equipmentModelRepository;
    }

    public EquipmentModel save(EquipmentModel equipmentModel) {
        return  equipmentModelRepository.save(equipmentModel);
    }

    public Page<EquipmentModel> findAll(Pageable pageable) {
        return equipmentModelRepository.findAll(pageable);
    }

    public Optional<EquipmentModel> findById(UUID id) {
        return  equipmentModelRepository.findById(id);
    }

    @Transactional
    public void delete(EquipmentModel equipmentModel) {
        equipmentModelRepository.delete(equipmentModel);
    }

}
