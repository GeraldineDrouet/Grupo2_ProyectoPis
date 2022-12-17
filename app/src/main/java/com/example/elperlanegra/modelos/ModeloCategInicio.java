package com.example.elperlanegra.modelos;

public class ModeloCategInicio {
    String nombre;
    String img_url;

    public ModeloCategInicio() {
    }

    public ModeloCategInicio(String nombre, String img_url) {
        this.nombre = nombre;
        this.img_url = img_url;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
}
