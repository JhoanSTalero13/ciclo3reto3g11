package com.usa.mintic.ciclo3.reto3.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.usa.mintic.ciclo3.reto3.Servicies.messageServicies;
import com.usa.mintic.ciclo3.reto3.Entities.Message;

@RestController
@RequestMapping("/api/Message")
public class messageController {

    @Autowired
    messageServicies messageServicies;
    @GetMapping("/all")
    public List<Message> getAll(){
        return messageServicies.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message p){
        return messageServicies.save(p);
    }
    @PutMapping("/update")
    public Message update (@RequestBody Message message) {return messageServicies.update(message);
    }
    @DeleteMapping("/{id}")
    public boolean delete (@PathVariable("id")int carId){ return messageServicies.delete(carId);
    }
}
