package com.trash_sorter.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "trash")
public class Trash {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category categoryModel;

    public Trash() {
    }


    public Trash(int id) {
        this.id = id;
    }

    public Trash(String name, Category categoryModel) {
        this.id = -1;
        this.name=name;
        this.categoryModel = categoryModel;
    }

    public Trash(String catName){
        this.name = catName;
    }

    public Trash(int id, String name, Category categoryModel) {
        this.id = id;
        this.name=name;
        this.categoryModel = categoryModel;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Category getCategoryModel() {
        return categoryModel;
    }

    public void setCategoryModel(Category categoryModel) {
        this.categoryModel = categoryModel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trash that = (Trash) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(categoryModel, that.categoryModel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, categoryModel);
    }
}
