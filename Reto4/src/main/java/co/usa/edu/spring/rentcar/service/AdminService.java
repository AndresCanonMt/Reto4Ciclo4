/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.edu.spring.rentcar.service;

import co.usa.edu.spring.rentcar.crudrepository.repository.AdminRepository;
import co.usa.edu.spring.rentcar.model.Admin;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Andre
 */

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;
    
    public List<Admin> getAllAdmins(){
        return adminRepository.getAll();
    }
    
    public Optional<Admin> getAdminById(int id){
        return adminRepository.getAdmin(id);
    }
    
    public Admin saveAdmin(Admin admin){
        if(admin.getIdAdmin()==null){
            return adminRepository.save(admin);
        }else{
            Optional<Admin> admOpt = adminRepository.getAdmin(admin.getIdAdmin());
            if (!admOpt.isPresent()){
                return adminRepository.save(admin);
            }else{
                return admin;
            }
        }  
    }
     
    public Admin updateAdm(Admin admin){
        if (admin.getIdAdmin() != null){
            Optional<Admin> admOpt = adminRepository.getAdmin(admin.getIdAdmin());
            if(admOpt.isPresent()){
                if(admin.getName()!=null){
                    admOpt.get().setName(admin.getName());
                }
                if(admin.getEmail()!=null){
                    admOpt.get().setEmail(admin.getEmail());
                }
                if(admin.getPassword()!=null){
                    admOpt.get().setPassword(admin.getPassword());
                }
                return adminRepository.save(admOpt.get());
            }   
        }
        return admin;
    }
    
    public boolean deleteAdmin(int id){
        Optional<Admin> admOpt = getAdminById(id);
        if(admOpt.isPresent()){
            adminRepository.delete(admOpt.get());
            return true;
        }
        return false;
    }
}
