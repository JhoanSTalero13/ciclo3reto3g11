package com.usa.mintic.ciclo3.reto3.Controller;


import com.usa.mintic.ciclo3.reto3.Entities.Category;
import com.usa.mintic.ciclo3.reto3.Entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.usa.mintic.ciclo3.reto3.Servicies.categoryServicies;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api/Category")
public class categoryController {
    @Autowired
    private categoryServicies categoryServicies;
    @GetMapping(value="/all")
    public List<Category> getAll(){
        return categoryServicies.getAll();
    }
    @GetMapping(value = "/{id}")
    public Optional<Category> getCategory(@PathVariable("id") int categoryId){
        return categoryServicies.getCategory(categoryId);
    }
    @PostMapping(value="/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody  Category p){
        return categoryServicies.save(p);
    }
    @PutMapping(value="/update")
    public Category update (@RequestBody Category category) {return categoryServicies.update(category);
    }
    @DeleteMapping("/{id}")
    public boolean delete (@PathVariable("id")int carId){ return categoryServicies.delete(carId);
    }
}
