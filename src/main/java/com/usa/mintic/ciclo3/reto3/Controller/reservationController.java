package com.usa.mintic.ciclo3.reto3.Controller;
import com.usa.mintic.ciclo3.reto3.Entities.Reservation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.usa.mintic.ciclo3.reto3.Servicies.reservationServicies;
import java.util.List;


@RestController
@RequestMapping("/api/Reservation")
public class reservationController {
    reservationServicies reservationServicies;

    @GetMapping("/all")
    public List<Reservation> getAll(){
        return reservationServicies.getAll();
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody  Reservation p){
        return reservationServicies.save(p);
    }
    @PutMapping("/update")
    public Reservation update (@RequestBody Reservation reservation) {return reservationServicies.update(reservation);
    }
    @DeleteMapping("/{id}")
    public boolean delete (@PathVariable("id")int carId){ return reservationServicies.delete(carId);
    }

}
