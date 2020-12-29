package com.example.mascotas;

import java.io.Serializable;

public class Mascota implements Serializable {

    String nombreMascota;
    int fotoPerro;
    int likesPerro;

    //METODO CONSTRUCTOR DE CLASE Mascota

    public Mascota(String nombreMascota, int fotoPerro, int likesPerro) {
        this.nombreMascota = nombreMascota;
        this.fotoPerro = fotoPerro;
        this.likesPerro = likesPerro;
    }

    //GETTER AND SETTERS DE nombreMascota y fotoPerro

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public int getFotoPerro() {
        return fotoPerro;
    }

    public void setFotoPerro(int fotoPerro) {
        this.fotoPerro = fotoPerro;
    }

    public int getLikesPerro() {
        return likesPerro;
    }

    public void setLikesPerro(int likesPerro) {
        this.likesPerro = likesPerro;
    }
}
