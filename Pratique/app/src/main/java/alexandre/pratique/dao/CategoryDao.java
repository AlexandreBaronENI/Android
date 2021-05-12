package alexandre.pratique.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

import alexandre.pratique.bo.CategoriesWithArticle;
import alexandre.pratique.bo.Category;

@Dao
public interface CategoryDao {
    @Query("SELECT * FROM Category")
    List<Category> getAll();
    @Query("SELECT * FROM Category WHERE categoryId = :id")
    Category getById(int id);
    @Transaction
    @Query("SELECT * FROM Category")
    List<CategoriesWithArticle> getCategoriesWithArticle();
    @Update
    void update(Category category);
    @Delete
    void delete(Category category);
    @Insert
    void insert(Category category);
}
