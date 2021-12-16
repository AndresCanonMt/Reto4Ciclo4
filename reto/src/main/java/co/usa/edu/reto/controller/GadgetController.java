/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.edu.reto.controller;


import co.usa.edu.reto.model.Gadget;
import co.usa.edu.reto.services.GadgetService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Andre
 */
@RestController
@RequestMapping("/api/gadget")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class GadgetController {
    @Autowired
    private GadgetService gadgetService;
    
     
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Gadget gadget){
        gadgetService.saveGadget(gadget);
    }
    
    @GetMapping("/all")
    public List<Gadget> getGadget(){
        return gadgetService.getAllGadgets();
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id")Integer id){
        gadgetService.delete(id);
    }
    
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Optional<Gadget> getId(@PathVariable("id")Integer id){
        return gadgetService.getId(id);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void update(@RequestBody Gadget gadget){
        gadgetService.updateGadget(gadget);
    }
    
    @GetMapping("/price/{price}")
    public List<Gadget> getGadgetByPrice(@PathVariable("price") Double price){
        return gadgetService.getGadgetByPrice(price);
    }
    
    @GetMapping("/description/{text}")
    public List<Gadget> getGadgetByDescription(@PathVariable("text") String text){
        return gadgetService.getGadgetByDescription(text);
    }
    
}
