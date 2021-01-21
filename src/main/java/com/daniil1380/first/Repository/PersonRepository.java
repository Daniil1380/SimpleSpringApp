package com.daniil1380.first.Repository;


import com.daniil1380.first.entity.PersonEntity;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<PersonEntity, Integer> {

}
