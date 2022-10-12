package com.usa.mintic.ciclo3.reto3.Controller;

import com.usa.mintic.ciclo3.reto3.Entities.Client;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import com.usa.mintic.ciclo3.reto3.Servicies.messageServicies;
import com.usa.mintic.ciclo3.reto3.Entities.Message;

@RestController
@RequestMapping(value="/api/Message")
public class messageController {

    @Autowired
    messageServicies messageServicies;
    @GetMapping(value="/all")
    public List<Message> getAll(){
        return messageServicies.getAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Message> getMessage(@PathVariable("id") int messageId){
        return messageServicies.getMessage(messageId);
    }

    @PostMapping(value="/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message p){
        return messageServicies.save(p);
    }
    @PutMapping(value="/update")
    public Message update (@RequestBody Message message) {return messageServicies.update(message);
    }
    @DeleteMapping(value="/{id}")
    public boolean delete (@PathVariable("id")int carId){ return messageServicies.delete(carId);
    }
}
