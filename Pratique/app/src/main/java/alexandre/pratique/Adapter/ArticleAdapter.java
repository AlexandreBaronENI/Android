package alexandre.pratique.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import alexandre.pratique.R;
import alexandre.pratique.ViewHolder.ArticleViewHolder;
import alexandre.pratique.bo.Article;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleViewHolder>{

    private View.OnClickListener onClickListener;
    private List<Article> articles;

    public ArticleAdapter(List<Article> articles, View.OnClickListener clickListener){
        this.articles = articles;
        this.onClickListener = clickListener;
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.view_article_card, parent,false);

        return new ArticleViewHolder(view, onClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        holder.updateWithArticle(this.articles.get(position));
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return this.articles.size();
    }
}
