package com.punjab.sports.Activitys;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

import com.punjab.sports.MainActivity;
import com.punjab.sports.R;
import com.punjab.sports.WebActivity;

public class SuccessMessage extends AppCompatActivity {


    TextView login_btn,home_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_message);

        login_btn = findViewById(R.id.login_btn);
        home_btn = findViewById(R.id.home_btn);


        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //String url = "https://pbsports.in/Login";
                String url = "https://pbsports.in/LoginOptions.html";
                Intent intent = new Intent(SuccessMessage.this, WebActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("url", url);
                bundle.putString("title", "Login");
                intent.putExtras(bundle);
                startActivity(intent);



            }
        });

        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            /*    Intent i =new Intent(SuccessMessage.this, MainActivity.class);
                startActivity(i);
*/
                Intent intent = new Intent(SuccessMessage.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            }
        });
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Intent intent = new Intent(SuccessMessage.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);


    }
}