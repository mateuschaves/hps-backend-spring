package br.com.upe.hps.HPS.services;

import br.com.upe.hps.HPS.dtos.CreateBuildingDto;
import br.com.upe.hps.HPS.mappers.IAddressMapper;
import br.com.upe.hps.HPS.models.Address;
import br.com.upe.hps.HPS.repositories.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class AddressService {

    private final AddressRepository repository;
    private final IAddressMapper addressMapper = IAddressMapper.INSTANCE;

    public Address store(CreateBuildingDto createBuildingDto) {
        Address addressToSave = addressMapper.toModel(createBuildingDto);
        return repository.save(addressToSave);
    }
}
