
package com.miPortafolio.trc.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProyectoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombrePro;
    private String autorPro;
    private String descripcionPro;
    private String imgPro;
    private String urlLive;
    private String urlRepo;

    public ProyectoEntity() {
    }

    public ProyectoEntity(String nombrePro, String autorPro, String descripcionPro, String imgPro, String urlLive, String urlRepo) {
        this.nombrePro = nombrePro;
        this.autorPro = autorPro;
        this.descripcionPro = descripcionPro;
        this.imgPro = imgPro;
        this.urlLive = urlLive;
        this.urlRepo = urlRepo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
