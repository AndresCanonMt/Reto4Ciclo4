
package co.usa.edu.spring.rentcar.crudrepository.repository;

import co.usa.edu.spring.rentcar.model.Car;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import co.usa.edu.spring.rentcar.crudrepository.CarInterface;

/**
 * 
 * @author Andre
 */

@Repository
public class CarRepository {
    
    @Autowired
    private CarInterface carCrudRepository;
    
    public List<Car> getAll(){
        return (List<Car>) carCrudRepository.findAll();
    }
    
    public Optional<Car> getCar(int id){
        return carCrudRepository.findById(id);
    }
    
    public Car save(Car newCar){
        return carCrudRepository.save(newCar);
    }
    
    public void delete(Car delCar){
        carCrudRepository.delete(delCar);
    }
}
