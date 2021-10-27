package com.punjab.sports;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.punjab.sports.Activitys.PISRegister;
import com.punjab.sports.Activitys.Register;

public class First2Fragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first2, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.pisregistration).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PISRegister.class);
                intent.putExtra("register",false);
                intent.putExtra("value","PIS Registration");
                startActivity(intent);

            }
        });

        view.findViewById(R.id.sportregister).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Register.class);
                intent.putExtra("register",true);
                intent.putExtra("value","Sports Department Registration");
                startActivity(intent);

            }
        });



    }
}