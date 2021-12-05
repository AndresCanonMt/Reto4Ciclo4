/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.edu.reto.repository;

import co.usa.edu.reto.crud.CrudOrderRepository;
import co.usa.edu.reto.model.Order;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Andre
 */
@Repository
public class OrderRepository {
    
    @Autowired
    private CrudOrderRepository repo;
    
     public void save(Order order){
        repo.insert(order);
    }
    
    public void update(Order order){
        repo.save(order);
    }
    
    public List<Order> getAll(){
    return repo.findAll();
    }
    
    public Optional<Order> getById(Integer id){
        return repo.getdById(id);
    }
    
    public List<Order> getBySalesman(String zone){
        return repo.findByZone(zone);
    }
     
    public void delete(Order order){
        repo.delete(order);
    }
}