package com.punjab.sports;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.punjab.sports.Activitys.Register;

public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.intro).setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                String url = "https://pbsports.in/Introduction.html";
              /*
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

*/

                Intent intent = new Intent(getActivity(), WebActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("url", url);
                bundle.putString("title", "Introduction");
                intent.putExtras(bundle);
                startActivity(intent);




            }
        });


        view.findViewById(R.id.sports).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://pbsports.in/SportsInfrastructure.html";

                Intent intent = new Intent(getActivity(), WebActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("url", url);
                bundle.putString("title", "Sports Infrastructure");
                intent.putExtras(bundle);
                startActivity(intent);




            }
        });


        view.findViewById(R.id.legends).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://pbsports.in/LegendsInfo.html";
                Intent intent = new Intent(getActivity(), WebActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("url", url);
                bundle.putString("title", "Legends");
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });


        view.findViewById(R.id.register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

/*
                 NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
*/

                Intent intent = new Intent(getActivity(), Register.class);
                startActivity(intent);
            }
        });

        view.findViewById(R.id.Login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String url = "https://pbsports.in/Login";
                Intent intent = new Intent(getActivity(), WebActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("url", url);
                bundle.putString("title", "Login");
                intent.putExtras(bundle);
                startActivity(intent);


            }
        });



        view.findViewById(R.id.olympian).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://pbsports.in/AsianGamesInfo.html";
                Intent intent = new Intent(getActivity(), WebActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("url", url);
                bundle.putString("title", "Olympian & Asian Medalist");
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });

        view.findViewById(R.id.dso).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://pbsports.in/DSOList.html";
                Intent intent = new Intent(getActivity(), WebActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("url", url);
                bundle.putString("title", "DSO & Centre List");
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });

        view.findViewById(R.id.coach).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://pbsports.in/CoachingCenter.html";
                Intent intent = new Intent(getActivity(), WebActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("url", url);
                bundle.putString("title", "Coach & Coaching Center");
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });


        view.findViewById(R.id.awards).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://pbsports.in/Awards.html";
                Intent intent = new Intent(getActivity(), WebActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("url", url);
                bundle.putString("title", "Awards & Incentives");
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });

        view.findViewById(R.id.policy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://pbsports.in/SportsPolicy.html";
                Intent intent = new Intent(getActivity(), WebActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("url", url);
                bundle.putString("title", "Sports & Gradation Policy");
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });

        view.findViewById(R.id.pis).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://pbsports.in/PIS.html";
                Intent intent = new Intent(getActivity(), WebActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("url", url);
                bundle.putString("title", "PIS");
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });

        view.findViewById(R.id.university).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://pbsports.in/University.html";
                Intent intent = new Intent(getActivity(), WebActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("url", url);
                bundle.putString("title", "Sports University");
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });


    }


}