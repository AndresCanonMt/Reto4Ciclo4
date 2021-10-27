/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.edu.spring.rentcar.service;

import co.usa.edu.spring.rentcar.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import co.usa.edu.spring.rentcar.crudrepository.repository.ClientRepository;
import co.usa.edu.spring.rentcar.model.Car;


/**
 * 
 * @author Andre
 */

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;
    
    public List<Client> getAllClients(){
        return (List<Client>)clientRepository.getAll();
    }
    
    public Optional<Client> getClienById(int id){
        return clientRepository.getClient(id);
    }
    
    public Client saveClient(Client client){
        if(client.getIdClient()==null){
            return clientRepository.save(client);
        }else{
            Optional<Client> clientOpt = clientRepository.getClient(client.getIdClient());
            if (!clientOpt.isPresent()){
                return clientRepository.save(client);
            }else{
                return client;
            }
        }   
    }
    
    public Client updateClient(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> clientOpt = clientRepository.getClient(client.getIdClient());
            if(clientOpt.isPresent()){
                if(client.getName()!=null){
                    clientOpt.get().setName(client.getName());
                }
                if(client.getEmail()!=null){
                    clientOpt.get().setEmail(client.getEmail());
                }
                if(client.getPassword()!=null){
                    clientOpt.get().setPassword(client.getPassword());
                }
                if(client.getAge()!=null){
                    clientOpt.get().setAge(client.getAge());
                }
                return clientRepository.save(clientOpt.get());
            }
        }
        return client;
    }
    
    public boolean deleteClient(int id){
        Optional<Client> clientOpt = getClienById(id);
        if(clientOpt.isPresent()){
            clientRepository.delete(clientOpt.get());
            return true;
        }
        return false;
    }
}
