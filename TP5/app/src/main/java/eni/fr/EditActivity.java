package eni.fr;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EditActivity extends AppCompatActivity {

    private EditText prix, nom, url, description;
    private RatingBar degreEnvie;
    private int id;
    private Article article;
    private ArticleDAO dao = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        article = getIntent().getParcelableExtra("article");

        prix = findViewById(R.id.prix);
        nom = findViewById(R.id.nom);
        description = findViewById(R.id.description);
        degreEnvie = findViewById(R.id.degreEnvie);
        url = findViewById(R.id.url);

        nom.setText(article.nom);
        description.setText(article.description);
        url.setText(article.url);
        prix.setText(Double.toString(article.prix));
        degreEnvie.setRating(article.degreEnvie);

        dao = new ArticleDAO(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        dao = new ArticleDAO(this);
    }

    public void Modifier(View view) {
        article.nom = nom.getText().toString();
        article.description = description.getText().toString();
        article.prix = Double.parseDouble(prix.getText().toString());
        article.degreEnvie = (int) (degreEnvie.getRating() + 1);
        article.url = url.toString();

        dao.update(article);

        Intent intent = new Intent(EditActivity.this, MainActivity.class);
        intent.putExtra("article", article);
        startActivity(intent);
    }
}
