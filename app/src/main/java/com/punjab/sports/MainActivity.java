package com.punjab.sports;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
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
import com.punjab.sports.Fragments.WebviewFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

 public class MainActivity extends AppCompatActivity {

     private AppUpdateManager appUpdateManager;
     private static final int IMMEDIATE_APP_UPDATE_REQ_CODE = 124;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
         Log.i("TAG", "======RUN OR NOT=====");
      /*  FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

         //Toast.makeText(getApplicationContext(), "=========Success============", Toast.LENGTH_LONG).show();

         appUpdateManager = AppUpdateManagerFactory.create(getApplicationContext());
         checkUpdate();
    }
     private void checkUpdate() {

         Task<AppUpdateInfo> appUpdateInfoTask = appUpdateManager.getAppUpdateInfo();

         appUpdateInfoTask.addOnSuccessListener(appUpdateInfo -> {
             if (appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE
                     && appUpdateInfo.isUpdateTypeAllowed(AppUpdateType.IMMEDIATE)) {
                 startUpdateFlow(appUpdateInfo);
             } else if  (appUpdateInfo.updateAvailability() == UpdateAvailability.DEVELOPER_TRIGGERED_UPDATE_IN_PROGRESS){
                 startUpdateFlow(appUpdateInfo);
             }
         });
     }

     private void startUpdateFlow(AppUpdateInfo appUpdateInfo) {
         try {
             appUpdateManager.startUpdateFlowForResult(appUpdateInfo, AppUpdateType.IMMEDIATE, this, MainActivity.IMMEDIATE_APP_UPDATE_REQ_CODE);
         } catch (IntentSender.SendIntentException e) {
             e.printStackTrace();
         }
     }

     @Override
     public void onActivityResult(int requestCode, int resultCode, Intent data) {
         super.onActivityResult(requestCode, resultCode, data);
         if (requestCode == IMMEDIATE_APP_UPDATE_REQ_CODE) {
             if (resultCode == RESULT_CANCELED) {
                // Toast.makeText(getApplicationContext(), "Update canceled by user! Result Code: " + resultCode, Toast.LENGTH_LONG).show();
             } else if (resultCode == RESULT_OK) {
                 Toast.makeText(getApplicationContext(), "Update success", Toast.LENGTH_LONG).show();
             } else {
                // Toast.makeText(getApplicationContext(), "Update Failed! Result Code: " + resultCode, Toast.LENGTH_LONG).show();
                 checkUpdate();
             }
         }
     }


    @Override
    public void onBackPressed() {

        Fragment fragment = null;
            if(fragment instanceof WebviewFragment) {

                super.onBackPressed();
            }else if (fragment instanceof SecondFragment){
                super.onBackPressed();
            }else {
                super.onBackPressed();
            }

    }


}