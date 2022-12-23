package com.example.elperlanegra.modelos;

public class ModeloProducto {

    String nombreProd;
    String rating;
    String img_url;
    String precio;

    public ModeloProducto() {
    }

    public ModeloProducto(String nombreProd, String rating, String img_url, String precio) {
        this.nombreProd = nombreProd;
        this.rating = rating;
        this.img_url = img_url;
        this.precio = precio;
    }

    public String getNombreProd() {
        return nombreProd;
    }

    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}
