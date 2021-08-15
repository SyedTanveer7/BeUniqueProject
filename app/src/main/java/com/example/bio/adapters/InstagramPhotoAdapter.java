package com.example.bio.adapters;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bio.modals.SliderPhotoData;
import com.example.splashactivity.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class InstagramPhotoAdapter extends RecyclerView.Adapter<InstagramPhotoAdapter.ItemRow> {

    private Context context;
    private List<SliderPhotoData> photos;

    public InstagramPhotoAdapter(Context context, List<SliderPhotoData> photos) {
        this.context = context;
        this.photos = photos;
    }

    @NonNull
    @Override
    public ItemRow onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View inflate = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.profile_instagram_row_item, parent, false);

        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) inflate.getLayoutParams();
        layoutParams.width = (int) (getScreenWidth(context) * 0.27);
        inflate.setLayoutParams(layoutParams);
        return new InstagramPhotoAdapter.ItemRow(inflate);
    }
    public static int getScreenWidth(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemRow holder, int position) {
        if (photos.get(position).getFilename() != null && !photos.get(position).getFilename().isEmpty()) {
            Picasso.get().load(photos.get(position).getFilename()).into(holder.image);
        }
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    public class ItemRow extends RecyclerView.ViewHolder {

        public ImageView image;

        public ItemRow(@NonNull View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.iv_brand);

        }
    }

}
