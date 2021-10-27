/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.edu.spring.rentcar.controller;

import co.usa.edu.spring.rentcar.model.CountCar;
import co.usa.edu.spring.rentcar.model.CountClient;
import co.usa.edu.spring.rentcar.model.StatusAmount;
import co.usa.edu.spring.rentcar.model.Reservation;
import co.usa.edu.spring.rentcar.service.ReservationService;
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
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ReservationController {
    
    @Autowired
    private ReservationService reservService;
   
    @GetMapping("/all")
    public List<Reservation> getReservations(){
        return reservService.getAllReservations();
    }
  
    @GetMapping("/{id}")
    public Optional <Reservation> getReservation(@PathVariable("id") int id){
        return reservService.getReservationById(id);
    }
    
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reserv){
        return reservService.saveReservation(reserv);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation res){
        return reservService.updateCar(res);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteReservation(@PathVariable("id") int id){
        return reservService.deleteReservation(id);
    }
    
    //:P
    
    @GetMapping("/report-status")
    public StatusAmount getReservationStatusAmount(){
        return reservService.getStatusReport();
    }
    
    @GetMapping("/report-clients")
    public List<CountClient> getCountClients(){
        return reservService.getTopClients();
    }
    
    @GetMapping("/report-cars")
    public List<CountCar> getCountCars(){
        return reservService.getTopCars();
    }
    
    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getDatesReport(@PathVariable ("dateOne")String d1, @PathVariable("dateTwo")String d2){
       return reservService.getReservationPeriod(d1, d2);
    }

}
