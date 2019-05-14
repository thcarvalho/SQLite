package com.banco.terasgahd.banco;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.banco.terasgahd.banco.SQL.UsuariosDAO;
import com.banco.terasgahd.banco.model.Usuarios;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText txtlogin;
    private EditText txtemail;
    private EditText txtsenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtlogin = findViewById(R.id.loginId);
        txtemail = findViewById(R.id.emailId);
        txtsenha = findViewById(R.id.senhaId);

    }
    public void salvar(View view){

        UsuariosDAO usuariosDAO = new UsuariosDAO(getApplicationContext());

        String login = txtlogin.getText().toString();
        String email = txtemail.getText().toString();
        String senha = txtsenha.getText().toString();
        if (!login.isEmpty()){
            Usuarios usuarios = new Usuarios();
            usuarios.setUsuario(login);
            usuarios.setEmail(email);
            usuarios.setSenha(senha);
            usuariosDAO.salvar(usuarios);
        }
        txtlogin.setText("");
        txtemail.setText("");
        txtsenha.setText("");

        Toast.makeText(getApplicationContext(),"Novo usuario cadastrado!",Toast.LENGTH_SHORT).show();
    }
    public void visualizar(View view){
        Intent intent = new Intent(getApplicationContext(),ListaActivity.class);
        startActivity(intent);
    }
}
