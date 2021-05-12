package alexandre.pratique.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import alexandre.pratique.R;
import alexandre.pratique.bo.Article;

public class ArticleViewHolder extends RecyclerView.ViewHolder {

    private ImageView articleImage;
    private TextView articleName;
    private TextView articleDescription;

    public ArticleViewHolder(View view, View.OnClickListener onClickListener) {

        super(view);
        articleName = view.findViewById(R.id.tv_article_name);
        articleDescription = view.findViewById(R.id.tv_article_description);
        articleImage = view.findViewById(R.id.iv_article_picture);
        view.setOnClickListener(onClickListener);
    }

    public void updateWithArticle(Article article) {
        this.articleName.setText(article.getName());
        this.articleDescription.setText(article.getDescription());
        Picasso.get().load(article.getUriPicture()).into(articleImage);
    }
}
