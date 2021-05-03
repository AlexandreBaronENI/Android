package eni.fr;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Article article;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        article = getIntent().getParcelableExtra("article");

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