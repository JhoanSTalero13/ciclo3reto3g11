package com.usa.mintic.ciclo3.reto3.Controller;


import com.usa.mintic.ciclo3.reto3.Entities.Cabin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.usa.mintic.ciclo3.reto3.Servicies.cabinServicies;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api/Cabin")
public class cabinController {
    @Autowired
    cabinServicies cabinServicies;

    @GetMapping(value="/all")
    public List<Cabin> getAll(){
        return cabinServicies.getAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Cabin> getCabin(@PathVariable("id") int cabinId){
        return cabinServicies.getCabin(cabinId);
    }
    @PostMapping(value="/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cabin save(@RequestBody  Cabin p){
        return cabinServicies.save(p);
    }
    @PutMapping(value="/update")
    public Cabin update (@RequestBody Cabin cabin) {return cabinServicies.update(cabin);
    }
    @DeleteMapping(value="/{id}")
    public boolean delete (@PathVariable("id")int carId){ return cabinServicies.delete(carId);
    }
}
