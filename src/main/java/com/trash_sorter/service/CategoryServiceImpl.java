package com.trash_sorter.service;

import com.trash_sorter.dao.CategoryDAO;
import com.trash_sorter.dao.CategoryDaoImpl;
import com.trash_sorter.model.Category;
import com.trash_sorter.util.Builder;
import com.trash_sorter.util.DbHelper;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    DbHelper helper = DbHelper.getInstance(Builder.getConfiguration());
    private final CategoryDAO dao;

    private static volatile CategoryServiceImpl instance;
    private CategoryServiceImpl() {
        this.dao = new CategoryDaoImpl(helper.getFactory());
    }
    public static CategoryServiceImpl getInstance(){
        if (instance == null){
            synchronized (CategoryDaoImpl.class){
                if (instance == null)
                    instance = new CategoryServiceImpl();
            }
        }
        return instance;
    }
    @Override
    public boolean addNewCategory(Category catName) {
        return dao.addNewCategory(catName);
    }

    @Override
    public boolean deleteCategory(Category cat) {
        return dao.deleteCategory(cat);
    }

    @Override
    public Category getCategoryById(long id) {
        return dao.getCategoryById(id);
    }

    @Override
    public List<String> getCategoriesName() {
        return dao.getCategoriesName();
    }

    @Override
    public List<Category> getAllCategories() {
        return dao.getAllCategories();
    }

    @Override
    public List<Category> getAllCategoryByTankId(long tankId) {
        return dao.getAllCategoryByTankId(tankId);
    }
}
