package com.usa.mintic.ciclo3.reto3.Repository;

import com.usa.mintic.ciclo3.reto3.Entities.Score;
import com.usa.mintic.ciclo3.reto3.Repository.crudRepository.scoreCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class scoreRepository {
    @Autowired
    private scoreCrudRepository scoreCrudRepository;
    public List<Score> getAll(){
        return (List<Score>)  scoreCrudRepository.findAll();
    }

    public Optional<Score> getScore(int id){
        return scoreCrudRepository.findById(id);
    }
    public Score save(Score c){
        return  scoreCrudRepository.save(c);
    }
    public void delete(Score c){
        scoreCrudRepository.delete(c);
    }
}
