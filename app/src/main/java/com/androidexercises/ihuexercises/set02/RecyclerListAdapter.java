package com.androidexercises.ihuexercises.set02;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.androidexercises.ihuexercises.R;

import java.util.List;

public class RecyclerListAdapter extends RecyclerView.Adapter<RecyclerListAdapter.ListItemHolder> {
    private List<String> data;

    public RecyclerListAdapter(List<String> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ListItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout layoutHolder = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.holder_recycler_elelemts, parent, false);
        ListItemHolder holder = new ListItemHolder(layoutHolder);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListItemHolder holder, int position) {
        holder.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ListItemHolder extends RecyclerView.ViewHolder {
        private LinearLayout cocoNamesHolder;

        public ListItemHolder(LinearLayout cocoNamesHolder) {
            super(cocoNamesHolder);
            this.cocoNamesHolder = cocoNamesHolder;
        }

        public void setText(String text){
            ((TextView)cocoNamesHolder.getChildAt(0)).setText(text);
        }
    }
}
