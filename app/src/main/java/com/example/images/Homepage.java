package com.example.images;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Homepage extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Image> images;
    private static String JSON_URL="https://picsum.photos/v2/list?page=2&limit=20";
    Adapter  adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        recyclerView = findViewById(R.id.imagelist);
        images = new ArrayList<>();
        extractImages();



    }
       private void extractImages(){
            RequestQueue queue= Volley.newRequestQueue(this);
            JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, JSON_URL, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject imageObject = response.getJSONObject(i);
                            Image image = new Image();
                            image.setId(imageObject.getString("id").toString());
                            image.setAuthor(imageObject.getString("author").toString());
                            image.setCoverImage(imageObject.getString("url"));
                            image.setDownUrl(imageObject.getString("download_url"));
                            images.add(image);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    recyclerView.setLayoutManager((new LinearLayoutManager(getApplicationContext())));
                    adapter =new Adapter(getApplicationContext(), images);
                    recyclerView.setAdapter(adapter);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    Log.d("tag","onErrorResponse: "+error.getMessage());
                }
       });

            queue.add(jsonArrayRequest);
        }

}