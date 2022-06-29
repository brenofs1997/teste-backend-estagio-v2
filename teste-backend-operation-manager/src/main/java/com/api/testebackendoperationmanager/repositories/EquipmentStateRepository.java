package com.api.testebackendoperationmanager.repositories;

import com.api.testebackendoperationmanager.models.EquipmentState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EquipmentStateRepository extends JpaRepository<EquipmentState, UUID> {



}
