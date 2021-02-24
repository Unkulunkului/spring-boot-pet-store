package by.home.springbootpetstore.service;

import by.home.springbootpetstore.storage.InMemoryOrderStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService {
    @Autowired
    public InMemoryOrderStorage inMemoryOrderStorage;

    
}
