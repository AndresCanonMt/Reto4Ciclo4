/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.edu.spring.rentcar.crudrepository;

import co.usa.edu.spring.rentcar.model.Message;
import org.springframework.data.repository.CrudRepository;

/**
 * 
 * @author Andre
 */


public interface MessageInterface extends CrudRepository<Message, Integer>{
    
}
