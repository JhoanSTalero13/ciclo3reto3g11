package com.usa.mintic.ciclo3.reto3.Controller;

import com.usa.mintic.ciclo3.reto3.Entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.usa.mintic.ciclo3.reto3.Servicies.clientServicies;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value ="/api/Client")
public class clientController {
    @Autowired
    clientServicies clientServicies;
    @GetMapping(value ="/all")
    public List<Client> getAll(){
        return clientServicies.getAll();
    }
    @GetMapping(value = "/{id}")
    public Optional<Client> getCliente(@PathVariable("id") int clientId){
        return clientServicies.getClient(clientId);
    }

    @PostMapping(value = "/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody  Client p){
        return clientServicies.save(p);
    }
    @PutMapping(value="/update")
    public Client update (@RequestBody Client client) {return clientServicies.update(client);
    }
    @DeleteMapping(value="/{id}")
    public boolean delete (@PathVariable("id")int carId){ return clientServicies.delete(carId);
    }
}
