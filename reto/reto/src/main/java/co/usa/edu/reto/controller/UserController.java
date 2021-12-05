/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.edu.reto.controller;

import co.usa.edu.reto.model.User;
import co.usa.edu.reto.services.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Andre
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody User usuario){
        userService.saveUser(usuario);
    }
    
    @GetMapping("/all")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id")Integer id){
        userService.delete(id);
    }
    
    @GetMapping("/{id}")
    public Optional<User> getId(@PathVariable("id")Integer id){
        return userService.getId(id);
    }
        
    @PutMapping("/update")
    public ResponseEntity update(@RequestBody User usuario){
        userService.updateUser(usuario);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    
    /**
     * Mapeado para la verificación de email existente en la BD por medio de petición
     * web Http tipo GET
     * @param email correo electrónico a verificar su existencia
     * @return una respuesta verdadero o falso dependiendo de la existencia del
     * parámetro enviado
     */
    @GetMapping("/emailexist/{email}")
    public boolean verificarEmail(@PathVariable String email){
        return userService.verificador(email);
    }
    /**
     * Mapeado de petición web Http tipo GET para el login de usuario en la Webapp
     * @param email correo electrónico del usuario a logear
     * @param password password del usuario a logear
     * @return un objeto de tipo usuario dependiendo de su existencia
     */
    @GetMapping("/{email}/{password}")
    public User verificarSimilitud(@PathVariable String email,@PathVariable String password){
        return userService.validarUsuario(email, password);
        }
}
