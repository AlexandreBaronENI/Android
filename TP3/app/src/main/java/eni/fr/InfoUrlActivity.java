package eni.fr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class InfoUrlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_url);

        Intent intent = getIntent();
        Article article = intent.getParcelableExtra("article");

        TextView url = findViewById(R.id.url);
        url.setText(article.url);
    }
}