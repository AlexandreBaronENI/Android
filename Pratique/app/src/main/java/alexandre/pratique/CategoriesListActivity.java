package alexandre.pratique;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.parceler.Parcels;

import java.util.Arrays;
import java.util.List;

import alexandre.pratique.Adapter.CategoryWithArticlesAdapter;
import alexandre.pratique.bo.Article;
import alexandre.pratique.bo.CategoriesWithArticle;
import alexandre.pratique.bo.Category;

public class CategoriesListActivity extends AppCompatActivity {

    private List<CategoriesWithArticle> categoryList;
    private RecyclerView recyclerView;
    private CategoryWithArticlesAdapter categoryWithArticlesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories_list);

        List<Article> articles = Arrays.asList(new Article(1, "Article1", "Description", 15.20, 1, "https://i.pinimg.com/originals/09/88/dc/0988dc27ab24d196b91d085c786c292d.png"),
        new Article(2, "Article2", "Description", 15.20, 1, "https://i.pinimg.com/originals/09/88/dc/0988dc27ab24d196b91d085c786c292d.png"),
        new Article(3, "Article3", "Description", 15.20, 1, "https://i.pinimg.com/originals/09/88/dc/0988dc27ab24d196b91d085c786c292d.png"),
        new Article(4, "Article4", "Description", 15.20, 1, "https://i.pinimg.com/originals/09/88/dc/0988dc27ab24d196b91d085c786c292d.png"),
        new Article(5, "Article5", "Description", 15.20, 1, "https://i.pinimg.com/originals/09/88/dc/0988dc27ab24d196b91d085c786c292d.png"),
        new Article(6, "Article6", "Description", 15.20, 1, "https://i.pinimg.com/originals/09/88/dc/0988dc27ab24d196b91d085c786c292d.png"));

        // this.categoryList = Arrays.asList(new CategoriesWithArticle[]{
        //         new CategoriesWithArticle(new Category(1, "Vehicules", "https://www.grimaldi-lines.com/wp-content/uploads/2019/06/foto2-1.png"), articles),
        //         new CategoriesWithArticle(new Category(2, "Mode", "https://image.flaticon.com/icons/png/512/68/68946.png"), new ArrayList<Article>()),
        //         new CategoriesWithArticle(new Category(3, "Maison", "https://img.icons8.com/emoji/452/house-emoji.png"), new ArrayList<Article>()),
        //         new CategoriesWithArticle(new Category(4, "Multimédia", "https://image.freepik.com/free-vector/coloured-multimedia-icons_1284-555.jpg"), new ArrayList<Article>()),
        //         new CategoriesWithArticle(new Category(5, "Loisirs", "https://cdn2.vectorstock.com/i/1000x1000/70/31/hobbies-and-activities-flat-icons-color-vector-8537031.jpg"), new ArrayList<Article>()),
        //         new CategoriesWithArticle(new Category(6, "Animaux", "http://www.freepik.com/blog/wp-content/uploads/2017/06/01a-3.png"), new ArrayList<Article>()),
        //         new CategoriesWithArticle(new Category(7, "Materiel professionel", "https://static.vecteezy.com/system/resources/previews/002/209/018/non_2x/equipment-leasing-broker-rgb-color-icon-vector.jpg"), new ArrayList<Article>()),
        //         new CategoriesWithArticle(new Category(8, "Divers", "https://images.all-free-download.com/images/graphiclarge/objects_icons_collection_colored_squares_isolation_6833056.jpg"), new ArrayList<Article>()),
        // });

        List<Category> categoryList2 = Arrays.asList(new Category[]{
        new Category(1, "Vehicules", "https://www.grimaldi-lines.com/wp-content/uploads/2019/06/foto2-1.png"),
        new Category(2, "Mode", "https://image.flaticon.com/icons/png/512/68/68946.png"),
        new Category(3, "Maison", "https://img.icons8.com/emoji/452/house-emoji.png"),
        new Category(4, "Multimédia", "https://image.freepik.com/free-vector/coloured-multimedia-icons_1284-555.jpg"),
        new Category(5, "Loisirs", "https://cdn2.vectorstock.com/i/1000x1000/70/31/hobbies-and-activities-flat-icons-color-vector-8537031.jpg"),
        new Category(6, "Animaux", "http://www.freepik.com/blog/wp-content/uploads/2017/06/01a-3.png"),
        new Category(7, "Materiel professionel", "https://static.vecteezy.com/system/resources/previews/002/209/018/non_2x/equipment-leasing-broker-rgb-color-icon-vector.jpg"),
        new Category(8, "Divers", "https://images.all-free-download.com/images/graphiclarge/objects_icons_collection_colored_squares_isolation_6833056.jpg"),
        });

        AppDatabase db = Connection.getConnection(this);

        //for (int i = 0; i < categoryList2.size(); i++){
        //    db.categoryDao().insert(categoryList2.get(i));
        //}

        //for (int i = 0; i < articles.size(); i++){
        //    db.articleDao().insert(articles.get(i));
        //}

        this.categoryList = db.categoryDao().getCategoriesWithArticle();

        this.categoryWithArticlesAdapter = new CategoryWithArticlesAdapter(this.categoryList);
        this.recyclerView = findViewById(R.id.list_categories);
        this.recyclerView.setAdapter(this.categoryWithArticlesAdapter);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void GoToAddCategory(View view) {
        Intent intent = new Intent(CategoriesListActivity.this, CategoryAddActivity.class);
        startActivity(intent);
    }
}