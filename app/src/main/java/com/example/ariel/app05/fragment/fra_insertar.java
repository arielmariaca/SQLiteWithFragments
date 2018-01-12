package com.example.ariel.app05.fragment;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ariel.app05.R;
import com.example.ariel.app05.modelo.CrudMascota;
import com.example.ariel.app05.modelo.Mascota;

/**
 * A simple {@link Fragment} subclass.
 */
public class fra_insertar extends Fragment {

    private TextInputEditText txtNombre, txtPeso;
    private Spinner txtGenero, txtRaza;
    private FloatingActionButton btn;

    public fra_insertar() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fra_insertar, container, false);

        //PARA UTILIZAR LOS "finViewById" SE DEBE CPIAR Y PEGAR "inflater.inflate(R.layout.fragment_fra_insertar, container, false);"
        //DESDE EL "RETURN" PARA LUEGO RETORNAR LA VISTA "return view;"

        txtNombre = view.findViewById(R.id.mas_nombre);
        txtGenero = view.findViewById(R.id.mas_genero);
        txtRaza = view.findViewById(R.id.mas_raza);
        txtPeso = view.findViewById(R.id.mas_peso);
        btn = view.findViewById(R.id.btn_plus1);

        //PROGRAMAR EL EVENTO DEL BTN PARA EJECUTAR EL INSERT

        btn.setOnClickListener(new View.OnClickListener() {  //PARA FABRICAR EL METODO SE DEBE INGRESA "new View.OnClickListener()" CON "v" EN MAYUSCULAS
            @Override
            public void onClick(View view) {
                guardarMascotas();
            }
        });

        return view;
    }

    public void guardarMascotas (){
        CrudMascota crud = new CrudMascota(getActivity());
        String nombre = txtNombre.getText().toString();
        String genero = txtGenero.getSelectedItem().toString();
        String raza = txtRaza.getSelectedItem().toString();
        String peso = txtPeso.getText().toString();

        Mascota m = new Mascota(nombre, genero, raza, Double.parseDouble(peso));
        if (txtGenero.getSelectedItemId()==0 && txtRaza.getSelectedItemId()==0){

        }
        crud.insertar(m);
        Toast.makeText(getContext(), "Insertado", Toast.LENGTH_SHORT ).show();
        txtNombre.setText("");
        txtGenero.setSelection(0);
        txtRaza.setSelection(0);
        txtNombre.setText("");
        Log.e("info","TAM:"+crud.mascotaList().size());

    }


}
