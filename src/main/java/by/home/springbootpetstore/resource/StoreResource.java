package by.home.springbootpetstore.resource;

import by.home.springbootpetstore.model.Order;
import by.home.springbootpetstore.model.OrderStatusEnum;
import by.home.springbootpetstore.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "/store")
public class StoreResource {

    @Autowired
    private StoreService storeService;

    @PostMapping("/order")
    public ResponseEntity<Order> saveOrder(@RequestBody Order order){
        storeService.save(order);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<Order> getById(@PathVariable("id") long id){
        Order byId = storeService.getById(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @DeleteMapping("/order/{id}")
    public ResponseEntity<Order> deleteById(@PathVariable("id") long id){
        if (storeService.deleteById(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/inventory")
    public ResponseEntity<Map<String, Integer>> getMapStatus(){
        Map<String, Integer> mapStatus = storeService.getMapStatus();
        return new ResponseEntity<>(mapStatus, HttpStatus.OK);
    }
}
