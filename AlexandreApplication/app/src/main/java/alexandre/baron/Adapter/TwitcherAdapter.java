package alexandre.baron.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import alexandre.baron.R;
import alexandre.baron.ViewHolder.TwitcherViewHolder;
import alexandre.baron.bo.Twitcher;


public class TwitcherAdapter extends RecyclerView.Adapter<TwitcherViewHolder> {

    private View.OnClickListener clickListener;
    private List<Twitcher> twitchers;

    public TwitcherAdapter(List<Twitcher> twitchers, View.OnClickListener clickListener){
        this.twitchers = twitchers;
        this.clickListener = clickListener;
    }

    @Override
    public TwitcherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.twitcher_snippet, parent, false);

        return new TwitcherViewHolder(view, clickListener);
    }

    @Override
    public void onBindViewHolder(TwitcherViewHolder holder, int position) {
        holder.updateWithTwitcher(this.twitchers.get(position));
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return this.twitchers.size();
    }
}
