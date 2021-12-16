/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.edu.reto.services;

import co.usa.edu.reto.model.Order;
import co.usa.edu.reto.repository.OrderRepository;
import java.text.SimpleDateFormat;
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
public class OrderService {
    
    @Autowired
    private OrderRepository repo;
    
    public List<Order> getAll(){
        return repo.getAll();
    }
    
    public void save(Order order){
        if(order.getId()!=null){
            repo.save(order);
        }else{
            Optional<Order> OrderOpt = repo.getById(order.getId());
            if(!OrderOpt.isPresent()){
                repo.save(order);
            }
        }
    }
    
    public void delete(Integer id){
        Optional<Order> OrderOpt = repo.getById(id);
        if (OrderOpt.isPresent()){
            repo.delete(OrderOpt.get());
        }
    }
    
    public Order update(Order order){
        Optional<Order> orderOpt = repo.getById(order.getId());
        if(orderOpt.isPresent()){
            if (order.getRegisterDay()!= null) {
                    orderOpt.get().setRegisterDay(order.getRegisterDay());
                }
                if (order.getStatus()!= null) {
                    orderOpt.get().setStatus(order.getStatus());
                }
                if (order.getSalesMan()!= null) {
                    orderOpt.get().setSalesMan(order.getSalesMan());
                }
                if (order.getProducts()!= null) {
                    orderOpt.get().setProducts(order.getProducts());
                }
                if (order.getQuantities()!= null) {
                    orderOpt.get().setQuantities(order.getQuantities());
                }
                repo.update(orderOpt.get());
        }
        return order;
    }
    
    public List<Order> getBySalesman(String zone){
        return repo.getBySalesman(zone);
    }
    
    public List<Order> getBySalesmanId(Integer id){
        return repo.getBySalesmanId(id);
    }
    
    public List<Order> getByStatus(Integer id, String status){
        return repo.getByStatus(id, status);
    }
    
    public List<Order> getByDate(Integer id, String fecha){
        SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd");
        Date fechaFormat = new Date();
        try {
            fechaFormat = format.parse(fecha);
        } catch (Exception err) {
            err.printStackTrace();
        }
        return repo.getByDate(id, fechaFormat);
    }
    
    public Order getOrder(Integer id){
        Optional<Order> orderOpt = repo.getById(id);
        if(orderOpt.isPresent()){
            return orderOpt.get();
        }
        return null;
    }
}
