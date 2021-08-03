package com.punjab.sports.AdapterClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.punjab.sports.ModelClasses.CenterAccToSport;
import com.punjab.sports.ModelClasses.SportsAppliedFor;
import com.punjab.sports.R;

import java.util.List;

public class CenterAccToSportAdapter extends ArrayAdapter<CenterAccToSport> {

    public CenterAccToSportAdapter(Context context,
                                   List<CenterAccToSport> algorithmList)
    {
        super(context, 0, algorithmList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable
            View convertView, @NonNull ViewGroup parent)
    {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable
            View convertView, @NonNull ViewGroup parent)
    {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView,
                          ViewGroup parent)
    {
        // It is used to set our custom view.
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom, parent, false);
        }

        TextView textViewName = convertView.findViewById(R.id.sports);
        CenterAccToSport currentItem = getItem(position);

        // It is used the name to the TextView when the
        // current item is not null.
        if (currentItem != null) {
            if (currentItem.getTcName().equalsIgnoreCase("--Select--")){
                textViewName.setText(currentItem.getTcName());
            }else {
                textViewName.setText(currentItem.getTcName()+","+currentItem.getLocation());
            }

        }
        return convertView;
    }
}

