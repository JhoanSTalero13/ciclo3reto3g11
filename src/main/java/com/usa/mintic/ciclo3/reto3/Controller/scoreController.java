package com.usa.mintic.ciclo3.reto3.Controller;


import org.springframework.http.HttpStatus;
import com.usa.mintic.ciclo3.reto3.Entities.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.usa.mintic.ciclo3.reto3.Servicies.scoreServicies;

import java.util.List;

@RestController
@RequestMapping("/api/Score")
public class scoreController {
    @Autowired
    scoreServicies scoreServicies;
    @GetMapping("/all")
    public List<Score> getAll(){
        return scoreServicies.getAll();
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score save(@RequestBody Score p){
        return scoreServicies.save(p);
    }
    @PutMapping("/update")
    public Score update (@RequestBody Score score) {return scoreServicies.update(score);
    }
    @DeleteMapping("/{id}")
    public boolean delete (@PathVariable("id")int carId){ return scoreServicies.delete(carId);
    }
}
