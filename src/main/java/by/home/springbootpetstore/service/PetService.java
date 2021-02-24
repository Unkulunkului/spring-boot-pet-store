package by.home.springbootpetstore.service;

import by.home.springbootpetstore.model.*;
import by.home.springbootpetstore.storage.InMemoryPetStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetService {
    @Autowired
    private InMemoryPetStorage inMemoryPetStorage;
    @Autowired
    private TagService tagService;
    @Autowired
    private CategoryService categoryService;

    public boolean save(Pet pet){
        List<Tag> tags = pet.getTags();
        pet.setTags(updateTags(tags));
        Category category = pet.getCategory();
        pet.setCategory(updateCategory(category));
        return inMemoryPetStorage.add(pet);
    }

    private List<Tag> updateTags(List<Tag>tags){
        List<Tag> tagList = new ArrayList<>();
        for (Tag tag : tags) {
            long id = tag.getId();
            Tag byId = tagService.getById(id);
            tagList.add(byId);
        }
        return tagList;
    }

    private Category updateCategory(Category category){
        long id = category.getId();
        Category byId = categoryService.getById(id);
        return byId;
    }

    public boolean update(Pet pet){
        List<Tag> tags = pet.getTags();
        pet.setTags(updateTags(tags));
        Category category = pet.getCategory();
        pet.setCategory(updateCategory(category));
        return inMemoryPetStorage.update(pet);
    }

    public List<Pet> getByStatus(PetStatusEnum status){
        return inMemoryPetStorage.getByStatus(status);
    }

    public Pet getById(long id){
        return inMemoryPetStorage.getById(id);
    }

    public boolean updateById(PetDTO pet){
        return inMemoryPetStorage.updateById(pet);
    }


    public boolean deleteById(long id){
        return inMemoryPetStorage.deleteById(id);
    }
}
