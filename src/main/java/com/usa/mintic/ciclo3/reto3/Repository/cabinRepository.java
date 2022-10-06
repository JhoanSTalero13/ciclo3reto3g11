package com.usa.mintic.ciclo3.reto3.Repository;

import com.usa.mintic.ciclo3.reto3.Entities.Cabin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.usa.mintic.ciclo3.reto3.Repository.crudRepository.cabinCrudRepository;
import java.util.List;
import java.util.Optional;

@Repository
public class cabinRepository {

    @Autowired
    private cabinCrudRepository cabinCrudRepository;

    public List<Cabin> getAll(){
        return (List<Cabin>) cabinCrudRepository.findAll();
    }

    public Optional<Cabin> getCabin(int id){
        return cabinCrudRepository.findById(id);
    }
    public Cabin save(Cabin c){
        return cabinCrudRepository.save(c);
    }
    public void delete(Cabin c){
        cabinCrudRepository.delete(c);
    }
}
