package alexandre.pratique;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import alexandre.pratique.bo.Article;

public class ArticleDetailActivity extends AppCompatActivity {
    private Article article;
    private TextView name, description;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);

        article = Parcels.unwrap(getIntent().getParcelableExtra(Article.ClassName));

        name = findViewById(R.id.tv_article_name);
        description = findViewById(R.id.tv_article_description);
        imageView = findViewById(R.id.iv_article_picture);

        name.setText(article.getName());
        description.setText(article.getDescription());
        Picasso.get().load(article.getUriPicture()).into(imageView);
    }
}
