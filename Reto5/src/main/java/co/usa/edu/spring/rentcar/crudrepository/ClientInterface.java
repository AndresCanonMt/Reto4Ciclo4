
package co.usa.edu.spring.rentcar.crudrepository;

import co.usa.edu.spring.rentcar.model.Client;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Andre
 */

@Repository
public interface ClientInterface extends CrudRepository<Client, Integer> {
    public abstract List<Client> findByEmail(String email);
    
}
 