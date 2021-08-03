package com.punjab.sports;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

public class WebActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        ImageView back_img = findViewById(R.id.back_img);
        TextView title_txt = findViewById(R.id.title_txt);
        WebView webView = findViewById(R.id.webview);

        Intent intent = getIntent();

        String url = intent.getStringExtra("url");
        String title = intent.getStringExtra("title");
        title_txt.setText(title);
        Log.i("TAG", "======h_url=====" + url);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
        WebViewClientImpl webViewClient = new WebViewClientImpl(this);
        webView.setWebViewClient(webViewClient);



        back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();

            }
        });

    }
}


class WebViewClientImpl extends WebViewClient {

    private Activity activity = null;

    public WebViewClientImpl(Activity activity) {
        this.activity = activity;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView webView, String url) {
       // if (url.indexOf("journaldev.com") > -1) return false;
        Log.i("TAG", "======urlurl=====" + url);
        Intent intent = new Intent(activity, WebActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        bundle.putString("title", "");
        intent.putExtras(bundle);
        activity.startActivity(intent);


        return true;
    }
}