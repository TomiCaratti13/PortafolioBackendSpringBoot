
package com.miPortafolio.trc.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EducacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tituloEdu;
    private String instiEdu;
    private String fechaEdu;
    private String imgEdu;
    private String descripcionEdu;

    public EducacionEntity() {
    }

    public EducacionEntity(String tituloEdu, String instiEdu, String fechaEdu, String imgEdu, String descripcionEdu) {
        this.tituloEdu = tituloEdu;
        this.instiEdu = instiEdu;
        this.fechaEdu = fechaEdu;
        this.imgEdu = imgEdu;
        this.descripcionEdu = descripcionEdu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
