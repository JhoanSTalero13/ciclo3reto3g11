package com.usa.mintic.ciclo3.reto3.Controller;

import com.usa.mintic.ciclo3.reto3.Entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.usa.mintic.ciclo3.reto3.Servicies.clientServicies;

import java.util.List;

@RestController
@RequestMapping("/api/Client")
public class clientController {
    @Autowired
    clientServicies clientServicies;
    @GetMapping("/all")
    public List<Client> getAll(){
        return clientServicies.getAll();
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody  Client p){
        return clientServicies.save(p);
    }
    @PutMapping("/update")
    public Client update (@RequestBody Client client) {return clientServicies.update(client);
    }
    @DeleteMapping("/{id}")
    public boolean delete (@PathVariable("id")int carId){ return clientServicies.delete(carId);
    }
}
