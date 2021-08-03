package com.punjab.sports.AdapterClass;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.punjab.sports.ModelClasses.SportsDistrict;
import com.punjab.sports.R;

import java.util.List;

public class SportsDistrictAdapter extends ArrayAdapter<SportsDistrict> {
    List<SportsDistrict> sportsDistrict;
    public SportsDistrictAdapter(Context context,
                                 List<SportsDistrict> algorithmList) {
        super(context, 0, algorithmList);

        sportsDistrict=algorithmList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable
            View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable
            View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView,
                          ViewGroup parent) {
        // It is used to set our custom view.
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom, parent, false);
        }

        TextView textViewName = convertView.findViewById(R.id.sports);
        Log.i("TAG", "======positionADADA==g===" + position);

        // It is used the name to the TextView when the
        // current item is not null.
        try {

            if (sportsDistrict.get(position).getDistrictName().length()>0) {
                textViewName.setText(sportsDistrict.get(position).getDistrictName());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return convertView;
    }
}

