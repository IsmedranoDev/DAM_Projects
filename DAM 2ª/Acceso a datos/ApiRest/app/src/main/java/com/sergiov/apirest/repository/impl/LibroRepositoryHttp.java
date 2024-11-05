package com.sergiov.apirest.repository.impl;

import android.content.Context;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.sergiov.apirest.model.Libro;
import com.sergiov.apirest.model.RequestCallBack;
import com.sergiov.apirest.repository.LibroRepository;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.List;

public class LibroRepositoryHttp implements LibroRepository {

    Context context;
    RequestCallBack callback;
    final String ruta="http://10.0.2.2:8080/libros";

    public LibroRepositoryHttp(Context context, RequestCallBack callback) {
        this.context = context;
        this.callback = callback;
    }


    @Override
    public List<Libro> obtenerLibros() {
        RequestQueue queue = Volley.newRequestQueue(this.context);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, ruta,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        callback.onSuccess(response,"GET-LIBROS");
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onError(error.toString());
            }
        }){
            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                String parsed;
                try {
                    parsed = new String(response.data, "UTF-8"); // Asegúrate de usar UTF-8
                } catch (UnsupportedEncodingException e) {
                    parsed = new String(response.data);
                }
                return Response.success(parsed, HttpHeaderParser.parseCacheHeaders(response));
            }
        };

        queue.add(stringRequest);

        return null;
    }

    @Override
    public Libro obtenerLibroPorId(int id) {
        RequestQueue queue = Volley.newRequestQueue(this.context);
        String ruta2=ruta+"/"+id;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, ruta2,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        callback.onSuccess(response,"GET-LIBRO");
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
    public boolean insertarLibro(Libro l) {
        RequestQueue queue = Volley.newRequestQueue(this.context);
        try {
            l.setId(null);
            Gson gson = new Gson();
            JSONObject jsonLibro = new JSONObject(gson.toJson(l));
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                    Request.Method.POST,
                    ruta,
                    jsonLibro,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            callback.onSuccess(response.toString(),"INSERT-LIBRO");
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // Manejar el error
                            callback.onError(error.toString());
                        }
                    }
            );

            // Añadir la solicitud a la cola
            queue.add(jsonObjectRequest);

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

    @Override
    public boolean actualizarLibro(Libro l) {
        RequestQueue queue = Volley.newRequestQueue(this.context);
        Gson gson = new Gson();
        JSONObject jsonLibro = null;
        try {
            jsonLibro = new JSONObject(gson.toJson(l));
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                    Request.Method.PUT,
                    ruta+"/"+l.getId(),
                    jsonLibro,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            // Manejar la respuesta
                            callback.onSuccess(response.toString(),"UPDATE-LIBRO");
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            callback.onError(error.toString());
                            // Manejar el error
                        }
                    }
            );

            // Añadir la solicitud a la cola
            queue.add(jsonObjectRequest);

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public boolean eliminarLibro(int id) {
        RequestQueue queue = Volley.newRequestQueue(this.context);

        StringRequest stringRequest = new StringRequest(
                Request.Method.DELETE,
                ruta+"/"+id,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        callback.onSuccess(response,"DELETE-LIBRO");
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Manejar el error
                    }
                }
        );

        // Añadir la solicitud a la cola
        queue.add(stringRequest);

        return false;
    }
}
