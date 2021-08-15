package com.example.bio.adapters;

import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.splashactivity.R;

public class InstagramPhotoAdapter extends RecyclerView.Adapter<InstagramPhotoAdapter.ItemRow>{


    @NonNull
    @Override
    public ItemRow onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemRow holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ItemRow extends RecyclerView.ViewHolder {

        public ImageView image;

        public ItemRow(@NonNull View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.iv_brand);

        }
    }

}
