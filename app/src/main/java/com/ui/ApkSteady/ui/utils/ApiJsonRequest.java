package com.ui.ApkSteady.ui.utils;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;

public class ApiJsonRequest<T> extends Request<T> {
    private Class<T> clazz;
    private Response.Listener<T> mListener;
    private Gson gson;
    private int position;

    public ApiJsonRequest(String url, Response.ErrorListener errorListener,
                          Response.Listener<T> listener, Class<T> clazz) {
        super(Method.GET, url, errorListener);
        this.mListener = listener;
        this.clazz = clazz;
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        String json;
        try {
            json = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
        } catch (UnsupportedEncodingException e) {
            json = new String(response.data);
        }
        T obj;
        try {
            if (gson == null) {
                gson = new Gson();
            }
            obj = gson.fromJson(json, clazz);
            return Response.success(obj, HttpHeaderParser.parseCacheHeaders(response));
        } catch (Exception e) {
            return Response.error(new ParseError());
        }

    }

    @Override
    protected void deliverResponse(T response) {
        mListener.onResponse(response);
    }
}
