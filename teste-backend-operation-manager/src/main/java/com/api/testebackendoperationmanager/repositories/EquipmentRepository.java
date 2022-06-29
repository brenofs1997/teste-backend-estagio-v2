package com.api.testebackendoperationmanager.repositories;

import com.api.testebackendoperationmanager.models.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EquipmentRepository extends JpaRepository<Equipment, UUID> {

}
