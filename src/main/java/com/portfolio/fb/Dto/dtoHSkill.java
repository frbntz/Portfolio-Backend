package com.portfolio.fb.Dto;

import javax.validation.constraints.NotBlank;


public class dtoHSkill {
    
    @NotBlank
    private String nombre;
    @NotBlank
    private String porcentaje;
    @NotBlank
    private String img;
    private String color;

    public dtoHSkill() {
    }

    public dtoHSkill(String nombre, String porcentaje, String img, String color) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.img = img;
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
    
}
