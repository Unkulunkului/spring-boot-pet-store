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
        return inMemoryUserStorage.add(user);
    }

    public void addAllList(List<User> users){
        for (User user : users) {
            inMemoryUserStorage.add(user);
        }
    }

    public void addAllArray(User [] users){
        for (User user : users) {
            inMemoryUserStorage.add(user);
        }
    }

    public User getByUserName(String userName){
        return inMemoryUserStorage.getByUserName(userName);
    }

    public boolean updateByUserName(User user, String userName){
        return inMemoryUserStorage.updateByUserName(user, userName);
    }

    public boolean deleteByUserName(String userName){
        return inMemoryUserStorage.deleteByUserName(userName);
    }
}
