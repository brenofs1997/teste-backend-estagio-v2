package com.api.testebackendoperationmanager.dtos;

import javax.validation.constraints.NotBlank;

public class EquipmentStateDto {

    @NotBlank
    private String name;
    @NotBlank
    private String color;

}
