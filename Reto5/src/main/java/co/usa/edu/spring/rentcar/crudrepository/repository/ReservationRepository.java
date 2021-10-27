/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.edu.spring.rentcar.crudrepository.repository;

import co.usa.edu.spring.rentcar.crudrepository.ReservationInterface;
import co.usa.edu.spring.rentcar.model.Car;
import co.usa.edu.spring.rentcar.model.Client;
import co.usa.edu.spring.rentcar.model.CountCar;
import co.usa.edu.spring.rentcar.model.CountClient;
import co.usa.edu.spring.rentcar.model.Reservation;
import java.util.ArrayList;
import java.util.Date;
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
    
    public List<Reservation> getReservationByStatus(String status){
        return reservaCrudRepository.findAllByStatus(status);
    }
    
    public List<Reservation> getReservationPeriod(Date dateOne, Date dateTwo){
        return reservaCrudRepository.findAllByStartDateAfterAndStartDateBefore(dateOne, dateTwo);
    }
    
    public List<CountClient> getTopClient(){
        List<CountClient> res = new ArrayList<>();
        
        List <Object[]> report = reservaCrudRepository.countTotalReservationByClient();
        for(int i=0; i<report.size();i++){
            Client cli = (Client) report.get(i)[0];
            Long cantidad=(Long) report.get(i)[1];
            CountClient cc = new CountClient(cantidad, cli);
            res.add(cc);
            //res.add(new CountCategoria(Integer) report.get(i)[1],(Categoria)report.get(i)[0]));
        }
        return res;
    }
    
    public List<CountCar> getTopCar(){
        List<CountCar> reser = new ArrayList<>();
        
        List <Object[]> report = reservaCrudRepository.countTotalReservationByCar();
        for(int i=0; i<report.size();i++){
            Car car = (Car) report.get(i)[0];
            Long cantidad=(Long) report.get(i)[1];
            CountCar carro = new CountCar(cantidad, car);
            reser.add(carro);
            //reser.add(new CountCar(Long) report.get(i)[1],(Car)report.get(i)[0]));
        }
        return reser;
    }
    
}
