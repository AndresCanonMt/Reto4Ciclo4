/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.edu.reto.services;

import co.usa.edu.reto.model.User;
import co.usa.edu.reto.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andre
 */
@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void saveUser(User objeto) {
        if (objeto.getId() != null) {
            repository.save(objeto);
        } else {
            Optional<User> userOtp = repository.getById(objeto.getId());
            if (!userOtp.isPresent()) {
                repository.save(objeto);
            }
        }
    }

    public List<User> getAllUsers() {
        return repository.getAll();
    }

    public User updateUser(User objeto) {
            Optional<User> userOpt = repository.getById(objeto.getId());
            if (userOpt.isPresent()) {
                if (objeto.getIdentification() != null && objeto.getIdentification().length() > 0) {
                    userOpt.get().setIdentification(objeto.getIdentification());
                }
                if (objeto.getName() != null && objeto.getName().length() > 0) {
                    userOpt.get().setName(objeto.getName());
                }
                if (objeto.getBirthtDay()!= null) {
                    userOpt.get().setBirthtDay(objeto.getBirthtDay());
                }
                if (objeto.getMonthBirthtDay()!= null && objeto.getMonthBirthtDay().length()> 0) {
                    userOpt.get().setMonthBirthtDay(objeto.getMonthBirthtDay());
                }
                if (objeto.getAddress() != null && objeto.getAddress().length() > 0) {
                    userOpt.get().setAddress(objeto.getAddress());
                }
                if (objeto.getCellPhone() != null && objeto.getCellPhone().length() > 0) {
                    userOpt.get().setCellPhone(objeto.getCellPhone());
                }
                if (objeto.getEmail() != null && objeto.getEmail().length() > 0) {
                    userOpt.get().setEmail(objeto.getEmail());
                }
                if (objeto.getPassword() != null && objeto.getPassword().length() > 0) {
                    userOpt.get().setPassword(objeto.getPassword());
                }
                if (objeto.getZone() != null && objeto.getZone().length() > 0) {
                    userOpt.get().setZone(objeto.getZone());
                }
                if (objeto.getType() != null && objeto.getType().length() > 0) {
                    userOpt.get().setType(objeto.getType());
                }

                repository.update(userOpt.get());
            }
        return null;
    }

    public void delete(Integer id) {
        Optional<User> userOpt = repository.getById(id);
        if (userOpt.isPresent()) {
            repository.delete(userOpt.get());
        }
    }
    
    public Optional<User> getId(Integer id) {
        Optional<User> userOpt = repository.getById(id);
        return userOpt;
    }

    public boolean verificador(String email) {
        return repository.verificacion(email);
    }

    public User validarUsuario(String email, String pass) {
        User user = repository.verificaion2(email, pass);
        if (user != null) {
            return user;
        } else {
            User user2 = new User();
            user2.setId(null);
            user2.setIdentification(null);
            user2.setAddress(null);
            user2.setCellPhone(null);
            user2.setEmail(null);
            user2.setPassword(null);
            user2.setZone(null);
            user2.setType(null);
            return user2;
        }
    }

}
