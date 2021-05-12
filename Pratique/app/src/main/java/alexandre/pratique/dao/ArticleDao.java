package alexandre.pratique.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import alexandre.pratique.bo.Article;

@Dao
public interface ArticleDao {
    @Query("SELECT * FROM Article")
    List<Article> getAll();
    @Query("SELECT * FROM Article WHERE articleId = :articleId")
    Article getById(int articleId);
    @Update
    void update(Article article);
    @Delete
    void delete(Article article);
    @Insert
    void insert(Article article);
}
