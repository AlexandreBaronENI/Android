package alexandre.pratique;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.parceler.Parcels;

import alexandre.pratique.bo.Article;
import alexandre.pratique.bo.Category;

public class ArticleAddActivity extends AppCompatActivity {

    private EditText name, description, prix, uriPicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_add);

        name = findViewById(R.id.tv_article_name);
        description = findViewById(R.id.tv_article_description);
        prix = findViewById(R.id.tv_article_prix);
        uriPicture = findViewById(R.id.tv_article_uriPicture);
    }

    public void Add(View view) {

        Article article = new Article(name.getText().toString(), description.getText().toString(), Double.parseDouble(prix.getText().toString()), 1, uriPicture.getText().toString());

        AppDatabase db = Connection.getConnection(this);

        db.articleDao().insert(article);

        Intent intent = new Intent(ArticleAddActivity.this, CategoryDetailActivity.class);
        intent.putExtra(Category.ClassName, Parcels.wrap(db.categoryDao().getById(1)));
        startActivity(intent);
    }
}