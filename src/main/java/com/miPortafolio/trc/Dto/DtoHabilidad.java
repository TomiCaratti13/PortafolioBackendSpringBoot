
package com.miPortafolio.trc.Dto;

import javax.validation.constraints.NotBlank;


public class DtoHabilidad {
    @NotBlank
    private String nombreHys;
    @NotBlank
    private String iconoHys;
    @NotBlank
    private int porcentaje;

    public DtoHabilidad() {
    }    

    public DtoHabilidad(String nombreHys, String iconoHys, int porcentaje) {
        this.nombreHys = nombreHys;
        this.iconoHys = iconoHys;
        this.porcentaje = porcentaje;
    }

    public String getNombreHys() {
        return nombreHys;
    }

    public void setNombreHys(String nombreHys) {
        this.nombreHys = nombreHys;
    }
    
    public String getIconoHys() {
        return iconoHys;
    }

    public void setIconoHys(String iconoHys) {
        this.iconoHys = iconoHys;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

}
