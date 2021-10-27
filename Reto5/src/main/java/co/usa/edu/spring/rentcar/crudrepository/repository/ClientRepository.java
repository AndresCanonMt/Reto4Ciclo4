/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.edu.spring.rentcar.crudrepository.repository;


import co.usa.edu.spring.rentcar.model.Client;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import co.usa.edu.spring.rentcar.crudrepository.ClientInterface;

/**
 * 
 * @author Andre
 */

@Repository
public class ClientRepository {
    @Autowired
    private ClientInterface clientCrudRepository;
    
    public List<Client> getAll(){
        return (List<Client>) clientCrudRepository.findAll();
    }
    
    public Optional<Client> getClient(int id){
        return clientCrudRepository.findById(id);
    }
    
    public Client save(Client newClient){
        return clientCrudRepository.save(newClient);
    }
    
    public void delete(Client delCLient){
        clientCrudRepository.delete(delCLient);
    }
}
