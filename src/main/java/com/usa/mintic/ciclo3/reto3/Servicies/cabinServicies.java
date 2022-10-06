package com.usa.mintic.ciclo3.reto3.Servicies;


import com.usa.mintic.ciclo3.reto3.Entities.Cabin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.usa.mintic.ciclo3.reto3.Repository.cabinRepository;

import java.util.List;
import java.util.Optional;

@Service
public class cabinServicies {
    @Autowired
    private cabinRepository cabinRepository;
    public List<Cabin> getAll(){
        return cabinRepository.getAll();
    }
    private Optional<Cabin> getCabin(int id){
        return cabinRepository.getCabin(id);
    }
    public Cabin save(Cabin p){
        if(p.getId()==null){
            return cabinRepository.save(p);
        }else{
            Optional<Cabin> e = cabinRepository.getCabin(p.getId());
            if(e.isPresent()){

                return p;
            }else{
                return cabinRepository.save(p);
            }
        }
    }
    public Cabin update(Cabin p){
        if(p.getId()!=null){
            Optional<Cabin> q = cabinRepository.getCabin(p.getId());
            if(q.isPresent()){
                if(p.getName()!=null){
                    q.get().setName(p.getName());
                }
                if(p.getBrand()!=null){
                    q.get().setBrand(p.getBrand());
                }
                if(p.getRooms()!=null){
                    q.get().setRooms(p.getRooms());
                }
                if(p.getCategory()!=null){
                    q.get().setCategory(p.getCategory());
                }
                cabinRepository.save(q.get());
                return q.get();
            }else{
                return p;
            }
        }else{
            return p;
        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Cabin>p= cabinRepository.getCabin(id);
        if(p.isPresent()){
            cabinRepository.delete(p.get());
            flag=true;
        }
        return flag;

    }


}
