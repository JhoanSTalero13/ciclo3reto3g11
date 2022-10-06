package com.usa.mintic.ciclo3.reto3.Controller;


import com.usa.mintic.ciclo3.reto3.Entities.Cabin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.usa.mintic.ciclo3.reto3.Servicies.cabinServicies;

import java.util.List;

@RestController
@RequestMapping("/api/Cabin")
public class cabinController {
    @Autowired
    cabinServicies cabinServicies;

    @GetMapping("/all")
    public List<Cabin> getAll(){
        return cabinServicies.getAll();
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cabin save(@RequestBody  Cabin p){
        return cabinServicies.save(p);
    }
    @PutMapping("/update")
    public Cabin update (@RequestBody Cabin cabin) {return cabinServicies.update(cabin);
    }
    @DeleteMapping("/{id}")
    public boolean delete (@PathVariable("id")int carId){ return cabinServicies.delete(carId);
    }
}
