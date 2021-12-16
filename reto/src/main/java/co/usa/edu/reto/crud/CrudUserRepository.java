/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.edu.reto.crud;

import co.usa.edu.reto.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author Andre
 */
public interface CrudUserRepository extends MongoRepository<User, Integer>{
    
    public boolean existsByEmail(String email);
    
    @Query("{id: ?0}")
    public Optional<User> getById(Integer id);    
    
    public User findByEmailAndPassword(String email, String password);
    
    public User findByEmail(String email);
    
    @Query("{monthBirthtDay: ?0}")
    public List<User> findByMonthBirthtDay(String mes);
    
    
}
