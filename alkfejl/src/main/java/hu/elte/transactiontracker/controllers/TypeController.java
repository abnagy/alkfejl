package hu.elte.transactiontracker.controllers;

import hu.elte.transactiontracker.entities.Type;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hu.elte.transactiontracker.repositories.TypeRepository;

@RestController
@RequestMapping("/types")
public class TypeController {
    @Autowired
    private TypeRepository typeRepository;
    
    @GetMapping("")
    public ResponseEntity<Iterable<Type>> getAll() {
        return ResponseEntity.ok(typeRepository.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Type> get(@PathVariable Integer id) {
        Optional<Type> type = typeRepository.findById(id);
        if (type.isPresent()) {
            return ResponseEntity.ok(type.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("")
    public ResponseEntity<Type> post(@RequestBody Type type) {
        Type savedType = typeRepository.save(type);
        return ResponseEntity.ok(savedType);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Type> put(@RequestBody Type type, @PathVariable Integer id) {
        Optional<Type> oType = typeRepository.findById(id);
        if (oType.isPresent()) {
            type.setId(id);
            return ResponseEntity.ok(typeRepository.save(type));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        Optional<Type> oType = typeRepository.findById(id);
        if (oType.isPresent()) {
            typeRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
