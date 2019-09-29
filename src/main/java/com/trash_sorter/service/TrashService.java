package com.trash_sorter.service;

import com.trash_sorter.model.Trash;

import java.io.IOException;
import java.util.List;

public interface TrashService {
    boolean deleteTrash(Trash trash);
    String[] getTrashName(String barcode) throws IOException;
    List<String> getAllTrashById(long id);
    List<Trash> getAllTrash();
    Trash getTrashById(long id);
    boolean addNewTrash(Trash trashName);
    boolean addNewCategory(long trash_id, long cat_id);
}
