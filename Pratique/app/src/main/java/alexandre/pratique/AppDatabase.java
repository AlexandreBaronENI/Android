package alexandre.pratique;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import alexandre.pratique.bo.Article;
import alexandre.pratique.bo.Category;
import alexandre.pratique.dao.ArticleDao;
import alexandre.pratique.dao.CategoryDao;

@Database(entities = {Article.class, Category.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ArticleDao articleDao();
    public abstract CategoryDao categoryDao();

}
