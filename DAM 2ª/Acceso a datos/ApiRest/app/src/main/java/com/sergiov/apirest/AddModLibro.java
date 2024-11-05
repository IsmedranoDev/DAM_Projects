package com.sergiov.apirest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sergiov.apirest.model.Categoria;
import com.sergiov.apirest.model.Libro;
import com.sergiov.apirest.model.RequestCallBack;
import com.sergiov.apirest.repository.CategoriaRepository;
import com.sergiov.apirest.repository.LibroRepository;
import com.sergiov.apirest.repository.impl.CategoriaRepositoryHttp;
import com.sergiov.apirest.repository.impl.LibroRepositoryHttp;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AddModLibro extends AppCompatActivity implements RequestCallBack {
    private EditText editTextTitulo;
    private EditText editTextAutor;
    private EditText editTextFecha;
    private Spinner spinnerCategoria;
    private Button buttonInsertar;

    List<Categoria> listaCategorias=new ArrayList<>();

    CategoriaRepository categoriaRepository;
    
    LibroRepository libroRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_mod_libro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initComponents();
        pedirListaCategorias();





    }
    private void pedirListaCategorias(){
        categoriaRepository = new CategoriaRepositoryHttp(getApplicationContext(),this);
        categoriaRepository.obtenerCategorias();

    }
    private void actualizarListaCategorias(){
        ArrayAdapter<Categoria> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listaCategorias);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategoria.setAdapter(adapter);
    }

    private void initComponents(){
        editTextTitulo = findViewById(R.id.editTextTitulo);
        editTextAutor = findViewById(R.id.editTextAutor);
        editTextFecha = findViewById(R.id.editTextFecha);
        spinnerCategoria = findViewById(R.id.spinnerCategoria);
        buttonInsertar = findViewById(R.id.buttonInsertar);
        buttonInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertarLibro();
            }
        });



    }
    private void insertarLibro() {
        String titulo = editTextTitulo.getText().toString();
        String autor = editTextAutor.getText().toString();
        String fecha = editTextFecha.getText().toString();
        Categoria categoria = (Categoria) spinnerCategoria.getSelectedItem();
        Libro nuevoLibro = new Libro(null, titulo, autor, fecha, categoria);
        System.out.println("nuevoLibro = " + nuevoLibro);

        editTextAutor.setEnabled(false);
        editTextAutor.setEnabled(false);
        editTextFecha.setEnabled(false);
        spinnerCategoria.setEnabled(false);
        buttonInsertar.setEnabled(false);
        libroRepository=new LibroRepositoryHttp(getApplicationContext(),this);
        
        libroRepository.insertarLibro(nuevoLibro);





    }

    @Override
    public void onSuccess(String response, String tipo) {
        Gson gson = new Gson();
        switch (tipo){
            case "GET-CATEGORIAS":
                Type categoriaListType = new TypeToken<List<Categoria>>(){}.getType();
                List<Categoria> categorias = gson.fromJson(response, categoriaListType);
                listaCategorias.clear();
                listaCategorias.addAll(categorias);
                actualizarListaCategorias();
                break;
            case "INSERT-LIBRO":
                Toast.makeText(this, "Insertado con exito", Toast.LENGTH_SHORT).show();

                Intent i = new Intent();
                setResult(RESULT_OK,i);
                finish();
                break;
        }

    }

    @Override
    public void onError(String error) {

    }
}