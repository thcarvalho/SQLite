package com.banco.terasgahd.banco.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.banco.terasgahd.banco.R;
import com.banco.terasgahd.banco.model.Usuarios;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.MyViewHolder> {

    private List<Usuarios> usuariosList;

    public UsersAdapter(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemLista = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_layout,viewGroup,false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Usuarios usuarios = usuariosList.get(i);
        myViewHolder.usuarios.setText(usuarios.getUsuario());
        myViewHolder.email.setText(usuarios.getEmail());
    }

    @Override
    public int getItemCount() {
        return this.usuariosList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView usuarios;
        TextView email;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            usuarios = itemView.findViewById(R.id.txtLogin);
            email = itemView.findViewById(R.id.txtEmail);
        }
    }

}
