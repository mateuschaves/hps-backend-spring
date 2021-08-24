package br.com.upe.hps.HPS.mappers;

import br.com.upe.hps.HPS.dtos.CreateBuildingDto;
import br.com.upe.hps.HPS.dtos.UpdateBuildingDto;
import br.com.upe.hps.HPS.models.Building;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface IBuildingMapper {

    IBuildingMapper INSTANCE = Mappers.getMapper(IBuildingMapper.class);

    @Mapping(target = "owner", source = "owner")
    Building toModel(CreateBuildingDto createBuildingDto);

}