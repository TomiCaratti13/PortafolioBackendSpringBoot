
package com.miPortafolio.trc.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HabilidadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreHys;
    private String icono;
    private int porcentaje;

    public HabilidadEntity() {
    }

    public HabilidadEntity(String nombreHys, String icono, int porcentaje) {
        this.nombreHys = nombreHys;
        this.icono = icono;
        this.porcentaje = porcentaje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
