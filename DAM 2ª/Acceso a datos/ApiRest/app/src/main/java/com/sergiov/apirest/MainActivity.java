package com.sergiov.apirest;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sergiov.apirest.model.Categoria;
import com.sergiov.apirest.model.Libro;
import com.sergiov.apirest.adapter.LibroAdapter;
import com.sergiov.apirest.model.RequestCallBack;
import com.sergiov.apirest.repository.CategoriaRepository;
import com.sergiov.apirest.repository.LibroRepository;
import com.sergiov.apirest.repository.impl.LibroRepositoryHttp;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RequestCallBack {

    ListView lvlibros;
    Toolbar tblibros;
    List<Libro> listaLibros;
    LibroAdapter adapter;
    LibroRepository libroRepository;

    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initComponents();
        actualizarLista();


    }
    private void initComponents(){
        listaLibros = new ArrayList<>();
        lvlibros = findViewById(R.id.lvlibros);
        tblibros = findViewById(R.id.tblibros);
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);
        setSupportActionBar(tblibros);
        adapter = new LibroAdapter(this,listaLibros);
        lvlibros.setAdapter(adapter);
        swipeRefreshLayout.setOnRefreshListener(() -> {
            actualizarLista();
        });
        lvlibros.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                int idLibro = listaLibros.get(position).getId();
                libroRepository.eliminarLibro(idLibro);
                return false;
            }
        });
        lvlibros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), AddModLibro.class);
                i.putExtra("modificar",listaLibros.get(position).getId());
                startActivityForResult(i,1);
            }
        });

    }
    private void actualizarLista(){
        libroRepository = new LibroRepositoryHttp(getApplicationContext(),this);
        libroRepository.obtenerLibros();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menulibros,menu);

        return false;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId()==R.id.add){
            Intent i = new Intent(this, AddModLibro.class);
            startActivityForResult(i,1);
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==1&&resultCode==RESULT_OK){
            actualizarLista();
        }

    }

    @Override
    public void onSuccess(String response,String tipo) {
        switch (tipo){
            case "GET-LIBROS":
                Gson gson = new Gson();
                Type libroListType = new TypeToken<List<Libro>>(){}.getType();
                List<Libro> libros = gson.fromJson(response, libroListType);
                listaLibros.clear();
                listaLibros.addAll(libros);
                adapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false); // Detener la animación de refresco
                break;
            case "DELETE-LIBRO":
                actualizarLista();
                break;
        }




    }




    @Override
    public void onError(String error) {
        System.out.println(error);

    }
}