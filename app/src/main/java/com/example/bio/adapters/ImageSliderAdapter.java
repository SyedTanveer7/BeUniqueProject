package com.example.bio.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.bio.modals.SliderPhotoData;
import com.example.splashactivity.R;
import com.smarteist.autoimageslider.SliderViewAdapter;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ImageSliderAdapter extends
        SliderViewAdapter<ImageSliderAdapter.SliderAdapterVH> {


    private Context context;
    private List<SliderPhotoData> photos;

    public ImageSliderAdapter(List<SliderPhotoData> photos, Context context) {
        this.photos = photos;
        this.context = context;
    }


    @Override
    public ImageSliderAdapter.SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_custom_image, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, int position) {


        if (photos.get(position).getFilename() != null && !photos.get(position).getFilename().isEmpty()) {
            Picasso.get().load(photos.get(position).getFilename()).into(viewHolder.image);
        }


    }

    @Override
    public int getCount() {
        return photos.size();
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {
        ImageView image;


        public SliderAdapterVH(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.iv_slider);
        }
    }


}
