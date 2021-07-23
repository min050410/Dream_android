package com.example.name;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebViewClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {





    private WebView webView;
    private String Url = "https://bssm.kro.kr/bssm/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(Url);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebViewClient(new WebViewClientClass());

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()){
            webView.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    private class WebViewClientClass extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap farvicon){
            super.onPageStarted(view, url, farvicon);

            if (url.contains("?page=call")) {
                webView.loadUrl(Url);
                Intent tt = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "01041091872"));
                startActivity(tt);
            }

        }
    }

}




