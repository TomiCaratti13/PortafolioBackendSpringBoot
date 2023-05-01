
package com.miPortafolio.trc.Dto;

import javax.validation.constraints.NotBlank;


public class DtoExperiencia {
    @NotBlank
    private String cargoExp;
    @NotBlank
    private String empresaExp;
    @NotBlank
    private String fechaExp;
    @NotBlank
    private String descripcionExp;

    public DtoExperiencia() {
    }

    public DtoExperiencia(String cargoExp, String empresaExp, String fechaExp, String descripcionExp) {
        this.cargoExp = cargoExp;
        this.empresaExp = empresaExp;
        this.fechaExp = fechaExp;
        this.descripcionExp = descripcionExp;
    }

    public String getCargoExp() {
        return cargoExp;
    }

    public void setCargoExp(String cargoExp) {
        this.cargoExp = cargoExp;
    }

    public String getEmpresaExp() {
        return empresaExp;
    }

    public void setEmpresaExp(String empresaExp) {
        this.empresaExp = empresaExp;
    }

    public String getFechaExp() {
        return fechaExp;
    }

    public void setFechaExp(String fechaExp) {
        this.fechaExp = fechaExp;
    }

    public String getDescripcionExp() {
        return descripcionExp;
    }

    public void setDescripcionExp(String descripcionExp) {
        this.descripcionExp = descripcionExp;
    }
    
}
