/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.edu.spring.rentcar.crudrepository.repository;

import co.usa.edu.spring.rentcar.crudrepository.AdminInterface;
import co.usa.edu.spring.rentcar.model.Admin;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Andre
 */

@Repository
public class AdminRepository {
    
    @Autowired
    private AdminInterface adminCrudRepository;
    
    public List<Admin> getAll(){
        return (List<Admin>) adminCrudRepository.findAll();
    }
    
    public Optional<Admin> getAdmin(int id){
        return adminCrudRepository.findById(id);
    }
    
    public Admin save(Admin newAdmin){
        return adminCrudRepository.save(newAdmin);
    }
    
    public void delete(Admin delAdmin){
        adminCrudRepository.delete(delAdmin);
    }
}
