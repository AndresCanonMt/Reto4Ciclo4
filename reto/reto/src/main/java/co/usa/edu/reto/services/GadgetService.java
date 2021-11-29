/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.edu.reto.services;

import co.usa.edu.reto.model.Gadget;
import co.usa.edu.reto.repository.GadgetRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andre
 */
@Service
public class GadgetService {

    @Autowired
    private GadgetRepository repository;

    public void saveGadget(Gadget objeto) {
        if(objeto.getId()!=null){
                   repository.save(objeto);
                }else{
                   Optional<Gadget> gadgetOtp = repository.getById(objeto.getId());
                    if(!gadgetOtp.isPresent()){
                       repository.save(objeto);
                   }
               }
    }

    public List<Gadget> getAllGadgets() {
        return repository.getAll();
    }

    public Gadget updateGadget(Gadget objeto) {
            Optional<Gadget> gadgetOpt = repository.getById(objeto.getId());
            if (gadgetOpt.isPresent()) {
                if (objeto.getBrand() != null) {
                    gadgetOpt.get().setBrand(objeto.getBrand());
                }
                if (objeto.getCategory() != null) {
                    gadgetOpt.get().setCategory(objeto.getCategory());
                }
                if (objeto.getName() != null) {
                    gadgetOpt.get().setName(objeto.getName());
                }
                if (objeto.getDescription() != null) {
                    gadgetOpt.get().setDescription(objeto.getDescription());
                }
                if (objeto.getPrice()!= null && objeto.getPrice() > 0) {
                    gadgetOpt.get().setPrice(objeto.getPrice());
                }
                if (objeto.getAvailability() != null) {
                    gadgetOpt.get().setAvailability(objeto.getAvailability());
                }
                if (objeto.getQuantity() != null && objeto.getQuantity()> 0) {
                    gadgetOpt.get().setQuantity(objeto.getQuantity());
                }
                if (objeto.getPhotography() != null) {
                    gadgetOpt.get().setPhotography(objeto.getPhotography());
                }
                repository.update(gadgetOpt.get());
            }
     
        return objeto;
    }

    public void delete(Integer id){
        Optional<Gadget> gadgetOpt = repository.getById(id);
        if(gadgetOpt.isPresent()){
            repository.delete(gadgetOpt.get());
        }
        
    }
    
    public Optional<Gadget> getId(Integer id){
        Optional<Gadget> gadgetOpt = repository.getById(id);
        return gadgetOpt;
    }
    
}
