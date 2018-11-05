package hu.elte.transactiontracker.repositories;

import hu.elte.transactiontracker.entities.Transaction;
import hu.elte.transactiontracker.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
    public Iterable<Transaction> findAllByUser(User user);
}
