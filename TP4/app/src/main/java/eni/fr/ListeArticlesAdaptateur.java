package eni.fr;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class ListeArticlesAdaptateur extends RecyclerView.Adapter<ListeArticlesAdaptateur.ViewHolder> {

    ArrayList<Article> listArticles = new ArrayList();
    private View.OnClickListener clickArticle;

    public ListeArticlesAdaptateur(ArrayList<Article> listeArticles, View.OnClickListener clickArticle){
        this.listArticles = listeArticles;
        this.clickArticle = clickArticle;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public RatingBar degreEnvie;
        public ViewHolder(View v, View.OnClickListener clickArticle){
            super(v);
            name = v.findViewById(R.id.nom);
            degreEnvie = v.findViewById(R.id.degreEnvie);
            v.setOnClickListener(clickArticle);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_card, parent, false);
        return new ViewHolder(v,clickArticle);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(listArticles.get(position).nom);
        holder.degreEnvie.setRating(listArticles.get(position).degreEnvie);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return listArticles.size();
    }
}