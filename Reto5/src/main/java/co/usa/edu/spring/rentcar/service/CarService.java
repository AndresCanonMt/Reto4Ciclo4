
package co.usa.edu.spring.rentcar.service;

import co.usa.edu.spring.rentcar.crudrepository.repository.CarRepository;
import co.usa.edu.spring.rentcar.model.Car;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 
 * @author Andre
 */

@Service
public class CarService {
    
    @Autowired
    private CarRepository carRepository;
    
    public List<Car> getAllCars(){
        return (List<Car>) carRepository.getAll();
    }
    
    public Optional<Car> getCarById(int id){
        return carRepository.getCar(id);
    }
    
    public Car saveCar(Car car){
        if(car.getIdCar()==null){
            return carRepository.save(car);
        }else{
            Optional<Car> carOpt = carRepository.getCar(car.getIdCar());
            if (!carOpt.isPresent()){
                return carRepository.save(car);
            }else{
                return car;
            }
        }
        
    }
    
    public Car updateCar(Car car){
        if(car.getIdCar()!=null){
            Optional<Car> carOpt = carRepository.getCar(car.getIdCar());
            if(carOpt.isPresent()){
                if(car.getName()!=null){
                    carOpt.get().setName(car.getName());
                }
                if(car.getBrand()!=null){
                    carOpt.get().setBrand(car.getBrand());
                }
                if(car.getYear()!=null){
                    carOpt.get().setYear(car.getYear());
                }
                if(car.getDescription()!=null){
                    carOpt.get().setDescription(car.getDescription());
                }
                if(car.getGama()!=null){    
                    carOpt.get().setGama(car.getGama());
                }
                return carRepository.save(carOpt.get());
            }
        }
        return car;
    }
    
    public boolean deleteCar(int id){
        Optional<Car> carOpt = getCarById(id);
        if(carOpt.isPresent()){
            carRepository.delete(carOpt.get());
            return true;
        }
        return false;
    }
   
}
