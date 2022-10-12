package com.usa.mintic.ciclo3.reto3.Controller;
import com.usa.mintic.ciclo3.reto3.Entities.Reservation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.usa.mintic.ciclo3.reto3.Servicies.reservationServicies;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value="/api/Reservation")
public class reservationController {
    reservationServicies reservationServicies;

    @GetMapping(value="/all")
    public List<Reservation> getAll(){
        return reservationServicies.getAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int reserId){
        return reservationServicies.getReservation(reserId);
    }
    @PostMapping(value="/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody  Reservation p){
        return reservationServicies.save(p);
    }
    @PutMapping(value="/update")
    public Reservation update (@RequestBody Reservation reservation) {return reservationServicies.update(reservation);
    }
    @DeleteMapping(value="/{id}")
    public boolean delete (@PathVariable("id")int carId){ return reservationServicies.delete(carId);
    }

}
