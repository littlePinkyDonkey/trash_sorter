package com.trash_sorter.dao;

import com.trash_sorter.model.Trash;

import java.util.List;

public interface TrashDAO {
    boolean deleteTrash(Trash trash);
    List<String> getAllTrashById(long id);
    List<Trash> getAllTrash();
    Trash getTrashById(long id);
    boolean addNewTrash(Trash trashName);
    boolean addNewCategory(long trash_id, long cat_id);
}
