package eni.fr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AjoutActivity extends AppCompatActivity {

    private EditText prix, nom, url, description;
    private RatingBar degreEnvie;
    private Article article;
    private ArticleDAO dao = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);

        prix = findViewById(R.id.prix);
        nom = findViewById(R.id.nom);
        description = findViewById(R.id.description);
        degreEnvie = findViewById(R.id.degreEnvie);
        url = findViewById(R.id.url);

        SharedPreferences spIntra = getSharedPreferences("configuration",MODE_PRIVATE);
        String prixDefault = spIntra.getString(ConfigurationActivity.CLE_PRIX,"");
        prix.setText(prixDefault);

        dao = new ArticleDAO(this);
    }

    public void Ajouter(View view) {
        article = new Article();

        article.nom = nom.getText().toString();
        article.description = description.getText().toString();
        article.prix = Double.parseDouble(prix.getText().toString());
        article.degreEnvie = (int) (degreEnvie.getRating() + 1);
        article.url = url.getText().toString();

        dao.insert(article);

        Intent intent = new Intent(AjoutActivity.this, MainActivity.class);
        intent.putExtra("article", article);
        startActivity(intent);
    }
}
