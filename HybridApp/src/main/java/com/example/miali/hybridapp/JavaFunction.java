package com.example.miali.hybridapp;

import cn.pedant.SafeWebViewBridge.JsCallback;

/**
 * Java方法，供JS调用
 * Created by Lijia on 2015-12-30.
 */
public class JavaFunction {

    public static JsCallback jsCallback;

    public static String getToken(){
        return "abcedfg";
    }
}
