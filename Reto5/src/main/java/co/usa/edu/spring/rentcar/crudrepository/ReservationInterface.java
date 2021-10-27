/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.edu.spring.rentcar.crudrepository;

import co.usa.edu.spring.rentcar.model.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * 
 * @author Andre
 */

public interface ReservationInterface extends CrudRepository<Reservation, Integer>{
    
    //JPQL
    @Query("SELECT c.client, COUNT(c.client) FROM Reservation AS c group by c.client order by COUNT(c.client) desc")
    
    public List<Object[]> countTotalReservationByClient();
    
    @Query("SELECT c.car, COUNT(c.car) FROM Reservation AS c group by c.car order by COUNT(c.car) desc")
    
    public List<Object[]> countTotalReservationByCar();
    
    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo); 
    

    //public List<Reservation> findAllByStartDateBetweenStartDateAndDevolutionDate(Date date);
    public List<Reservation> findAllByStatus(String status);
    
    
    
}
