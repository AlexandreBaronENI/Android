package alexandre.pratique.ViewHolder;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import alexandre.pratique.R;
import alexandre.pratique.bo.CategoriesWithArticle;
import alexandre.pratique.bo.Category;

public class CategoryViewHolder extends RecyclerView.ViewHolder {

    private ImageView categoryImage;
    private TextView categoryName, nbArticles;

    public CategoryViewHolder(View view, View.OnClickListener onClickListener) {
        super(view);
        categoryName = view.findViewById(R.id.tv_category_name);
        nbArticles = view.findViewById(R.id.tv_articles_number);
        categoryImage = view.findViewById(R.id.iv_category_picture);
        view.setOnClickListener(onClickListener);
    }

    public void updateWithCategory(Category category) {
        this.categoryName.setText(category.getName());
        Picasso.get().load("https://images.unsplash.com/photo-1511367461989-f85a21fda167").into(categoryImage);
    }
}
