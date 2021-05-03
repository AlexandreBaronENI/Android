package eni.fr;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Rating;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Article article = new Article("Pain au chocolat", "C'est beaucoup trop bon", 0.95, 4);

        TextView nom = findViewById(R.id.nom);
        nom.setText(article.nom);

        TextView description = findViewById(R.id.description);
        description.setText(article.description);

        TextView prix = findViewById(R.id.prix);
        prix.setText(Double.toString(article.prix) + " €");

        RatingBar degreEnvie = findViewById(R.id.degreEnvie);
        degreEnvie.setRating(article.degreEnvie);
    }
}