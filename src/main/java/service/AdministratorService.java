package service;

import java.sql.Connection;

public class AdministratorService {
    private CategoryService categoryService;

    public AdministratorService(Connection connection)
    {
        this.categoryService = new CategoryService(connection);

    }

    public int saveCategoryParent(String id, String categoryName){
        return categoryService.save(id,categoryName);
    }

    public int saveSubCategory(String id,String categoryName,String parentId){
        return categoryService.save(id,categoryName,parentId);

    }
}
