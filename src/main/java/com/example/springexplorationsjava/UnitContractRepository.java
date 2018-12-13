package com.example.springexplorationsjava;

import org.springframework.data.repository.CrudRepository;

public interface UnitContractRepository extends CrudRepository<UnitContractEntity, Long> {  //<Entity, id type>


}
