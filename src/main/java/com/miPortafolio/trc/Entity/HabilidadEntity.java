
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
    private String iconoHys;
    private int porcentaje;

    public HabilidadEntity() {
    }

    public HabilidadEntity(String nombreHys, String iconoHys, int porcentaje) {
        this.nombreHys = nombreHys;
        this.iconoHys = iconoHys;
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
