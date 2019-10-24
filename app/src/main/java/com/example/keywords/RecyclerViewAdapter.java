package com.example.keywords;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ItemHolder> {

    private List<String> keywords;

    public RecyclerViewAdapter(List<String> keywords) {
        this.setKeywords(keywords);
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.keyword_list_item, null);
        ItemHolder itemHolder = new ItemHolder(view);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {

        holder.keywordTxt.setText(getKeywords().get(position));

        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(150), rnd.nextInt(150), rnd.nextInt(150));
        holder.keywordCardView.setBackgroundColor(color);
    }

    @Override
    public int getItemCount() {
        return getKeywords().size();
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
        this.notifyDataSetChanged();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {

        TextView keywordTxt;
        CardView keywordCardView;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);

            keywordCardView = itemView.findViewById(R.id.keywordCardView);
            keywordTxt = itemView.findViewById(R.id.keywordTxt);

        }
    }
}
