package br.com.upe.hps.HPS.services;

import br.com.upe.hps.HPS.dtos.CreateBuildingDto;
import br.com.upe.hps.HPS.dtos.ListBuildingDto;
import br.com.upe.hps.HPS.dtos.ShowBuildingDto;
import br.com.upe.hps.HPS.dtos.UpdateBuildingDto;
import br.com.upe.hps.HPS.mappers.IBuildingMapper;
import br.com.upe.hps.HPS.models.Building;
import br.com.upe.hps.HPS.repositories.BuildingRepository;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class BuildingService {

    private final BuildingRepository repository;
    private final IBuildingMapper buildingMapper = IBuildingMapper.INSTANCE;

    public Building store(CreateBuildingDto createBuildingDto) {
        Building buildingToSave = buildingMapper.toModel(createBuildingDto);
        return repository.save(buildingToSave);
    }

    public List<ListBuildingDto> index() {
        List<Building> buildings = repository.findAll();
        return ListBuildingDto.toDto(buildings);
    }

    public Building retrieve(ShowBuildingDto showBuildingDto) throws NotFoundException {
        return repository.findById(Long.parseLong(showBuildingDto.getId())).orElseThrow(() -> new NotFoundException("Apartamento não encontrado"));
    }

    public void destroy(ShowBuildingDto showBuildingDto) throws NotFoundException {
        this.retrieve(showBuildingDto);
        repository.deleteById(Long.parseLong(showBuildingDto.getId()));
    }

    public Building update(UpdateBuildingDto updateBuildingDto) throws NotFoundException {
        ShowBuildingDto showBuildingDto = new ShowBuildingDto(Long.toString(updateBuildingDto.getId()));
        Building building = this.retrieve(showBuildingDto);
        building.setBuilding(updateBuildingDto.getBuilding());
        building.setDescription(updateBuildingDto.getDescription());
        building.setPrice(updateBuildingDto.getPrice());
        building.setStreet(updateBuildingDto.getStreet());
        building.setCity(updateBuildingDto.getCity());
        building.setCep(updateBuildingDto.getCep());
        building.setNeighborhood(updateBuildingDto.getNeighborhood());
        building.setOwner(updateBuildingDto.getOwner());
        building.setUf(updateBuildingDto.getUf());
        building.setNumber(updateBuildingDto.getNumber());
        building.setReferencePoint(updateBuildingDto.getReferencePoint());
        return repository.save(building);
    }
}
