package com.example.ariel.app05.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ariel.app05.R;
import com.example.ariel.app05.adapter.AdapterMascota;
import com.example.ariel.app05.modelo.CrudMascota;

/**
 * A simple {@link Fragment} subclass.
 */
public class fra_listar extends Fragment {


    public fra_listar() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view = inflater.inflate(R.layout.fragment_fra_listar, container, false);

        RecyclerView recycler = view.findViewById(R.id.recycler_mascotas);
        LinearLayoutManager lm = new LinearLayoutManager(getContext());
        lm.setOrientation(LinearLayoutManager.VERTICAL);

        CrudMascota crud = new CrudMascota(getActivity());
        recycler.setLayoutManager(lm);
        recycler.setAdapter(new AdapterMascota(crud.mascotaList(), R.layout.item_mascota, getActivity()));

        return view;
    }

}
