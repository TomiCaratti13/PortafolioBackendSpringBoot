
package com.miPortafolio.trc.Dto;

import javax.validation.constraints.NotBlank;


public class DtoEducacion {
     @NotBlank
    private String tituloEdu;
    @NotBlank
    private String instiEdu;
    @NotBlank
    private String fechaEdu;
    @NotBlank
    private String imgEdu;
    @NotBlank
    private String descripcionEdu;

    public DtoEducacion() {
    }

    public DtoEducacion(String tituloEdu, String instiEdu, String fechaEdu, String imgEdu, String descripcionEdu) {
        this.tituloEdu = tituloEdu;
        this.instiEdu = instiEdu;
        this.fechaEdu = fechaEdu;
        this.imgEdu = imgEdu;
        this.descripcionEdu = descripcionEdu;
    }

    public String getTituloEdu() {
        return tituloEdu;
    }

    public void setTituloEdu(String tituloEdu) {
        this.tituloEdu = tituloEdu;
    }

    public String getInstiEdu() {
        return instiEdu;
    }

    public void setInstiEdu(String instiEdu) {
        this.instiEdu = instiEdu;
    }

    public String getFechaEdu() {
        return fechaEdu;
    }

    public void setFechaEdu(String fechaEdu) {
        this.fechaEdu = fechaEdu;
    }
    
    public String getImgEdu() {
        return imgEdu;
    }

    public void setImgEdu(String imgEdu) {
        this.imgEdu = imgEdu;
    }

    public String getDescripcionEdu() {
        return descripcionEdu;
    }

    public void setDescripcionEdu(String descripcionEdu) {
        this.descripcionEdu = descripcionEdu;
    }
    
    
}
