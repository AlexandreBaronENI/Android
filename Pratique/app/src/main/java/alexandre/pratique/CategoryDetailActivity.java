package alexandre.pratique;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import alexandre.pratique.Adapter.ArticleAdapter;
import alexandre.pratique.bo.Article;
import alexandre.pratique.bo.CategoriesWithArticle;
import alexandre.pratique.bo.Category;

public class CategoryDetailActivity extends AppCompatActivity {
    private CategoriesWithArticle category;
    private TextView name;
    private ImageView imageView;

    private RecyclerView recyclerView;
    private ArticleAdapter articleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_detail);

        category = Parcels.unwrap(getIntent().getParcelableExtra(Category.ClassName));

        name = findViewById(R.id.tv_category_name);
        imageView = findViewById(R.id.iv_category_picture);

        name.setText(category.getCategory().getName());
        Picasso.get().load(category.getCategory().getUriPicture()).into(imageView);

        this.articleAdapter = new ArticleAdapter(this.category.getArticleList(), onClickListener);
        this.recyclerView = findViewById(R.id.list_articles);
        this.recyclerView.setAdapter(this.articleAdapter);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int position = Integer.parseInt(v.getTag().toString());
            Intent intent = new Intent(CategoryDetailActivity.this, ArticleDetailActivity.class);
            intent.putExtra(Article.ClassName, Parcels.wrap(category.getArticleList().get(position)));
            startActivity(intent);
        }
    };

    public void GoToAddArticle(View view) {

        Intent intent = new Intent(CategoryDetailActivity.this, ArticleAddActivity.class);
        startActivity(intent);
    }
}
