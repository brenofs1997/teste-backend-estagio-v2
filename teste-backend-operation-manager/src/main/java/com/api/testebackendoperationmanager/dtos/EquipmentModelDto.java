package com.api.testebackendoperationmanager.dtos;

import javax.validation.constraints.NotBlank;

public class EquipmentModelDto {

    @NotBlank
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
