/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.edu.spring.rentcar.crudrepository.repository;

import co.usa.edu.spring.rentcar.crudrepository.MessageInterface;
import co.usa.edu.spring.rentcar.model.Message;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Andre
 */

@Repository
public class MessageRepository {
    
    @Autowired
    private MessageInterface messageCrudRepository;
    
    public List<Message> getAll(){
        return (List<Message>) messageCrudRepository.findAll();
    }
    
    public Optional<Message> getMessage(int id){
        return messageCrudRepository.findById(id);
    }
    
    public Message save(Message newMessage){
        return messageCrudRepository.save(newMessage);
    }
    
    public void delete(Message delMessage){
        messageCrudRepository.delete(delMessage);
    }
}
