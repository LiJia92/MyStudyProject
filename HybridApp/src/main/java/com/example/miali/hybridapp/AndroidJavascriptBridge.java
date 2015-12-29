package com.example.miali.hybridapp;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

/**
 * Created by Lijia on 2015-12-29.
 */
public class AndroidJavascriptBridge {
    private Context mContext;
    private WebView mWebView;

    public AndroidJavascriptBridge(Context mContext, WebView mWebView) {
        this.mContext = mContext;
        this.mWebView = mWebView;
    }

    @JavascriptInterface
    public void clickOnAndroid() {
        Toast.makeText(mContext, "Hello Hybrid.", Toast.LENGTH_SHORT).show();
        mWebView.post(new Runnable() {
            @Override
            public void run() {
                mWebView.loadUrl("javascript:hello()");
            }
        });
    }

    @JavascriptInterface
    public void clickOnAndroid2() {
        Toast.makeText(mContext, "Hello Hybrid.", Toast.LENGTH_SHORT).show();
        mWebView.post(new Runnable() {
            @Override
            public void run() {
                mWebView.loadUrl("javascript:hello2()");
            }
        });
    }
}
