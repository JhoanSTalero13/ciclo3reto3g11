package com.usa.mintic.ciclo3.reto3.Servicies;

import com.usa.mintic.ciclo3.reto3.Entities.Score;
import com.usa.mintic.ciclo3.reto3.Repository.scoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class scoreServicies {
    @Autowired
    private scoreRepository scoreRepository;
    public List<Score> getAll(){
        return scoreRepository.getAll();
    }
    public Optional<Score> getScore (int id){
        return scoreRepository.getScore(id);
    }
    public Score save(Score p){
        if(p.getIdScore()==null){
            return scoreRepository.save(p);
        }else{
            Optional<Score> e = scoreRepository.getScore(p.getIdScore());
            if(e.isPresent()){
                return p;
            }else{
                return scoreRepository.save(p);
            }
        }
    }

    public Score update(Score c){
        if(c.getIdScore()== null){
            Optional<Score> cab= scoreRepository.getScore(c.getIdScore());
            if(cab.isPresent()){
                scoreRepository.save(c);
            }
        }
        return c;
    }

    public boolean delete(int id){
        boolean flag=false;
        Optional<Score>p= scoreRepository.getScore(id);
        if(p.isPresent()){
            scoreRepository.delete(p.get());
            flag=true;
        }
        return flag;

    }


}
