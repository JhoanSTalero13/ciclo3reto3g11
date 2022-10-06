package com.usa.mintic.ciclo3.reto3.Servicies;
import com.usa.mintic.ciclo3.reto3.Entities.Message;
import com.usa.mintic.ciclo3.reto3.Repository.messageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class messageServicies {
    @Autowired
    private messageRepository messageRepository;

    public List<Message> getAll() {
        return messageRepository.getAll();
    }

    public Optional<Message> getMessage(int id) {
        return messageRepository.getMessage(id);
    }

    public Message save(Message p) {
        if (p.getIdMessage() == null) {
            return messageRepository.save(p);
        } else {
            Optional<Message> e = messageRepository.getMessage(p.getIdMessage());
            if (e.isPresent()) {

                return p;
            } else {
                return messageRepository.save(p);
            }
        }
    }
    public Message update(Message c){
        if(c.getIdMessage()== null){
            Optional<Message> cab= messageRepository.getMessage(c.getIdMessage());
            if(cab.isPresent()){
                messageRepository.save(c);
            }
        }
        return c;
    }

    public boolean delete(int id){
        boolean flag=false;
        Optional<Message>p= messageRepository.getMessage(id);
        if(p.isPresent()){
            messageRepository.delete(p.get());
            flag=true;
        }
        return flag;

    }


}
