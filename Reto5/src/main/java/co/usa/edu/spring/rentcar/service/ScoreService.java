/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.edu.spring.rentcar.service;

import co.usa.edu.spring.rentcar.crudrepository.repository.ScoreRepository;
import co.usa.edu.spring.rentcar.model.Score;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Andre
 */

@Service
public class ScoreService {
     
    @Autowired
    private ScoreRepository scoreRepository;
    
    public List<Score> getAllScore(){
        return (List<Score>) scoreRepository.getAll();
    }
    
    public Optional<Score> getScoreById(int id){
        return scoreRepository.getScore(id);
    }
    
    public Score saveScore(Score score){
        if(score.getIdScore()==null){
            return scoreRepository.save(score);
        }else{
            Optional<Score> scoreOpt = scoreRepository.getScore(score.getIdScore());
            if (!scoreOpt.isPresent()){
                return scoreRepository.save(score);
            }else{
                return score;
            }
        }
    }
    
     public Score updateScore(Score score){
        if(score.getIdScore()!=null){
            Optional<Score> scoreOpt = scoreRepository.getScore(score.getIdScore());
            if(scoreOpt.isPresent()){
                if(score.getScore()!=null){
                    scoreOpt.get().setScore(score.getScore());
                }
                if(score.getMessage()!=null){
                    scoreOpt.get().setMessage(score.getMessage());
                }
                return scoreRepository.save(scoreOpt.get());
            }
        }
        return score;
    }
}
