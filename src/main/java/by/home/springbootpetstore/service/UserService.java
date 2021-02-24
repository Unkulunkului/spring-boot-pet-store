package by.home.springbootpetstore.service;

import by.home.springbootpetstore.model.User;
import by.home.springbootpetstore.storage.InMemoryUserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private InMemoryUserStorage inMemoryUserStorage;

    public boolean save(User user){
        return inMemoryUserStorage.createUser(user);
    }

    public boolean addAllList(List<User> users){
        return inMemoryUserStorage.addAllList(users);
    }

    public void addAllArray(User [] users){
        inMemoryUserStorage.addAllArray(users);
    }

    public User getByUserName(String userName){
        return inMemoryUserStorage.getByUserName(userName);
    }

    public boolean updateByUserName(User user){
        return inMemoryUserStorage.updateByUserName(user);
    }

    public boolean deleteByUserName(String userName){
        return inMemoryUserStorage.deleteByUserName(userName);
    }
}
