/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.edu.spring.rentcar.crudrepository;

import co.usa.edu.spring.rentcar.model.Gama;
import org.springframework.data.repository.CrudRepository;

/**
 * 
 * @author Andre
 */
public interface GamaInterface extends CrudRepository<Gama, Integer> {
    
}
