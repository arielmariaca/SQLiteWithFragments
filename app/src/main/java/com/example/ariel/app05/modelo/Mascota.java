package com.example.ariel.app05.modelo;

/**
 * Created by Ariel on 11-01-2018.
 *
 * Crear la estructura de la clase con 3 constructores (vacio, entero, y uno sin el ID porque es AUTOINCREMENT
 *
 *
 */

public class Mascota {

    private Integer id;
    private String nombre, raza, genero;
    private Double peso;

    public Mascota() {
    }

    public Mascota(Integer id, String nombre, String raza, String genero, Double peso) {
        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.genero = genero;
        this.peso = peso;
    }

    public Mascota(String nombre, String raza, String genero, Double peso) {
        this.nombre = nombre;
        this.raza = raza;
        this.genero = genero;
        this.peso = peso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }
}
