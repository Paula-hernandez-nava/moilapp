package com.oitic.aplicacionM;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityWeb extends AppCompatActivity {

    WebView wv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        wv1 = (WebView)findViewById(R.id.wv1);

        String URL = getIntent().getStringExtra("sitio web");
       // wv1.setWebViewClient(new WebViewClient());
        wv1.setWebChromeClient(new WebChromeClient());
        wv1.getSettings().setJavaScriptEnabled(true);
        wv1.loadUrl("http://" + URL);
    }

    public void Cerrar(View view) {
        finish();
    }
}

