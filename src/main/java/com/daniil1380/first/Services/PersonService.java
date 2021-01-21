package com.daniil1380.first.Services;

import com.daniil1380.first.Repository.PersonRepository;
import com.daniil1380.first.entity.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonService {

    @Autowired
    PersonRepository repo;

    public void save(PersonEntity customer) {
        repo.save(customer);
    }

    public List<PersonEntity> listAll() {
        return (List<PersonEntity>) repo.findAll();
    }

    public PersonEntity get(Integer id) {
        return repo.findById(id).get();
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
