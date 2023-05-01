
package com.miPortafolio.trc.Dto;

import javax.validation.constraints.NotBlank;


public class DtoHabilidad {
    @NotBlank
    private String nombreHys;
    @NotBlank
    private int porcentaje;

    public DtoHabilidad() {
    }    

    public DtoHabilidad(String nombreHys, int porcentaje) {
        this.nombreHys = nombreHys;
        this.porcentaje = porcentaje;
    }

    public String getNombreHys() {
        return nombreHys;
    }

    public void setNombreHys(String nombreHys) {
        this.nombreHys = nombreHys;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

}
