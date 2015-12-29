package com.example.miali.hybridapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Created by Lijia on 2015-12-25.
 */
public class WebViewActivity extends Activity {

    private WebView webView;
    private Context mContext;
    private Handler mHandler = new Handler();

    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        // 创建WebView对象
        webView = new WebView(this);
        // 切换到内容视图
        setContentView(webView);
        // 获取WebView配置
        WebSettings ws = webView.getSettings();
        // 启用JavaScript
        ws.setJavaScriptEnabled(true);
        // 载入assets目录下的一个页面
        webView.loadUrl("file:///android_asset/hello.html");
        // 添加交互接口
        webView.addJavascriptInterface(new AndroidJavascriptBridge(mContext, webView), "demo");
//        webView.addJavascriptInterface(new Object() {
//            @JavascriptInterface
//            public void clickOnAndroid() {
//                Toast.makeText(mContext, "Hello Hybrid.", Toast.LENGTH_SHORT).show();
//                mHandler.post(new Runnable() {
//                    public void run() {
//                        webView.loadUrl("javascript:hello()");
//                    }
//                });
//            }
//        }, "demo");

//        webView.setWebViewClient(new WebViewClient() {
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                Toast.makeText(mContext, url, Toast.LENGTH_SHORT).show();
//                return super.shouldOverrideUrlLoading(view, url);
//            }
//        });
//
//        webView.setWebChromeClient(new WebChromeClient() {
//            public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
//                Toast.makeText(mContext, url, Toast.LENGTH_SHORT).show();
//                result.confirm("");
//                return true;
//            }
//        });
    }
}
