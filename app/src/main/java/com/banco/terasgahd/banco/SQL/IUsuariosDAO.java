package com.banco.terasgahd.banco.SQL;

import com.banco.terasgahd.banco.model.Usuarios;

import java.util.List;

public interface IUsuariosDAO {
    public boolean salvar(Usuarios usuarios);
    public List<Usuarios> visualizar();

}
