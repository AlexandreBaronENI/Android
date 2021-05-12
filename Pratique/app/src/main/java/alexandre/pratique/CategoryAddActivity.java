package alexandre.pratique;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import org.parceler.Parcels;

import alexandre.pratique.bo.Category;

public class CategoryAddActivity extends AppCompatActivity {

    EditText uriPicture, name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_add);

        uriPicture = findViewById(R.id.tv_category_uriPicture);
        name = findViewById(R.id.tv_category_name);
    }

    public void AddCategory(View view) {
        Category category = new Category(name.getText().toString(), uriPicture.getText().toString());

        AppDatabase db = Connection.getConnection(this);

        db.categoryDao().insert(category);

        Intent intent = new Intent(CategoryAddActivity.this, CategoriesListActivity.class);
        startActivity(intent);
    }
}