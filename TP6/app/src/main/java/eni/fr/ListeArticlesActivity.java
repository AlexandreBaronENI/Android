package eni.fr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListeArticlesActivity extends AppCompatActivity {

    ArrayList<Article> articles = new ArrayList<>();

    @Override
    protected void onCreate(android.os.Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_articles);
        ArticleDAO dao = new ArticleDAO(this);

        SharedPreferences spIntra = getSharedPreferences("configuration",MODE_PRIVATE);
        boolean tri = spIntra.getBoolean(ConfigurationActivity.CLE_TRI,false);

        // Article painAuChocolat = new Article(1, "Pain au chocolat", "Pate feuilletée avec du chocolat à l'intérieur", 1.10, 3, "https://www.google.com/search?q=pain+au+chocolat", false);
        // Article croissant = new Article(2, "Croissant", "Pate feuilletée avec BEAUCOUP de beurre", 0.90, 5, "https://www.google.com/search?q=croissant", false);
        // Article painAuxRaisins = new Article(3, "Pain aux raisins", "Pate feuilletée je crois avec des raisins", 1.20, 1, "https://www.google.com/search?q=pain+au+raisin", false);

        // dao.insert(painAuChocolat);
        // dao.insert(croissant);
        // dao.insert(painAuxRaisins);

        articles = dao.get(tri);

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        ListeArticlesAdaptateur listeArticlesAdaptateur = new ListeArticlesAdaptateur(articles, clickArticle);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.liste_articles);

        setSupportActionBar(toolbar);
        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(listeArticlesAdaptateur);
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.menuarticles, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@androidx.annotation.NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.points :
                Intent intent = new Intent(this, ConfigurationActivity.class);
                startActivity(intent);
                break;
            case R.id.plus :
                Intent intent2 = new Intent(this, AjoutActivity.class);
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private android.view.View.OnClickListener clickArticle = new android.view.View.OnClickListener()
    {
        @Override
        public void onClick(android.view.View view)
        {
            int position = Integer.parseInt(view.getTag().toString());
            Intent intent = new Intent(ListeArticlesActivity.this, MainActivity.class);
            intent.putExtra("article", articles.get(position));
            startActivity(intent);
        }
    };
}