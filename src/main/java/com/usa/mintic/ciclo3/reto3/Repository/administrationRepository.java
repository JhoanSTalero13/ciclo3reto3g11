package com.usa.mintic.ciclo3.reto3.Repository;

import com.usa.mintic.ciclo3.reto3.Entities.Administration;
import com.usa.mintic.ciclo3.reto3.Repository.crudRepository.administrationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class administrationRepository {

    @Autowired
    private administrationCrudRepository administrationCrudRepository;
    public List<Administration> getAll(){
        return (List<Administration>)  administrationCrudRepository.findAll();
    }

    public Optional<Administration> getAdmin(int id){
        return administrationCrudRepository.findById(id);
    }
    public Administration save(Administration c){
        return  administrationCrudRepository.save(c);
    }
    public void delete(Administration c){
        administrationCrudRepository.delete(c);
    }
}
