/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.edu.spring.rentcar.crudrepository.repository;

import co.usa.edu.spring.rentcar.crudrepository.ReservationInterface;
import co.usa.edu.spring.rentcar.model.Reservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Andre
 */

@Repository
public class ReservationRepository {
    
    @Autowired
    private ReservationInterface reservaCrudRepository;
    
    public List<Reservation> getAll(){
        return (List<Reservation>) reservaCrudRepository.findAll();
    }
    
    public Optional<Reservation> getReservation(int id){
        return reservaCrudRepository.findById(id);
    }
    
    public Reservation save(Reservation newReserv){
        return reservaCrudRepository.save(newReserv);
    }
    
    public void delete(Reservation delReserv){
        reservaCrudRepository.delete(delReserv);
    }
    
}
