package com.usa.mintic.ciclo3.reto3.Controller;

import com.usa.mintic.ciclo3.reto3.Entities.Administration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import com.usa.mintic.ciclo3.reto3.Servicies.administrationServicies;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api/Admin")
public class AdministrationController {
    @Autowired
    administrationServicies administrationServicies;
    @GetMapping(value="/all")
    public List<Administration> getAll(){
        return administrationServicies.getAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Administration> getAdmin(@PathVariable("id") int adminId){
        return administrationServicies.getAdministration(adminId);
    }
    @PostMapping(value="/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Administration save(@RequestBody Administration p){
        return administrationServicies.save(p);
    }
    @PutMapping(value="/update")
    public Administration update (@RequestBody Administration administration) {return administrationServicies.update(administration);
    }
    @DeleteMapping(value="/{id}")
    public boolean delete (@PathVariable("id")int carId){ return administrationServicies.delete(carId);
    }
}
