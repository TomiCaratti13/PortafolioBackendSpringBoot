
package com.miPortafolio.trc.Dto;

import javax.validation.constraints.NotBlank;


public class DtoHabilidad {
    @NotBlank
    private String nombreHys;
    @NotBlank
    private String icono;
    @NotBlank
    private int porcentaje;

    public DtoHabilidad() {
    }    

    public DtoHabilidad(String nombreHys, String icono, int porcentaje) {
        this.nombreHys = nombreHys;
        this.icono = icono;
        this.porcentaje = porcentaje;
    }

    public String getNombreHys() {
        return nombreHys;
    }

    public void setNombreHys(String nombreHys) {
        this.nombreHys = nombreHys;
    }
    
    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

}
