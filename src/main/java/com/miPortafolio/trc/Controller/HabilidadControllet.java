
package com.miPortafolio.trc.Controller;

import com.miPortafolio.trc.Dto.DtoHabilidad;
import com.miPortafolio.trc.Entity.HabilidadEntity;
import com.miPortafolio.trc.Security.Controller.Mensaje;
import com.miPortafolio.trc.Service.HabilidadService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/habilidad")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://tomascaratti-portafolio.web.app")
public class HabilidadControllet {
    @Autowired
    HabilidadService habilidadServ;
    
    @GetMapping("/lista")
    public ResponseEntity<List<HabilidadEntity>> list(){
        List<HabilidadEntity> list = habilidadServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<HabilidadEntity> getById(@PathVariable("id") int id){
        if(!habilidadServ.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        HabilidadEntity habilidad = habilidadServ.getOne(id).get();
        return new ResponseEntity(habilidad, HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody DtoHabilidad dtohabilidad){      
        if(StringUtils.isBlank(dtohabilidad.getNombreHys()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(habilidadServ.existsByNombreHys(dtohabilidad.getNombreHys()))
            return new ResponseEntity(new Mensaje("Esa habilidad existe"), HttpStatus.BAD_REQUEST);
        
        HabilidadEntity habilidadEntity = new HabilidadEntity(
                dtohabilidad.getNombreHys(),
                dtohabilidad.getPorcentaje());
        habilidadServ.save(habilidadEntity);
        
        return new ResponseEntity(new Mensaje("Habilidad agregada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!habilidadServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        }
        habilidadServ.delete(id);
        return new ResponseEntity(new Mensaje("Habilidad eliminada"), HttpStatus.OK);
    }
    
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoHabilidad dtohabilidad){
        if(!habilidadServ.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        if(habilidadServ.existsByNombreHys(dtohabilidad.getNombreHys()) && habilidadServ.getByNombreHys(dtohabilidad.getNombreHys()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa habilidad ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtohabilidad.getNombreHys()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        HabilidadEntity habilidadEntity = habilidadServ.getOne(id).get();
        habilidadEntity.setNombreHys(dtohabilidad.getNombreHys());
        habilidadEntity.setPorcentaje(dtohabilidad.getPorcentaje());
        
        habilidadServ.save(habilidadEntity);
        return new ResponseEntity(new Mensaje("Habilidad actualizada"), HttpStatus.OK);
    }
}
