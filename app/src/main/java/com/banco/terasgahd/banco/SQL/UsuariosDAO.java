package com.banco.terasgahd.banco.SQL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.banco.terasgahd.banco.model.Usuarios;

import java.util.ArrayList;
import java.util.List;

public class UsuariosDAO implements IUsuariosDAO {

    private SQLiteDatabase escrever;
    private SQLiteDatabase ler;

    public UsuariosDAO(Context context) {
        SQL db = new SQL(context);
        escrever = db.getWritableDatabase();
        ler = db.getReadableDatabase();
    }

    @Override
    public boolean salvar(Usuarios usuarios) {
        ContentValues cv = new ContentValues();
        cv.put("login",usuarios.getUsuario());
        cv.put("email",usuarios.getEmail());
        cv.put("senha",usuarios.getSenha());

        try {
            escrever.insert(SQL.NOME_TABELA,null,cv);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<Usuarios> visualizar() {
        List<Usuarios> usuario = new ArrayList<>();

        String sql = "SELECT * FROM "+SQL.NOME_TABELA+";";
        Cursor c = ler.rawQuery(sql,null);
        while (c.moveToNext()){
            Usuarios usuarios = new Usuarios();
            int id = c.getInt(c.getColumnIndex("id"));
            String login = c.getString(c.getColumnIndex("login"));
            String email = c.getString(c.getColumnIndex("email"));
            String senha = c.getString(c.getColumnIndex("senha"));
            usuarios.setId(id);
            usuarios.setUsuario(login);
            usuarios.setEmail(email);
            usuarios.setSenha(senha);

            usuario.add(usuarios);
        }

        return usuario;
    }
}
