/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.edu.reto.repository;

import co.usa.edu.reto.crud.CrudGadgetRepository;
import co.usa.edu.reto.model.Gadget;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Andre
 */
@Repository
public class GadgetRepository {
    
    @Autowired
    private CrudGadgetRepository repo;
    
    public void save(Gadget gadget){
        repo.insert(gadget);
    }
    public void update(Gadget gadget){
        repo.save(gadget);
    }
    
    public List<Gadget> getAll(){
        return repo.findAll();
    }
    
    public Optional<Gadget> getById(Integer id){
        return repo.getById(id);
        
    }
    
    public void delete(Gadget gadget){
        repo.delete(gadget);
    }
    
    public List<Gadget> getGadgetByPrice(Double price){
        return repo.findGadgetByPrice(price);
    }
    
    public List<Gadget> getGadgetByDescription(String text){
        return repo.findGadgetByDescription(text);
    }
    
}
