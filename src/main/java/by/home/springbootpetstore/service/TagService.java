package by.home.springbootpetstore.service;

import by.home.springbootpetstore.model.Tag;
import by.home.springbootpetstore.storage.InMemoryTagStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService {
    @Autowired
    private InMemoryTagStorage inMemoryTagStorage;

    public boolean save(Tag tag){
        return inMemoryTagStorage.add(tag);
    }

    public Tag getById(long id){
        return inMemoryTagStorage.getById(id);
    }
}
