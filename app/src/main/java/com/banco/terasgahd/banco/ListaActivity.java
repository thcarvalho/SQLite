package com.banco.terasgahd.banco;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.banco.terasgahd.banco.SQL.SQL;
import com.banco.terasgahd.banco.SQL.UsuariosDAO;
import com.banco.terasgahd.banco.adapter.UsersAdapter;
import com.banco.terasgahd.banco.model.Usuarios;

import java.util.ArrayList;
import java.util.List;

public class ListaActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Usuarios> listaUsuarios = new ArrayList<>();
    private UsersAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        recyclerView = findViewById(R.id.recyclerUsersId);
        SQL db = new SQL(getApplicationContext());
    }


    public void carregarUsuarios(){
        UsuariosDAO usuariosDAO = new UsuariosDAO(getApplicationContext());
        listaUsuarios = usuariosDAO.visualizar();

        //Adapter
        userAdapter = new UsersAdapter(listaUsuarios);

        //Recycler
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(),LinearLayout.VERTICAL));
        recyclerView.setAdapter(userAdapter);

    }
    @Override
    protected void onStart() {
        carregarUsuarios();
        super.onStart();
    }

}
