package hu.elte.transactiontracker.controllers;

import hu.elte.transactiontracker.entities.Transaction;
import hu.elte.transactiontracker.entities.Type;
import hu.elte.transactiontracker.entities.Message;
import hu.elte.transactiontracker.entities.User;
import hu.elte.transactiontracker.repositories.MessageRepository;
import hu.elte.transactiontracker.security.AuthenticatedUser;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hu.elte.transactiontracker.repositories.TransactionRepository;
import hu.elte.transactiontracker.repositories.TypeRepository;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    
    @Autowired
    private TransactionRepository transactionRepository;
    
    @Autowired
    private MessageRepository messageRepository;
    
    @Autowired
    private TypeRepository typeRepository;
    
    @Autowired
    private AuthenticatedUser authenticatedUser;
    
    @GetMapping("")
    public ResponseEntity<Iterable<Transaction>> getAll() {
        User user = authenticatedUser.getUser();
        User.Role role = user.getRole();
        if (role.equals(User.Role.ROLE_ADMIN)) {
            return ResponseEntity.ok(transactionRepository.findAll());
        } else {
            return ResponseEntity.ok(transactionRepository.findAllByUser(user));
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Transaction> get(@PathVariable Integer id) {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        if (transaction.isPresent()) {
            return ResponseEntity.ok(transaction.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("")
    public ResponseEntity<Transaction> post(@RequestBody Transaction transaction) {
        User user = authenticatedUser.getUser();
        transaction.setUser(user);
        Transaction savedTransaction = transactionRepository.save(transaction);
        return ResponseEntity.ok(savedTransaction);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Transaction> update
            (@PathVariable Integer id,
             @RequestBody Transaction transaction) {
        Optional<Transaction> oTransaction = transactionRepository.findById(id);
        if (oTransaction.isPresent()) {
            transaction.setId(id);
            return ResponseEntity.ok(transactionRepository.save(transaction));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
            
    @DeleteMapping("/{id}")
    public ResponseEntity<Transaction> delete
            (@PathVariable Integer id) {
        Optional<Transaction> oTransaction = transactionRepository.findById(id);
        if (oTransaction.isPresent()) {
            transactionRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
            
    @GetMapping("/{id}/messages")
    public ResponseEntity<Iterable<Message>> messages
            (@PathVariable Integer id) {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        if (transaction.isPresent()) {
            return ResponseEntity.ok(transaction.get().getMessages());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
            
    @PostMapping("/{id}/messages")
    public ResponseEntity<Message> insertMessage
            (@PathVariable Integer id,
             @RequestBody Message message) {
        Optional<Transaction> oTransaction = transactionRepository.findById(id);
        if (oTransaction.isPresent()) {
            Transaction transaction = oTransaction.get();
            message.setTransaction(transaction);
            return ResponseEntity.ok(
                messageRepository.save(message));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
            
    @GetMapping("/{id}/types")
    public ResponseEntity<Iterable<Type>> types
        (@PathVariable Integer id) {
        Optional<Transaction> oTransaction = transactionRepository.findById(id);
        if (oTransaction.isPresent()) {
            return ResponseEntity.ok(oTransaction.get().getTypes());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
        
    @PostMapping("/{id}/types")
    public ResponseEntity<Type> insertType
        (@PathVariable Integer id, 
         @RequestBody Type type) {
        Optional<Transaction> oTransaction = transactionRepository.findById(id);
        if (oTransaction.isPresent()) {
            Transaction transaction = oTransaction.get();
            Type newType = typeRepository.save(type);
            transaction.getTypes().add(newType);
            transactionRepository.save(transaction);
            return ResponseEntity.ok(newType);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
        
    @PutMapping("/{id}/types")
    public ResponseEntity<Iterable<Type>> modifyTypes
        (@PathVariable Integer id,
         @RequestBody List<Type> types) {
        Optional<Transaction> oTransaction = transactionRepository.findById(id);
        if (oTransaction.isPresent()) {
            Transaction transaction = oTransaction.get();
            
            for (Type type: types) {
                if (type.getId() == null) {
                    typeRepository.save(type);
                }
            }
            
            transaction.setTypes(types);
            transactionRepository.save(transaction);
            return ResponseEntity.ok(types);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
