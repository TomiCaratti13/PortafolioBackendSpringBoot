
package com.miPortafolio.trc.Dto;

import javax.validation.constraints.NotBlank;


public class DtoProyecto {
    @NotBlank
    private String nombrePro;
    @NotBlank
    private String autorPro;
    @NotBlank
    private String descripcionPro;
    @NotBlank
    private String imgPro;
    @NotBlank
    private String urlLive;
    @NotBlank
    private String urlRepo;

    public DtoProyecto() {
        
    }

    public DtoProyecto(String nombrePro, String autorPro, String descripcionPro, String imgPro, String urlLive, String urlRepo) {
        this.nombrePro = nombrePro;
        this.autorPro = autorPro;
        this.descripcionPro = descripcionPro;
        this.imgPro = imgPro;
        this.urlLive = urlLive;
        this.urlRepo = urlRepo;
    }

    public String getNombrePro() {
        return nombrePro;
    }

    public void setNombrePro(String nombrePro) {
        this.nombrePro = nombrePro;
    }

    public String getAutorPro() {
        return autorPro;
    }

    public void setAutorPro(String autorPro) {
        this.autorPro = autorPro;
    }

    public String getDescripcionPro() {
        return descripcionPro;
    }

    public void setDescripcionPro(String descripcionPro) {
        this.descripcionPro = descripcionPro;
    }

    public String getImgPro() {
        return imgPro;
    }

    public void setImgPro(String imgPro) {
        this.imgPro = imgPro;
    }

    public String getUrlLive() {
        return urlLive;
    }

    public void setUrlLive(String urlLive) {
        this.urlLive = urlLive;
    }

    public String getUrlRepo() {
        return urlRepo;
    }

    public void setUrlRepo(String urlRepo) {
        this.urlRepo = urlRepo;
    }

}
