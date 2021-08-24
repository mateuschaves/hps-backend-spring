package br.com.upe.hps.HPS.repositories;

import br.com.upe.hps.HPS.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
