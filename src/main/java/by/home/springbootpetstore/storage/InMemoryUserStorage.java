package by.home.springbootpetstore.storage;


import by.home.springbootpetstore.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryUserStorage {

    private static long gen = 0;
    private List<User>userList = new ArrayList<>();


    public boolean createUser(User user){
        user.setId(gen++);
        return userList.add(user);
    }

    public boolean addAllList(List<User> users){
        for (User user : users) {
            user.setId(gen++);
        }
        return userList.addAll(users);
    }

    public void addAllArray(User [] users){
        for (User user : users) {
            user.setId(gen++);
            userList.add(user);
        }
    }

    public User getByUserName(String userName){
        for (User userFromList : userList) {
            if (userFromList.getUsername().equals(userName)) {
                return userFromList;
            }
        }
        return null;
    }

    public boolean updateByUserName(User user, String userName){
        for (int i = 0; i < userList.size(); i++) {
            User userFromList = userList.get(i);
            if (userFromList.getUsername().equals(userName)) {
                user.setId(userFromList.getId());
                userList.set(i,user);
                return true;
            }
        }
        return false;
    }

    public boolean deleteByUserName(String userName){
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUsername().equals(userName)) {
                userList.remove(i);
                return true;
            }
        }
        return false;
    }
}
