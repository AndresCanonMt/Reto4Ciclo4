/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.edu.spring.rentcar.service;

import co.usa.edu.spring.rentcar.crudrepository.repository.ReservationRepository;
import co.usa.edu.spring.rentcar.model.Reservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Andre
 */

@Service
public class ReservationService {
    
    @Autowired
    private ReservationRepository reservaRepository;
    
    public List<Reservation> getAllReservations(){
        return (List<Reservation>) reservaRepository.getAll();
    }
    
    public Optional<Reservation> getReservationById(int id){
        return reservaRepository.getReservation(id);
    }
    
    public Reservation saveReservation(Reservation res){
        if(res.getIdReservation()==null){
            return reservaRepository.save(res);
        }else{
            Optional<Reservation> reservaOpt = reservaRepository.getReservation(res.getIdReservation());
            if (!reservaOpt.isPresent()){
                return reservaRepository.save(res);
            }else{
                return res;
            }
        }
    }
    
    public Reservation updateCar(Reservation res){
        if(res.getIdReservation()!=null){
            Optional<Reservation> resOpt = reservaRepository.getReservation(res.getIdReservation());
            if(resOpt.isPresent()){
                if(res.getStartDate()!=null){
                    resOpt.get().setStartDate(res.getStartDate());
                }
                if(res.getDevolutionDate()!=null){
                    resOpt.get().setDevolutionDate(res.getDevolutionDate());
                }
                if(res.getStatus()!=null){
                    resOpt.get().setStatus(res.getStatus());
                }
                return reservaRepository.save(resOpt.get());
            }
        }
        return res;
    }
    
    public boolean deleteReservation(int id){
        Optional<Reservation> resOpt = getReservationById(id);
        if(resOpt.isPresent()){
            reservaRepository.delete(resOpt.get());
            return true;
        }
        return false;
    }
    
}
