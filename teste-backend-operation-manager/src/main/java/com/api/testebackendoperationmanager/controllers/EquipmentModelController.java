package com.api.testebackendoperationmanager.controllers;

import com.api.testebackendoperationmanager.dtos.EquipmentDto;
import com.api.testebackendoperationmanager.dtos.EquipmentModelDto;
import com.api.testebackendoperationmanager.dtos.EquipmentPositionHistoryDto;
import com.api.testebackendoperationmanager.models.EquipmentModel;
import com.api.testebackendoperationmanager.models.EquipmentPositionHistory;
import com.api.testebackendoperationmanager.service.EquipmentModelService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/Model")
public class EquipmentModelController {
    final EquipmentModelService equipmentModelService;

    public EquipmentModelController(EquipmentModelService equipmentModelService){
        this.equipmentModelService = equipmentModelService;
    }

    @PostMapping
    public ResponseEntity<Object> saveEquipmentModel(@RequestBody @Valid EquipmentModelDto equipmentModelDto){

        var equipmentModel = new EquipmentModel();
        BeanUtils.copyProperties(equipmentModelDto, equipmentModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(equipmentModelService.save(equipmentModel));
    }

    @GetMapping("/AllModels")
    public ResponseEntity<Page<EquipmentModel>> getAllEquipmentModel(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(equipmentModelService.findAll(pageable));
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> getEquipmentModel(@PathVariable(value = "id") UUID id){
        Optional<EquipmentModel> equipmentModelOptional = equipmentModelService.findById(id);
        if (!equipmentModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("equipment Model not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(equipmentModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEquipmentModel(@PathVariable(value = "id") UUID id){
        Optional<EquipmentModel> equipmentModelOptional= equipmentModelService.findById(id);
        if (!equipmentModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("equipment MOdel not found.");
        }
        equipmentModelService.delete(equipmentModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Equipment MOdel deleted successfully.");
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEquipmentModel(@PathVariable(value = "id") UUID id,
                                                                 @RequestBody @Valid EquipmentModelDto equipmentModelDto){
        Optional<EquipmentModel> equipmentModelOptional= equipmentModelService.findById(id);
        if (!equipmentModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("equipment MOdel not found.");
        }
        var equipmentModel = new EquipmentModel();

        BeanUtils.copyProperties(equipmentModelDto, equipmentModel);

        equipmentModel.setId(equipmentModelOptional.get().getId());


        return ResponseEntity.status(HttpStatus.OK).body(equipmentModelService.save(equipmentModel));
    }


}
