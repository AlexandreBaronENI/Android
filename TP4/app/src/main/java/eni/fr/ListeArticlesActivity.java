package eni.fr;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListeArticlesActivity  extends AppCompatActivity {

    ArrayList<Article> articles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_articles);


        articles.add(new Article("Pain au chocolat", "Pate feuilletée avec du chocolat à l'intérieur", 1.10, 3, "https://www.google.com/search?q=pain+au+chocolat"));
        articles.add(new Article("Croissant", "Pate feuilletée avec BEAUCOUP de beurre", 0.90, 5, "https://www.google.com/search?q=croissant"));
        articles.add(new Article("Pain aux raisins", "Pate feuilletée je crois avec des raisins", 1.20, 1, "https://www.google.com/search?q=pain+au+raisin"));

        Toolbar toolbar = findViewById(R.id.toolbar);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        ListeArticlesAdaptateur listeArticlesAdaptateur = new ListeArticlesAdaptateur(articles, clickArticle);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.liste_articles);

        setSupportActionBar(toolbar);
        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(listeArticlesAdaptateur);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuarticles, menu);
        return true;
    }

    private View.OnClickListener clickArticle = new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {
            int position = Integer.parseInt(view.getTag().toString());
            Intent intent = new Intent(ListeArticlesActivity.this,MainActivity.class);
            intent.putExtra("article", articles.get(position));
            startActivity(intent);
        }
    };
}