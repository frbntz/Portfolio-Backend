package com.portfolio.fb.Dto;

import javax.validation.constraints.NotBlank;

public class dtoSkill {

    @NotBlank
    private String nombre;
    @NotBlank
    private String softSkill;

    public dtoSkill() {
    }

    public dtoSkill(String nombre, String softSkill) {
        this.nombre = nombre;
        this.softSkill = softSkill;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSoftSkill() {
        return softSkill;
    }

    public void setSoftSkill(String softSkill) {
        this.softSkill = softSkill;
    }
    
    

}
