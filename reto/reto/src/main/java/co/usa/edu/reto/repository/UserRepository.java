/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.edu.reto.repository;

import co.usa.edu.reto.crud.CrudUserRepository;
import co.usa.edu.reto.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Andre
 */
@Repository
public class UserRepository {
    @Autowired
    private CrudUserRepository repo;
    
    public void save(User usuario){
        repo.insert(usuario);
    }
    
   public void update(User usuario){
        repo.save(usuario);
    }
    
    public List<User> getAll(){
        return repo.findAll();
    }
    
    public Optional<User> getById(Integer id){
        return repo.getById(id);
        
    }
    
    public void delete(User usuario){
        repo.delete(usuario);
    }
    
    public boolean verificacion (String email){
        return repo.existsByEmail(email);
    }
    
    public User verificaion2 (String email, String password){
        return repo.findByEmailAndPassword(email, password);
    }
}
