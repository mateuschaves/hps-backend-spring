package br.com.upe.hps.HPS.dtos;

import javax.validation.constraints.NotEmpty;

public class ShowBuildingDto {
    private String id;

    public ShowBuildingDto() {}

    public ShowBuildingDto(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
