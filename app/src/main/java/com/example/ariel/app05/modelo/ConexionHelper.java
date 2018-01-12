package com.example.ariel.app05.modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ariel on 11-01-2018.
 *
 *
 *
 */

public class ConexionHelper extends SQLiteOpenHelper {

    //DEFINIR LA DB
    private static final String NAME_DB = "mascotas";
    private static final Integer VERSION = 2;

    //DEFINIR LA ESTRUCTURA DE LA TABLA
    public static final String TABLE_NAME = "mascota";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NOMBRE = "nombre";
    public static final String COLUMN_GEN = "genero";
    public static final String COLUMN_RAZA = "raza";
    public static final String COLUMN_PESO = "peso";



    public ConexionHelper(Context context){
        super (context, NAME_DB, null, VERSION);  // SE MANDAN LOS PARAMETROS A LA CLASE SUPER CON LOS ATRIBUTOS
    }

    // METODO SE EJECUTA SOLO 1 VEZ PARA CREACIOS DE LA TABLA
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE " + TABLE_NAME +" (";
        sql += COLUMN_ID        + " integer primary key autoincrement, ";
        sql += COLUMN_NOMBRE    + " text     ,";
        sql += COLUMN_GEN      + " text     ,";
        sql += COLUMN_RAZA       + " text     ,";
        sql += COLUMN_PESO      + " double   );";


        //SE EJECUTA LA CONSULTA SOLO 1 VEZ CON 1 DATO DE PRUEBA
        sqLiteDatabase.execSQL(sql);
        sqLiteDatabase.execSQL("insert into " +TABLE_NAME+" values(null,'Bobby','Gran Danes','F',30);");
    }

    // METODO PARA CUANDO SE ACTUALIZA LA "VERSION" DE LA BASE DE DATOS O EL MODELO DE DATOS
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}


