package eni.fr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Rating;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    Article article = new Article("Pain au chocolat", "C'est beaucoup trop bon", 0.95, 4, "https://www.google.com/search?q=pain+au+chocolat");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView nom = findViewById(R.id.nom);
        nom.setText(article.nom);

        TextView description = findViewById(R.id.description);
        description.setText(article.description);

        TextView prix = findViewById(R.id.prix);
        prix.setText(Double.toString(article.prix) + " €");

        RatingBar degreEnvie = findViewById(R.id.degreEnvie);
        degreEnvie.setRating(article.degreEnvie);
    }

    public void GoToUrl(View view) {
        //Toast.makeText(this, article.url, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, InfoUrlActivity.class);
        intent.putExtra("article", article);

        startActivity(intent);
    }
}