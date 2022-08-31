package com.portfolio.fb.Dto;

import javax.validation.constraints.NotBlank;


public class dtoPersona {
    
    @NotBlank
    private String nombre;
    
    @NotBlank
    private String apellido;
    
    @NotBlank
    private String img;
    
    @NotBlank
    private String about;

    public dtoPersona() {
    }

    public dtoPersona(String nombre, String apellido, String img, String about) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.about = about;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
    
    
}
