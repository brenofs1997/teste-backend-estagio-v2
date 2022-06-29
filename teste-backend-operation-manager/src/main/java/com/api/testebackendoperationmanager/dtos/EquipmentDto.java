package com.api.testebackendoperationmanager.dtos;

import com.api.testebackendoperationmanager.models.EquipmentModel;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EquipmentDto {
    @NotBlank
    private String name;

    private EquipmentModel equipmentModel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EquipmentModel getEquipmentModel() {
        return equipmentModel;
    }

    public void setEquipmentModel(EquipmentModel equipmentModel) {
        this.equipmentModel = equipmentModel;
    }
}
