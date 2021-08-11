package br.com.upe.hps.HPS.controllers;


import br.com.upe.hps.HPS.dtos.CreateBuildingDto;
import br.com.upe.hps.HPS.models.Building;
import br.com.upe.hps.HPS.services.BuildingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class BuildingController {

    private final BuildingService service;

    @PostMapping("/building")
    @ResponseStatus(HttpStatus.CREATED)
    public Building store(@RequestBody @Valid CreateBuildingDto createBuildingDto) {
        return this.service.store(createBuildingDto);
    }
}
