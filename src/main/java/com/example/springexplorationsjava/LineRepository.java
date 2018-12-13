package com.example.springexplorationsjava;

import org.springframework.data.repository.CrudRepository;

public interface LineRepository extends CrudRepository<LineEntity, Long> {  //<Entity, id type>


}