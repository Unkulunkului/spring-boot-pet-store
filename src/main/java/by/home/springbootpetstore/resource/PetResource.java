package by.home.springbootpetstore.resource;

import by.home.springbootpetstore.model.Pet;
import by.home.springbootpetstore.model.PetStatusEnum;
import by.home.springbootpetstore.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/pet")
public class PetResource {

    @Autowired
    private PetService petService;

    @PostMapping
    public ResponseEntity<Pet> savePet(@Valid @RequestBody Pet pet){
        petService.save(pet);
        return new ResponseEntity<>(pet, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Pet> updatePet(@Valid @RequestBody Pet pet){
        if (petService.update(pet)) {
            return new ResponseEntity<>(pet, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("findByStatus")
    public ResponseEntity<List<Pet>> findByStatus(PetStatusEnum status){
        List<Pet> byStatus = petService.getByStatus(status);
        return new ResponseEntity<>(byStatus, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> findById(@PathVariable("id") long id){
        Pet byStatus = petService.getById(id);
        if (byStatus != null) {
            return new ResponseEntity<>(byStatus, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pet> deleteById(@PathVariable("id") long id){
        if (petService.deleteById(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
