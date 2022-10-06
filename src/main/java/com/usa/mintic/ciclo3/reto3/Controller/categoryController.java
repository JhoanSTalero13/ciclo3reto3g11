package com.usa.mintic.ciclo3.reto3.Controller;


import com.usa.mintic.ciclo3.reto3.Entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.usa.mintic.ciclo3.reto3.Servicies.categoryServicies;
import java.util.List;

@RestController
@RequestMapping("/api/Category")
public class categoryController {
    @Autowired
    private categoryServicies categoryServicies;
    @GetMapping("/all")
    public List<Category> getAll(){
        return categoryServicies.getAll();
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody  Category p){
        return categoryServicies.save(p);
    }
    @PutMapping("/update")
    public Category update (@RequestBody Category category) {return categoryServicies.update(category);
    }
    @DeleteMapping("/{id}")
    public boolean delete (@PathVariable("id")int carId){ return categoryServicies.delete(carId);
    }
}
