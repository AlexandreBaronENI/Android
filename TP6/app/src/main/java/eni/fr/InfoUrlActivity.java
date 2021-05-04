package eni.fr;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class InfoUrlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_url);

        Intent intent = getIntent();
        Article article = intent.getParcelableExtra("article");

        android.widget.TextView url = findViewById(R.id.url);
        url.setText(article.url);
    }
}