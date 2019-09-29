package com.trash_sorter.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String trashCategoria;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "tanks_and_cats",
            joinColumns = {@JoinColumn(name="category_id")},
            inverseJoinColumns = {@JoinColumn(name = "tank_id")}
    )
    private Set<Category> categories = new HashSet<>();

    public Category() {
    }

    public Category(String trashCategoria) {
        this.trashCategoria = trashCategoria;
    }

    public Category(long id, String trashCategoria) {
        this.id = id;
        this.trashCategoria = trashCategoria;
    }

    public long getId() {
        return id;
    }

    public String getTrashCategoria() {
        return trashCategoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category categoryModel = (Category) o;
        return id == categoryModel.id &&
                Objects.equals(trashCategoria, categoryModel.trashCategoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, trashCategoria);
    }
}
