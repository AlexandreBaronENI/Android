package alexandre.pratique.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.List;

import alexandre.pratique.CategoriesListActivity;
import alexandre.pratique.CategoryDetailActivity;
import alexandre.pratique.R;
import alexandre.pratique.bo.CategoriesWithArticle;
import alexandre.pratique.bo.Category;

public class CategoryWithArticlesAdapter extends RecyclerView.Adapter<CategoryWithArticlesAdapter.CategoryWithArticlesViewHolder>{

    private List<CategoriesWithArticle> categories;

    public CategoryWithArticlesAdapter(List<CategoriesWithArticle> categorys){
        this.categories = categorys;
    }

    @Override
    public CategoryWithArticlesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.view_category_card, parent,false);

        return new CategoryWithArticlesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryWithArticlesViewHolder holder, int position) {
        holder.updateWithCategory(this.categories.get(position));
    }

    @Override
    public int getItemCount() {
        return this.categories.size();
    }

    class CategoryWithArticlesViewHolder extends RecyclerView.ViewHolder {

        private ImageView categoryImage;
        private TextView categoryName, nbArticles;

        public CategoryWithArticlesViewHolder(View view) {
            super(view);
            categoryName = view.findViewById(R.id.tv_category_name);
            nbArticles = view.findViewById(R.id.tv_articles_number);
            categoryImage = view.findViewById(R.id.iv_category_picture);


            view.setOnClickListener(v -> {
                Intent intent = new Intent(view.getContext(), CategoryDetailActivity.class);
                intent.putExtra(Category.ClassName, Parcels.wrap(categories.get(getAdapterPosition())));
                view.getContext().startActivity(intent);
            });
        }

        public void updateWithCategory(CategoriesWithArticle category) {
            this.categoryName.setText(category.getCategory().getName());
            this.nbArticles.setText(category.getArticleList().size()+"");
            Picasso.get().load(category.getCategory().getUriPicture()).into(categoryImage);
        }
    }
}
