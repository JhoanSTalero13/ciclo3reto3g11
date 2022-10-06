package com.usa.mintic.ciclo3.reto3.Servicies;
import com.usa.mintic.ciclo3.reto3.Entities.Category;
import com.usa.mintic.ciclo3.reto3.Repository.categoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class categoryServicies {
    @Autowired
    private categoryRepository categoryRepository;
    public List<Category> getAll(){
        return categoryRepository.getAll();
    }
    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }
    public Category save(Category p){
        if(p.getId()==null){
            return categoryRepository.save(p);
        }else{
            Optional<Category> e = categoryRepository.getCategory(p.getId());
            if(e.isPresent()){
                return p;
            }else{
                return categoryRepository.save(p);
            }
        }
    }

    public Category update(Category p){
        if(p.getId()== null){
            Optional<Category> cab= categoryRepository.getCategory(p.getId());
            if(cab.isPresent()){
                categoryRepository.save(p);
            }
        }
        return p;
    }

    public boolean delete(int id){
        boolean flag=false;
        Optional<Category>p= categoryRepository.getCategory(id);
        if(p.isPresent()){
            categoryRepository.delete(p.get());
            flag=true;
        }
        return flag;

    }
}
