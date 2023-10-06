package com.wangzs.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GameListAdapter extends RecyclerView.Adapter<GameListAdapter.GameViewHolder> {

    private Context context;
    private List<String> mList;

    public GameListAdapter(Context context, List<String> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_game_list, parent, false);
        return new GameViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull GameViewHolder holder, int position) {
        if (position == 0) {
            ViewGroup.LayoutParams layoutParams = holder.root.getLayoutParams();
            layoutParams.width = 300;
        } else if (position == 1) {
            ViewGroup.LayoutParams layoutParams = holder.root.getLayoutParams();
            layoutParams.width = 400;
        }

        holder.textView.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class GameViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ConstraintLayout root;
        public GameViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.gameName);
            root = itemView.findViewById(R.id.gameItemRoot);
        }
    }
}

