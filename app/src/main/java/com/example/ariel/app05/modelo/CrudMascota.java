package com.example.ariel.app05.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ariel on 11-01-2018.
 *
 *      SE CREAN LOS METODOS GENERICOS PARA LAS OPERACIONES BASICA DE BASE DE DATOS QUE SE PUEDAN UTILIZAR
 *
 */

public class CrudMascota {

    private SQLiteDatabase db;
    private ContentValues values;
    private ConexionHelper helper;

    public CrudMascota(Context context) {
        helper = new ConexionHelper(context);
        values = new ContentValues();
    }

    public void insertar (Mascota m){
        //SETEA LA BASE DE EN MODO ESCRITURA
        db = helper.getWritableDatabase();

        //LIMPIA "values" ANTES DE CARGAR LOS DATOS DESDE EL OBJETO
        values.clear();

        //AL SER EL "ConexionHelper" STATIC FNAL SE PUEDE ACCEDER DIRECTAMENTE
        // AL NOMBRE DE COLUMNA Y OBTENER "getNombre" DEL  DE CLASE "MASCOTA" QUE VIENE DESDE LA INTERFAZ
        values.put(ConexionHelper.COLUMN_NOMBRE, m.getNombre());
        values.put(ConexionHelper.COLUMN_GEN, m.getGenero());
        values.put(ConexionHelper.COLUMN_RAZA, m.getRaza());
        values.put(ConexionHelper.COLUMN_PESO, m.getPeso());

        //EJECUTAR LA SENTENCIA
        try{
            db.insert(ConexionHelper.TABLE_NAME, null, values);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            db.close();
        }

    }
    public void eliminar (Integer id){
        String cod = String.valueOf(id);
        db = helper.getWritableDatabase();
        db.delete(ConexionHelper.TABLE_NAME,ConexionHelper.COLUMN_ID+"=?", new String[]{cod});
    }
    public void actualizar (Mascota m){
        String cod = String.valueOf(m.getId());
        db = helper.getWritableDatabase();
        values.clear();
        values.put(ConexionHelper.COLUMN_NOMBRE, m.getNombre());
        values.put(ConexionHelper.COLUMN_GEN, m.getGenero());
        values.put(ConexionHelper.COLUMN_RAZA, m.getRaza());
        values.put(ConexionHelper.COLUMN_PESO, m.getPeso());
        db.update(ConexionHelper.TABLE_NAME, values, ConexionHelper.COLUMN_ID+"=?", new String[]{cod});
    }
    public Mascota buscar (Integer id){
        String cod = String.valueOf(id);
        db = helper.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM "+ConexionHelper.TABLE_NAME, new String[]{cod});
        if (c.moveToNext()){
            Mascota m = new Mascota();
            m.setId(id);
            m.setNombre(c.getString(1));
            m.setGenero(c.getString(2));
            m.setRaza(c.getString(3));
            m.setPeso(c.getDouble(4));
            return m;
        }
        return null;
    }
    public List<Mascota> mascotaList(){
        ArrayList<Mascota> list = new ArrayList<>();
        db = helper.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM "+ConexionHelper.TABLE_NAME, null);
        while (c.moveToNext()){
            Mascota m = new Mascota();
            m.setId(c.getInt(0));
            m.setNombre(c.getString(1));
            m.setRaza(c.getString(2));
            m.setGenero(c.getString(3));
            m.setPeso(c.getDouble(4));
            list.add(m);
        }
        return list;
    }
}
