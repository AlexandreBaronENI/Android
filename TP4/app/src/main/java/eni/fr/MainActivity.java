package eni.fr;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private Article article;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        article = getIntent().getParcelableExtra("article");

        TextView nom = findViewById(R.id.nom);
        TextView prix = findViewById(R.id.prix);
        RatingBar degreEnvie = findViewById(R.id.degreEnvie);
        TextView description = findViewById(R.id.description);
        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        nom.setText(article.nom);
        description.setText(article.description);
        prix.setText(Double.toString(article.prix) + " €");
        degreEnvie.setRating(article.degreEnvie);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menumain, menu);
        return true;
    }

    public void GoToUrl(View view) {
        //Toast.makeText(this, article.url, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, InfoUrlActivity.class);
        intent.putExtra("article", article);

        startActivity(intent);
    }
}