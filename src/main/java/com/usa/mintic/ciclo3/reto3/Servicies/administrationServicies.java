package com.usa.mintic.ciclo3.reto3.Servicies;

import com.usa.mintic.ciclo3.reto3.Entities.Administration;
import com.usa.mintic.ciclo3.reto3.Entities.Message;
import com.usa.mintic.ciclo3.reto3.Repository.administrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class administrationServicies {
    @Autowired
    private administrationRepository administrationRepository;
    public List<Administration> getAll(){
        return administrationRepository.getAll();
    }
    public Optional<Administration> getAdministration (int id){
        return administrationRepository.getAdmin(id);
    }
    public Administration save(Administration p){
        if(p.getId()==null){
            return administrationRepository.save(p);
        }else{
            Optional<Administration> e = administrationRepository.getAdmin(p.getId());
            if(e.isPresent()){

                return p;
            }else{
                return administrationRepository.save(p);
            }
        }
    }
    public Administration update(Administration p){
        if(p.getId()== null){
            Optional<Administration> cab= administrationRepository.getAdmin(p.getId());
            if(cab.isPresent()){
                administrationRepository.save(p);
            }
        }
        return p;
    }

    public boolean delete(int id){
        boolean flag=false;
        Optional<Administration>p= administrationRepository.getAdmin(id);
        if(p.isPresent()){
            administrationRepository.delete(p.get());
            flag=true;
        }
        return flag;
    }

}
