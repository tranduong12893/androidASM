package com.example.asm_android_movie.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asm_android_movie.R;
import com.example.asm_android_movie.activity.MainActivity;
import com.example.asm_android_movie.model.Section;

import java.util.List;

public class SectionAdapter extends RecyclerView.Adapter{
    private Activity activity;
    private List<Section> listSection;




    public SectionAdapter(MainActivity activity, List<Section> listSection) {

    }

    @SuppressLint("NotifyDataSetChanged")
    public void reloadSection(List<Section> list){
        listSection = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = activity.getLayoutInflater().inflate(R.layout.item_section, parent,false);
        SectionHolder holder = new SectionHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        SectionHolder vh = (SectionHolder) holder;
        Section model = listSection.get(position);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false);
        MovieAdapter adapter = new MovieAdapter(activity, model.getListMovies());
        adapter.setSection(model.getTitle());
        vh.rvSection.setLayoutManager(layoutManager);
        vh.rvSection.setHasFixedSize(true);
        vh.rvSection.setAdapter(adapter);

        vh.tvTitle.setText(model.getTitle());
    }

    @Override
    public int getItemCount() {
        return listSection.size();
    }

    public static class SectionHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        RecyclerView rvSection;
        public SectionHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            rvSection = itemView.findViewById(R.id.rvSection);
        }
    }
    public SectionAdapter() {
        this.activity = activity;
        this.listSection = listSection;
    }
}
