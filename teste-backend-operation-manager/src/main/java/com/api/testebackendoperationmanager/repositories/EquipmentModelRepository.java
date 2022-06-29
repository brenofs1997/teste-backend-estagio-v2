package com.api.testebackendoperationmanager.repositories;

import com.api.testebackendoperationmanager.models.EquipmentModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EquipmentModelRepository extends JpaRepository<EquipmentModel, UUID> {




}
