package com.usa.mintic.ciclo3.reto3.Servicies;


import com.usa.mintic.ciclo3.reto3.Entities.Reservation;
import com.usa.mintic.ciclo3.reto3.Repository.reservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class reservationServicies {
    @Autowired
    private reservationRepository reservationRepository;
    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    public Optional<Reservation> getReservation (int id){
        return reservationRepository.getReservation(id);
    }
    public Reservation save( Reservation p){
        if(p.getIdReservation()==null){
            return reservationRepository.save(p);
        }else{
            Optional<Reservation> e = reservationRepository.getReservation(p.getIdReservation());
            if(e.isPresent()){
                return p;
            }else{
                return reservationRepository.save(p);
            }
        }
    }
    public Reservation update(Reservation c){
        if(c.getIdReservation()== null){
            Optional<Reservation> cab= reservationRepository.getReservation(c.getIdReservation());
            if(cab.isPresent()){
                reservationRepository.save(c);

            }
        }
        return c;
    }
    

    public boolean delete(int id){
        boolean flag=false;
        Optional<Reservation>p= reservationRepository.getReservation(id);
        if(p.isPresent()){
            reservationRepository.delete(p.get());
            flag=true;
        }
        return flag;

    }



}
