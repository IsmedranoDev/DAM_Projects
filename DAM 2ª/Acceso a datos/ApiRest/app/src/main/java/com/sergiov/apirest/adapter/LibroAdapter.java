package com.sergiov.apirest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.sergiov.apirest.model.Libro;

import java.util.List;

public class LibroAdapter extends ArrayAdapter<Libro> {


    public LibroAdapter(@NonNull Context context, List<Libro> libros) {
        super(context, 0,libros);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Libro libro = getItem(position);

        if (convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_2,parent,false);
        }

        TextView t1 = convertView.findViewById(android.R.id.text1);
        TextView t2 = convertView.findViewById(android.R.id.text2);

        t1.setText(libro.getTitulo());
        t2.setText(libro.getAutor());


        return convertView;
    }
}
