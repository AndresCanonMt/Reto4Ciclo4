/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.edu.spring.rentcar.crudrepository.repository;

import co.usa.edu.spring.rentcar.model.Gama;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import co.usa.edu.spring.rentcar.crudrepository.GamaInterface;

/**
 * 
 * @author Andre
 */
@Repository
public class GamaRepository {
    @Autowired
    private GamaInterface gamaCrudRepository;
    
    public List<Gama> getAll(){
        return (List<Gama>) gamaCrudRepository.findAll();
    }
    
    public Optional<Gama> getGama(int id){
        return gamaCrudRepository.findById(id);
    }
    
    public Gama save(Gama newGama){
        return gamaCrudRepository.save(newGama);
    }
    
    public void delete(Gama delGama){
        gamaCrudRepository.delete(delGama);
    }
}
