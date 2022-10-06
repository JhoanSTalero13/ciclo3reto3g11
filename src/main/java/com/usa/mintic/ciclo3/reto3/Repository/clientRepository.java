package com.usa.mintic.ciclo3.reto3.Repository;


import com.usa.mintic.ciclo3.reto3.Entities.Client;
import com.usa.mintic.ciclo3.reto3.Repository.crudRepository.clientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class clientRepository {

    @Autowired
    private clientCrudRepository clientCrudRepository;
    public List<Client> getAll(){
        return (List<Client>)  clientCrudRepository.findAll();
    }
    public Optional<Client> getClient(int id){
        return clientCrudRepository.findById(id);
    }
    public Client save(Client c){
        return  clientCrudRepository.save(c);
    }
    public void delete(Client c){
        clientCrudRepository.delete(c);
    }
}
