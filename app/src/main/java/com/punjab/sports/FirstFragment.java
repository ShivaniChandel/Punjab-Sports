package com.punjab.sports;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.install.model.AppUpdateType;
import com.google.android.play.core.install.model.InstallStatus;
import com.google.android.play.core.install.model.UpdateAvailability;
import com.google.android.play.core.tasks.OnSuccessListener;
import com.google.android.play.core.tasks.Task;
import com.punjab.sports.BaseClass.BaseFragment;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;

public class FirstFragment extends BaseFragment implements BaseFragment.OnDoubleOptionAlertClickListener {

   /* @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment

        UpdateApp();

        return inflater.inflate(R.layout.fragment_first, container, false);
    }*/


    @Override
    protected View initUI(LayoutInflater inflater, ViewGroup container) {

        View view = inflater.inflate(R.layout.fragment_first, container, false);


      //  UpdateApp();

        return view;
    }





    public void UpdateApp() {
        AppUpdateManager appUpdateManager = AppUpdateManagerFactory.create(getActivity());
        Task<AppUpdateInfo> appUpdateInfoTask = appUpdateManager.getAppUpdateInfo();
        // Checks that the platform will allow the specified type of update.
        appUpdateInfoTask.addOnSuccessListener(result -> {
            Log.i("TAG", "======UPDATE=====" + result.availableVersionCode());
            Log.i("TAG", "======now=====" + result.isUpdateTypeAllowed(AppUpdateType.IMMEDIATE));
            if (result.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE
                    && result.isUpdateTypeAllowed(AppUpdateType.IMMEDIATE)) {
                Log.i("TAG", "======INSIDE=====");
//                requestUpdate(result);
                android.view.ContextThemeWrapper ctw = new android.view.ContextThemeWrapper(getActivity(), R.style.AppTheme_NoActionBar);
                final android.app.AlertDialog.Builder alertDialogBuilder = new android.app.AlertDialog.Builder(ctw);
                alertDialogBuilder.setTitle("Khedo Punjab");
                alertDialogBuilder.setCancelable(false);
                alertDialogBuilder.setIcon(R.drawable.icons_google_play);
                alertDialogBuilder.setMessage(getString(R.string.update));
                alertDialogBuilder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        try {
                            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + getActivity().getPackageName())));
                        } catch (ActivityNotFoundException e) {
                            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + getActivity().getPackageName())));
                        }
                    }
                });
               /* alertDialogBuilder.setNegativeButton("No Thanks", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Log.i("TAG", "======UPDATE=====");
                    }
                });*/
                alertDialogBuilder.show();

            } else {
                Log.i("TAG", "======REGISTER=====");
            }
        });
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

                Fragment fragment = new First2Fragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_host_fragment, fragment, fragment.getClass().getSimpleName()).addToBackStack(null).commit();


  /*              CustomDialog alert = new CustomDialog(getContext(), getActivity(), true);
                alert.show( "Khedo Punjab");
*//*
                Intent intent = new Intent(getActivity(), RegisterStep2.class);
                startActivity(intent);*/
                //Show dialog option
                //PIS / Sports department

            }
        });

        view.findViewById(R.id.Login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //String url = "https://pbsports.in/Login";
                String url = "https://pbsports.in/LoginOptions.html";
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
                String url = "https://pbsports.in/Main/DSOMain";
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
                String url = "https://pbsports.in/Main/CenterMain";
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
                bundle.putString("title", "Introduction");
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
                bundle.putString("title", "Sports University, Patiala");
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });


    }


    @Override
    public void onDoubleOptionAlertOkClick(int id) {

    }

    @Override
    public void onDoubleOptionAlertCancelClick(int id) {

    }
}