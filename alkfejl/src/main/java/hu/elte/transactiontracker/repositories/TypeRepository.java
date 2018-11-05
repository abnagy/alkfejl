package hu.elte.transactiontracker.repositories;

import hu.elte.transactiontracker.entities.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends CrudRepository<Type, Integer> {
    
}
