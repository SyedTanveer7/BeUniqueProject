package com.example.bio.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bio.modals.BasicInfoData;
import com.example.splashactivity.R;

import java.util.List;

public class PersonalInfoAdapter extends RecyclerView.Adapter<PersonalInfoAdapter.ItemRow> {

    private Context context;
    private List<BasicInfoData> basicInfoDataList;

    public PersonalInfoAdapter(Context context, List<BasicInfoData> basicInfoDataList) {
        this.context = context;
        this.basicInfoDataList = basicInfoDataList;
    }

    @NonNull
    @Override
    public ItemRow onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.personal_info_item_row, parent, false);

        return new ItemRow(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemRow holder, int position) {

        holder.txtName.setText(basicInfoDataList.get(position).getKey().getName());
        holder.txtValue.setText(basicInfoDataList.get(position).getValue());

    }

    @Override
    public int getItemCount() {
        return basicInfoDataList.size();
    }

    public class ItemRow extends RecyclerView.ViewHolder {

        public TextView txtName, txtValue;

        public ItemRow(@NonNull View itemView) {
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.textView8);
            txtValue = (TextView) itemView.findViewById(R.id.textView9);
        }
    }

}
