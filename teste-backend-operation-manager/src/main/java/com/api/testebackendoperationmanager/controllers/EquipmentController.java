package com.api.testebackendoperationmanager.controllers;

import com.api.testebackendoperationmanager.dtos.EquipmentDto;
import com.api.testebackendoperationmanager.dtos.EquipmentModelDto;
import com.api.testebackendoperationmanager.dtos.EquipmentPositionHistoryDto;
import com.api.testebackendoperationmanager.models.Equipment;
import com.api.testebackendoperationmanager.models.EquipmentModel;
import com.api.testebackendoperationmanager.service.EquipmentModelService;
import com.api.testebackendoperationmanager.service.EquipmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/equipment")
public class EquipmentController {

    final EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService){
        this.equipmentService = equipmentService;
    }

    @PostMapping
    public ResponseEntity<Object> saveEquipment(@RequestBody @Valid EquipmentDto equipmentDto){

        var equipment = new Equipment();
        BeanUtils.copyProperties(equipmentDto, equipment);
        return ResponseEntity.status(HttpStatus.CREATED).body(equipmentService.save(equipment));
    }

    @GetMapping("/AllEquipments")
    public ResponseEntity<Page<Equipment>> getAllEquipment(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(equipmentService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getEquipment(@PathVariable(value = "id") UUID id){
        Optional<Equipment> equipmentOptional = equipmentService.findById(id);
        if (!equipmentOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("equipment  not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(equipmentOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEquipment(@PathVariable(value = "id") UUID id){
        Optional<Equipment> equipmentOptional= equipmentService.findById(id);
        if (!equipmentOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("equipment not found.");
        }
        equipmentService.delete(equipmentOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Equipment deleted successfully.");
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEquipment(@PathVariable(value = "id") UUID id,
                                                                 @RequestBody @Valid EquipmentDto equipmentDto){
        Optional<Equipment> equipmentOptional= equipmentService.findById(id);
        if (!equipmentOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("equipment not found.");
        }
        var equipment = new Equipment();

        BeanUtils.copyProperties(equipmentDto, equipment);

        equipment.setId(equipmentOptional.get().getId());


        return ResponseEntity.status(HttpStatus.OK).body(equipmentService.save(equipment));
    }
}
