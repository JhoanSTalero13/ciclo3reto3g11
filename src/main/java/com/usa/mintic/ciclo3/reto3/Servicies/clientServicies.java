package com.usa.mintic.ciclo3.reto3.Servicies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.usa.mintic.ciclo3.reto3.Repository.clientRepository;
import com.usa.mintic.ciclo3.reto3.Entities.Client;
import java.util.List;
import java.util.Optional;

@Service
public class clientServicies {

    @Autowired
    private clientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }
    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }
    public Client save(Client p){
        if(p.getIdClient()==null){
            return clientRepository.save(p);
        }else{
            Optional<Client> e = clientRepository.getClient(p.getIdClient());
            if(e.isPresent()){

                return p;
            }else{
                return clientRepository.save(p);
            }
        }
    }
    public Client update(Client p){
        if(p.getIdClient()== null){
            Optional<Client> cab= clientRepository.getClient(p.getIdClient());
            if(cab.isPresent()){
                clientRepository.save(p);
            }
        }
        return p;
    }

    public boolean delete(int id){
        boolean flag=false;
        Optional<Client>p= clientRepository.getClient(id);
        if(p.isPresent()){
            clientRepository.delete(p.get());
            flag=true;
        }
        return flag;

    }

}
