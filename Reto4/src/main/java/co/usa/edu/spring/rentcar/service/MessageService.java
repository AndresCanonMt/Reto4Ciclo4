/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.edu.spring.rentcar.service;

import co.usa.edu.spring.rentcar.crudrepository.repository.MessageRepository;
import co.usa.edu.spring.rentcar.model.Message;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Andre
 */
@Service
public class MessageService {
    
    @Autowired
    private MessageRepository messageRepository;
    
    public List<Message> getAllMessages(){
        return (List<Message>) messageRepository.getAll();
    }
    
    public Optional<Message> getMessageById(int id){
        return messageRepository.getMessage(id);
    }
    
    public Message saveMessage(Message msg){
        if(msg.getIdMessage()==null){
            return messageRepository.save(msg);
        }else{
            Optional<Message> msgOpt = messageRepository.getMessage(msg.getIdMessage());
            if (!msgOpt.isPresent()){
                return messageRepository.save(msg);
            }else{
                return msg;
            }
        }
        
    }
    
    public Message updateMessage(Message msg){
        if(msg.getIdMessage()!=null){
            Optional<Message> msgOpt = messageRepository.getMessage(msg.getIdMessage());
            if(msgOpt.isPresent()){
                if(msg.getMessageText()!=null){
                    msgOpt.get().setMessageText(msg.getMessageText());
                }
                return messageRepository.save(msgOpt.get());
            }
        }
        return msg;
    }
    
    public boolean deleteMessage(int id){
        Optional<Message> msgOpt = getMessageById(id);
        if(msgOpt.isPresent()){
            messageRepository.delete(msgOpt.get());
            return true;
        }
        return false;
    }
}
