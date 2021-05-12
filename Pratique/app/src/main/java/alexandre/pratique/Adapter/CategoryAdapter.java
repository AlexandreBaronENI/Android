package alexandre.pratique.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import alexandre.pratique.R;
import alexandre.pratique.ViewHolder.CategoryViewHolder;
import alexandre.pratique.bo.CategoriesWithArticle;
import alexandre.pratique.bo.Category;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder>{

    private View.OnClickListener onClickListener;
    private List<Category> categories;

    public CategoryAdapter(List<Category> categorys, View.OnClickListener clickListener){
        this.categories = categorys;
        this.onClickListener = clickListener;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.view_category_card, parent,false);

        return new CategoryViewHolder(view, onClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.updateWithCategory(this.categories.get(position));
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return this.categories.size();
    }
}
