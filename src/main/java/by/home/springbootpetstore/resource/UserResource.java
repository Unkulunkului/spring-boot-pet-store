package by.home.springbootpetstore.resource;

import by.home.springbootpetstore.model.User;
import by.home.springbootpetstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserResource {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User>createUser(@Valid @RequestBody User user){
        userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/createWithList")
    public ResponseEntity<List<User>> createWithList(@RequestBody List<User> users){
        userService.addAllList(users);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/createWithArray")
    public ResponseEntity<User []>createWithList(@RequestBody User[] users){
        userService.addAllArray(users);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{userName}")
    public ResponseEntity<User> getByUserName(@PathVariable("userName") String userName){
        User byUserName = userService.getByUserName(userName);
        if (byUserName != null) {
            return new ResponseEntity<>(byUserName, HttpStatus.OK);
        }
        return new ResponseEntity<>(byUserName, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{userName}")
    public ResponseEntity<User> updateUserName(@PathVariable("userName")String userName, @RequestBody User user){
        if (userService.updateByUserName(user, userName)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{userName}")
    public ResponseEntity<User> deleteByUserName(@PathVariable("userName") String userName){
        if (userService.deleteByUserName(userName)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
