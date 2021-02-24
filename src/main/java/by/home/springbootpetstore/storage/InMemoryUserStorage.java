package by.home.springbootpetstore.storage;


import by.home.springbootpetstore.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryUserStorage {

    private List<User>userList = new ArrayList<>();
}
