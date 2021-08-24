package br.com.upe.hps.HPS.services;

import br.com.upe.hps.HPS.dtos.CreateBuildingDto;
import br.com.upe.hps.HPS.dtos.ListBuildingDto;
import br.com.upe.hps.HPS.dtos.ShowBuildingDto;
import br.com.upe.hps.HPS.dtos.UpdateBuildingDto;
import br.com.upe.hps.HPS.mappers.IAddressMapper;
import br.com.upe.hps.HPS.mappers.IBuildingMapper;
import br.com.upe.hps.HPS.models.Address;
import br.com.upe.hps.HPS.models.Building;
import br.com.upe.hps.HPS.repositories.BuildingRepository;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class BuildingService {

    private final BuildingRepository repository;
    private final IBuildingMapper buildingMapper = IBuildingMapper.INSTANCE;
    private final IAddressMapper addressMapper = IAddressMapper.INSTANCE;

    public Building store(CreateBuildingDto createBuildingDto) {
        Address addressToSave = addressMapper.toModel(createBuildingDto);
        Building buildingToSave = buildingMapper.toModel(createBuildingDto);
        buildingToSave.setAddress(addressToSave);
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
        building.setOwner(updateBuildingDto.getOwner());
        return repository.save(building);
    }
}
