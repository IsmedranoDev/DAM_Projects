package com.sergiov.apirest.repository.impl;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sergiov.apirest.model.Categoria;
import com.sergiov.apirest.model.RequestCallBack;
import com.sergiov.apirest.repository.CategoriaRepository;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CategoriaRepositoryHttp implements CategoriaRepository {

    Context context;
    RequestCallBack callback;

    final String ruta="http://10.0.2.2:8080/categorias";

    public CategoriaRepositoryHttp(Context context,RequestCallBack callback) {
        this.context=context;
        this.callback=callback;
    }
    @Override
    public List<Categoria> obtenerCategorias() {
        RequestQueue queue = Volley.newRequestQueue(this.context);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, ruta,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        callback.onSuccess(response,"GET-CATEGORIAS");
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onError(error.toString());
            }
        });
        queue.add(stringRequest);

        return null;
    }

    @Override
    public Categoria obtenerCategoriaPorId(int id) {
        RequestQueue queue = Volley.newRequestQueue(this.context);
        String ruta2=ruta+"/"+id;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, ruta2,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        callback.onSuccess(response,"GET-CATEGORIA");
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onError(error.toString());
            }
        });
        queue.add(stringRequest);

        return null;
    }

    @Override
    public boolean insertarCategoria(Categoria c) {
        RequestQueue queue = Volley.newRequestQueue(this.context);
        try {
            c.setId(null);
            Gson gson = new Gson();
            JSONObject jsonCategoria = new JSONObject(gson.toJson(c));
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                    Request.Method.POST,
                    ruta,
                    jsonCategoria,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            callback.onSuccess(response.toString(),"INSERT-CATEGORIA");
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            System.out.println(error.toString());
                        }
                    }
            );

            queue.add(jsonObjectRequest);

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        return false;
    }
}
