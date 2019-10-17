package com.smartlocation.spinnerdesign;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomAdapter extends ArrayAdapter {
    public CustomAdapter(@NonNull Context context, ArrayList<CustomItem> customList) {
        super(context, 0, customList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_spinner_layout, parent, false);
        }
        CustomItem item = (CustomItem) getItem(position);
        ImageView spinnerIV = convertView.findViewById(R.id.ivSpinnerLayout);
        TextView spinnerTV = convertView.findViewById(R.id.tvSpinnerLayout);
        if (item != null) {
            spinnerIV.setImageResource(item.getSpinnerItemImage());
            spinnerTV.setText(item.getSpinnerItemName());
        }
        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_dropdown_layout, parent, false);
        }
        CustomItem item = (CustomItem) getItem(position);
        ImageView dropdownIV = convertView.findViewById(R.id.ivDropDownLayout);
        TextView dropdownTV = convertView.findViewById(R.id.tvDropDownLayout);
        if (item != null) {
            dropdownIV.setImageResource(item.getSpinnerItemImage());
            dropdownTV.setText(item.getSpinnerItemName());
        }
        return convertView;

    }
}
