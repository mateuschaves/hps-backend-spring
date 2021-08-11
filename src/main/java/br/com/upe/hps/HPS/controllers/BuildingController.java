package br.com.upe.hps.HPS.controllers;


import br.com.upe.hps.HPS.dtos.CreateBuildingDto;
import br.com.upe.hps.HPS.dtos.ListBuildingDto;
import br.com.upe.hps.HPS.dtos.ShowBuildingDto;
import br.com.upe.hps.HPS.dtos.UpdateBuildingDto;
import br.com.upe.hps.HPS.exceptions.BuildingNotFoundException;
import br.com.upe.hps.HPS.models.Building;
import br.com.upe.hps.HPS.services.BuildingService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class BuildingController {

    private final BuildingService service;

    @PostMapping("/building")
    @ResponseStatus(HttpStatus.CREATED)
    public Building store(@RequestBody @Valid CreateBuildingDto createBuildingDto) {
        return this.service.store(createBuildingDto);
    }

    @GetMapping("/building")
    @ResponseStatus(HttpStatus.OK)
    public List<ListBuildingDto> index() {
        return this.service.index();
    }

    @GetMapping("/building/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Building retrieve(@PathVariable("id") String id) throws BuildingNotFoundException {
        ShowBuildingDto showBuildingDto = new ShowBuildingDto(id);
        try {
            return this.service.retrieve(showBuildingDto);
        } catch (NotFoundException error) {
            throw new BuildingNotFoundException();
        }
    }

    @DeleteMapping("/building/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable("id") String id) throws BuildingNotFoundException {
        ShowBuildingDto showBuildingDto = new ShowBuildingDto(id);
        try {
            this.service.destroy(showBuildingDto);
        } catch (NotFoundException error) {
            throw new BuildingNotFoundException();
        }
    }

    @PutMapping("/building/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") Long id, @RequestBody @Valid UpdateBuildingDto updateBuildingDto) throws BuildingNotFoundException {
        try {
            updateBuildingDto.setId(id);
            this.service.update(updateBuildingDto);
        } catch (NotFoundException error) {
            throw new BuildingNotFoundException();
        }
    }
}
