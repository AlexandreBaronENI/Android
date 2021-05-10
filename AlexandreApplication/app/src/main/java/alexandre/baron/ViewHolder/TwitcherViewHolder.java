package alexandre.baron.ViewHolder;

import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import alexandre.baron.R;
import alexandre.baron.bo.Twitcher;

public class TwitcherViewHolder extends RecyclerView.ViewHolder {

    private TextView nameTwitcher;
    private ImageView imageTwitcher;

    public TwitcherViewHolder(View itemView, View.OnClickListener clickListener) {
        super(itemView);
        nameTwitcher = itemView.findViewById(R.id.tv_pseudo_twitcher);
        imageTwitcher = itemView.findViewById(R.id.iv_profile_pic);
        itemView.setOnClickListener(clickListener);
    }

    public void updateWithTwitcher(Twitcher twitcher) {
        this.nameTwitcher.setText(twitcher.getPseudo());
        Picasso.get().load(twitcher.getProfilePicture()).into(imageTwitcher);
    }
}
