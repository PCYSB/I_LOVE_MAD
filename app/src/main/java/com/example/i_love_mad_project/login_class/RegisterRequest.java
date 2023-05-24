package com.example.i_love_mad_project.login_class;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends JsonObjectRequest {

    final static private String URL = "http://39.119.82.229:8080/api/signup";

    public RegisterRequest(JSONObject params, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) throws JSONException {
        super(Method.POST, URL, params, listener, errorListener);
    }

    @Override
    public Map<String, String> getHeaders() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("Content-Type", "application/json");
        params.put("Accept-Charset", "utf-8");
        params.put("Accept-Encoding", "gzip, deflate, br");
        return params;
    }
}
