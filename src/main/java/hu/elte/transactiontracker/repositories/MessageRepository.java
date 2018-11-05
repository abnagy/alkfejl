package hu.elte.transactiontracker.repositories;

import hu.elte.transactiontracker.entities.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends CrudRepository<Message, Integer> {
    
}
