package com.example.keywords;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

class KeywordsRepositoryImp implements KeywordsRepository {

    private static String KEYWORDS_API = "https://raw.githubusercontent.com/tikivn/android-home-test/v2/keywords.json";
    private RequestQueue requestQueue;
    private Listener listener;

    KeywordsRepositoryImp(Context context, Listener listener) {
        requestQueue = Volley.newRequestQueue(context);
        this.listener = listener;
    }

    @Override
    public void fetchKeywords() {
        requestQueue.add(createFetchKeywordsRequest(listener));
    }

    private JsonArrayRequest createFetchKeywordsRequest(final Listener listener) {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(KEYWORDS_API, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (!response.equals("[]") && response != null) {
                    List<String> keywords = new ArrayList<>();
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            keywords.add(response.getString(i));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    listener.onComplete(keywords);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        return jsonArrayRequest;
    }

    interface Listener {
        void onComplete(List<String> keywords);
    }
}
