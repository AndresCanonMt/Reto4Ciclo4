/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.edu.spring.rentcar.crudrepository.repository;

import co.usa.edu.spring.rentcar.crudrepository.ScoreInterface;
import co.usa.edu.spring.rentcar.model.Score;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Andre
 */
@Repository
public class ScoreRepository {
    
    @Autowired
    private ScoreInterface scoreCrudRepository;
    
    public List<Score> getAll(){
        return (List<Score>) scoreCrudRepository.findAll();
    }
    
    public Optional<Score> getScore(int id){
        return scoreCrudRepository.findById(id);
    }
    
    public Score save(Score newScore){
        return scoreCrudRepository.save(newScore);
    }
    
    public void delete(Score delScore){
        scoreCrudRepository.delete(delScore);
    }
}
