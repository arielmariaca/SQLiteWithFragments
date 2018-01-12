package com.example.ariel.app05;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;

import com.example.ariel.app05.fragment.fra_insertar;
import com.example.ariel.app05.fragment.fra_listar;

public class act_mainDB extends AppCompatActivity {

    private FragmentManager fm;
    private FragmentTransaction ft;
    private Fragment fragment;

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    cargarFraLista();
                    return true;
                case R.id.navigation_dashboard:
                    cargarFraInsertar();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main_db);

        cargarFraLista();

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void cargarFraLista(){
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        fragment = new fra_listar();
        ft.replace(R.id.contenedor, fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }

    public void cargarFraInsertar(){
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        fragment = new fra_insertar();
        ft.replace(R.id.contenedor, fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }

}
