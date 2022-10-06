package com.usa.mintic.ciclo3.reto3.Repository;
import com.usa.mintic.ciclo3.reto3.Entities.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.usa.mintic.ciclo3.reto3.Repository.crudRepository.messageCrudRepository;
import java.util.List;
import java.util.Optional;

@Repository
public class messageRepository {
    @Autowired
    private messageCrudRepository messageCrudRepository;
    public List<Message> getAll(){
        return (List<Message>)  messageCrudRepository.findAll();
    }
    public Optional<Message> getMessage(int id){
        return messageCrudRepository.findById(id);
    }
    public Message save(Message c){
        return  messageCrudRepository.save(c);
    }
    public void delete(Message c){
        messageCrudRepository.delete(c);
    }

}
