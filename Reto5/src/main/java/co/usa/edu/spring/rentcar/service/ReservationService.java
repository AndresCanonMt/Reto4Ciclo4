/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.edu.spring.rentcar.service;

import co.usa.edu.spring.rentcar.crudrepository.repository.ReservationRepository;
import co.usa.edu.spring.rentcar.model.CountCar;
import co.usa.edu.spring.rentcar.model.CountClient;
import co.usa.edu.spring.rentcar.model.StatusAmount;
import co.usa.edu.spring.rentcar.model.Reservation;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    
    public List<CountClient> getTopClients(){
        return reservaRepository.getTopClient();
    }
    
    public List<CountCar> getTopCars(){
        return reservaRepository.getTopCar();
    }
    
    public StatusAmount getStatusReport(){
        List<Reservation> completed= reservaRepository.getReservationByStatus("completed");
        List<Reservation> cancelled= reservaRepository.getReservationByStatus("cancelled");
    
        StatusAmount descAmt= new StatusAmount(completed.size(), cancelled.size());
        return descAmt; 
    }
    
    public List<Reservation> getReservationPeriod(String d1, String d2){
        
        //yyyy-MM-dd
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        
        Date dateOne = new Date();
        Date dateTwo = new Date();
        
        try {
            dateOne = parser.parse(d1);
            dateTwo = parser.parse(d2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(dateOne.before(dateTwo)){
                 return reservaRepository.getReservationPeriod(dateOne, dateTwo);   
        }else{
            return new ArrayList<>();
        }
        
    }
    
}
