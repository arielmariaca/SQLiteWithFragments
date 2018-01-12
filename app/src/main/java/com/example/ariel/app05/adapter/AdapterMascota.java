package com.example.ariel.app05.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ariel.app05.R;
import com.example.ariel.app05.modelo.CrudMascota;
import com.example.ariel.app05.modelo.Mascota;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ariel on 11-01-2018.
 *
 */

public class AdapterMascota extends RecyclerView.Adapter<AdapterMascota.MascotaViewHolder> {

    private List<Mascota> list;
    private int resource;
    private Activity activity;

    public AdapterMascota(List<Mascota> lista, int resource, Activity activity) {
        this.list = lista;
        this.resource = resource;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new MascotaViewHolder(view);

    }

    @Override
    public void onBindViewHolder(MascotaViewHolder holder, int position) {
        Mascota m = list.get(position);
        holder.itemId.setText(String.valueOf(m.getId()));
        holder.itemNombre.setText(m.getNombre());
        holder.itemRaza.setText(m.getRaza());



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MascotaViewHolder extends RecyclerView.ViewHolder{

        private TextView itemNombre, itemRaza, itemId;
        private ImageView itemTrash, itemUpdate;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            itemNombre = itemView.findViewById(R.id.item_nombre);
            itemRaza = itemView.findViewById(R.id.item_raza);
            itemId = itemView.findViewById(R.id.item_id);
            itemTrash = itemView.findViewById(R.id.borrar);
            itemUpdate = itemView.findViewById(R.id.actualizar);


           itemTrash.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   eliminar(Integer.parseInt(itemId.getText().toString()));
                   notifyDataSetChanged();
                   //NOTIFICA EL CAMBIO EN LA LISTA, TANTO "notifyDataSetChanged()" COMO  "list = crud.mascotaList()"
                   //AMBOS SON NECESARIOS PARA ACTUALIZAR LA LISTA Y REFRESCARLA PARA LISTA EN EL "FRAGMENT"
                }
            });
        }

        public void eliminar (int i){
            CrudMascota crud = new CrudMascota(itemView.getContext());
            crud.eliminar(i);
            list = crud.mascotaList();      //REFRESCA LA LISTA EL ELIMNAR
            Log.e("info","TAM: "+crud.mascotaList().size());
        }
    }
}
