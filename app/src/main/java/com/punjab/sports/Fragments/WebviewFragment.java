package com.punjab.sports.Fragments;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.punjab.sports.MainActivity;
import com.punjab.sports.R;


public class WebviewFragment extends Fragment {


    View view;
    WebView webView;
    ImageView back_img;
    TextView title_txt;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_webview, container, false);

        /*Intent intent = getActivity().getIntent();

       String h_url = intent.getStringExtra("url");
        Log.i("TAG", "======h_url=====" + h_url);
*/
        back_img = (ImageView) view.findViewById(R.id.back_img);
        title_txt = (TextView) view.findViewById(R.id.title_txt);
        webView = (WebView) view.findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://pbsports.in/Introduction.html");

        WebViewClientImpl webViewClient = new WebViewClientImpl(getActivity());
        webView.setWebViewClient(webViewClient);


        back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();

            }
        });

        return view;


    }



    /**
     * Could handle back press.
     * @return true if back press was handled
     */
    public boolean onBackPressed() {
        return false;
    }
}

class WebViewClientImpl extends WebViewClient {

    private Activity activity = null;

    public WebViewClientImpl(Activity activity) {
        this.activity = activity;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView webView, String url) {
        if(url.indexOf("journaldev.com") > -1 ) return false;

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        activity.startActivity(intent);
        return true;
    }


}