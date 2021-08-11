package br.com.upe.hps.HPS.services;

import br.com.upe.hps.HPS.dtos.CreateBuildingDto;
import br.com.upe.hps.HPS.mappers.IBuildingMapper;
import br.com.upe.hps.HPS.models.Building;
import br.com.upe.hps.HPS.repositories.BuildingRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class BuildingService {

    private final BuildingRepository repository;
    private final IBuildingMapper buildingMapper = IBuildingMapper.INSTANCE;

    public Building store(CreateBuildingDto createBuildingDto) {
        Building buildingToSave = buildingMapper.toModel(createBuildingDto);
        return repository.save(buildingToSave);
    }
}
