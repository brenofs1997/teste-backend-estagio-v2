package com.api.testebackendoperationmanager.controllers;

import com.api.testebackendoperationmanager.dtos.EquipmentPositionHistoryDto;
import com.api.testebackendoperationmanager.models.EquipmentPositionHistory;
import com.api.testebackendoperationmanager.service.EquipmentPositionHistoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/PositionHistory")
public class EquipmentPositionHistoryController {

    final EquipmentPositionHistoryService equipmentPositionHistoryService;

    public EquipmentPositionHistoryController(EquipmentPositionHistoryService equipmentPositionHistoryService){
        this.equipmentPositionHistoryService = equipmentPositionHistoryService;
    }

    @PostMapping
    public ResponseEntity<Object> savePositionHistory(@RequestBody @Valid EquipmentPositionHistoryDto equipmentPositionHistoryDto){

        var equipmentPositionHistory = new EquipmentPositionHistory();
        System.out.println(equipmentPositionHistoryDto.getEquipment_id());

        BeanUtils.copyProperties(equipmentPositionHistoryDto, equipmentPositionHistory);
        return ResponseEntity.status(HttpStatus.CREATED).body(equipmentPositionHistoryService.save(equipmentPositionHistory));
    }

    @GetMapping("/AllPosition")
    public ResponseEntity<List<EquipmentPositionHistory>> getAllEquipmentPositionHistory(){

        return ResponseEntity.status(HttpStatus.OK).body(equipmentPositionHistoryService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getEquipmentPositionHistory(@PathVariable(value = "id") UUID id){
        Optional<EquipmentPositionHistory> equipmentPositionHistoryOptional = equipmentPositionHistoryService.findById(id);
        if (!equipmentPositionHistoryOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("equipment Position History not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(equipmentPositionHistoryOptional.get());
    }

    @DeleteMapping("/{lat}")
    public ResponseEntity<Object> deleteEquipmentPositionHistory(@PathVariable(value = "lat") Double lat){
        Optional<EquipmentPositionHistory> equipmentPositionHistoryOptional = equipmentPositionHistoryService.findByLatLon(lat);
        if (!equipmentPositionHistoryOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("equipment Position History not found.");
        }
        equipmentPositionHistoryService.delete(equipmentPositionHistoryOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Equipment position history deleted successfully.");
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEquipmentPositionHistory(@PathVariable(value = "id") UUID id,
                                                    @RequestBody @Valid EquipmentPositionHistoryDto equipmentPositionHistoryDto){
        Optional<EquipmentPositionHistory> equipmentPositionHistoryOptional = equipmentPositionHistoryService.findById(id);
        if (!equipmentPositionHistoryOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("equipment position history  not found.");
        }
        var equipmentPositionHistory = new EquipmentPositionHistory();

        BeanUtils.copyProperties(equipmentPositionHistoryDto, equipmentPositionHistory);

        equipmentPositionHistory.setEquipment_id(equipmentPositionHistoryOptional.get().getEquipment_id());
        equipmentPositionHistory.setDate(equipmentPositionHistoryOptional.get().getDate());

        return ResponseEntity.status(HttpStatus.OK).body(equipmentPositionHistoryService.save(equipmentPositionHistory));
    }
}
