package br.com.upe.hps.HPS.mappers;

import br.com.upe.hps.HPS.dtos.CreateBuildingDto;
import br.com.upe.hps.HPS.models.Address;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface IAddressMapper {

    IAddressMapper INSTANCE = Mappers.getMapper(IAddressMapper.class);

    @Mapping(target = "id", source = "id")
    Address toModel(CreateBuildingDto createBuildingDto);
}
