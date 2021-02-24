package by.home.springbootpetstore.service;

import by.home.springbootpetstore.model.Category;
import by.home.springbootpetstore.storage.InMemoryCategoryStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private InMemoryCategoryStorage inMemoryCategoryStorage;

    public boolean save(Category category){
        return inMemoryCategoryStorage.add(category);
    }

    public Category getById(long id){
        return inMemoryCategoryStorage.getById(id);
    }
}
