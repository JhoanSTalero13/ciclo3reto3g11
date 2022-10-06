package com.usa.mintic.ciclo3.reto3.Repository;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.usa.mintic.ciclo3.reto3.Repository.crudRepository.reservationCrudRepository;
import com.usa.mintic.ciclo3.reto3.Entities.Reservation;
import java.util.List;
import java.util.Optional;

@Repository
public class reservationRepository {
    @Autowired
    private reservationCrudRepository reservationCrudRepository;
    public List<Reservation> getAll(){
        return (List<Reservation>)  reservationCrudRepository.findAll();
    }
    public Optional<Reservation> getReservation(int id){
        return reservationCrudRepository.findById(id);
    }
    public Reservation save(Reservation c){
        return  reservationCrudRepository.save(c);
    }
    public void delete(Reservation c){
        reservationCrudRepository.delete(c);
    }


}
