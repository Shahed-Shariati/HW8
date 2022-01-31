package repository;

import model.Category;

import java.util.List;

public class CategoryRepository implements Repository<Category>{
    @Override
    public int save(Category category) {
        return 0;
    }

    @Override
    public void upDate(Category category) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Category find(int id) {
        return null;
    }

    @Override
    public List<Category> findAll() {
        return null;
    }
}
