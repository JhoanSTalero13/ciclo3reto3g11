package com.usa.mintic.ciclo3.reto3.Controller;


import org.springframework.http.HttpStatus;
import com.usa.mintic.ciclo3.reto3.Entities.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.usa.mintic.ciclo3.reto3.Servicies.scoreServicies;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api/Score")
public class scoreController {
    @Autowired
    scoreServicies scoreServicies;
    @GetMapping(value="/all")
    public List<Score> getAll(){
        return scoreServicies.getAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Score> getScore(@PathVariable("id") int scoreId){
        return scoreServicies.getScore(scoreId);
    }
    @PostMapping(value="/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score save(@RequestBody Score p){
        return scoreServicies.save(p);
    }
    @PutMapping(value="/update")
    public Score update (@RequestBody Score score) {return scoreServicies.update(score);
    }
    @DeleteMapping(value="/{id}")
    public boolean delete (@PathVariable("id")int carId){ return scoreServicies.delete(carId);
    }
}
