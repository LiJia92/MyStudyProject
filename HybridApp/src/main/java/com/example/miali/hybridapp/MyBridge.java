package com.example.miali.hybridapp;

import android.webkit.WebView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import cn.pedant.SafeWebViewBridge.JsCallback;

/**
 * JS、Java交互类
 * Created by Lijia on 2015-12-30.
 */
public class MyBridge {

    public static void init(WebView webView, JsCallback jsCallback) {
        JavaFunction.jsCallback = jsCallback; // 保存回调
        JavaFunction.jsCallback.setPermanent(true); // 设置可多次调用
    }

    public static void send(WebView webView, JSONObject jsonObject, JsCallback jsCallback) {
        try {
            String method = jsonObject.getString("cmd");
            String token = "";
            switch (method) {
                case "getToken":
                    token = JavaFunction.getToken();
                    Toast.makeText(webView.getContext(), token, Toast.LENGTH_SHORT).show();
            }
            jsCallback.apply(token);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (JsCallback.JsCallbackException e) {
            e.printStackTrace();
        }
    }

    public static void send(WebView webView, JSONObject jsonObject) {
        try {
            String method = jsonObject.getString("cmd");
            String token;
            switch (method) {
                case "getToken":
                    token = JavaFunction.getToken();
                    Toast.makeText(webView.getContext(), token, Toast.LENGTH_SHORT).show();
                    break;
            }
            JavaFunction.jsCallback.apply();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (JsCallback.JsCallbackException e) {
            e.printStackTrace();
        }
    }

    public static void send(WebView webView, JSONObject jsonObject, String str) {
        try {
            String method = jsonObject.getString("cmd");
            String token;
            switch (method) {
                case "getToken":
                    token = JavaFunction.getToken();
                    Toast.makeText(webView.getContext(), token, Toast.LENGTH_SHORT).show();
                    break;
            }
            webView.loadUrl(str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
