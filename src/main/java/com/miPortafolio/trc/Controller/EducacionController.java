
package com.miPortafolio.trc.Controller;

import com.miPortafolio.trc.Dto.DtoEducacion;
import com.miPortafolio.trc.Entity.EducacionEntity;
import com.miPortafolio.trc.Security.Controller.Mensaje;
import com.miPortafolio.trc.Service.EducacionService;
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
@RequestMapping("/educacion")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://tomascaratti-portafolio.web.app")
public class EducacionController {
    @Autowired
    EducacionService educacionServ;
    
    @GetMapping("/lista")
    public ResponseEntity<List<EducacionEntity>> list(){
        List<EducacionEntity> list = educacionServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<EducacionEntity> getById(@PathVariable("id") int id){
        if(!educacionServ.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        EducacionEntity educacion = educacionServ.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody DtoEducacion dtoeducacion){      
        if(StringUtils.isBlank(dtoeducacion.getTituloEdu()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(educacionServ.existsByTituloEdu(dtoeducacion.getTituloEdu()))
            return new ResponseEntity(new Mensaje("Esa educacion existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoeducacion.getInstiEdu()))
            return new ResponseEntity(new Mensaje("El Instituto es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoeducacion.getFechaEdu()))
            return new ResponseEntity(new Mensaje("La fecha es obligatoria"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoeducacion.getDescripcionEdu()))
            return new ResponseEntity(new Mensaje("La descripcion es obligatoria"), HttpStatus.BAD_REQUEST);
        
        EducacionEntity educacionEntity = new EducacionEntity(
                dtoeducacion.getTituloEdu(),
                dtoeducacion.getInstiEdu(),
                dtoeducacion.getFechaEdu(),
                dtoeducacion.getDescripcionEdu());
        educacionServ.save(educacionEntity);
        
        return new ResponseEntity(new Mensaje("Educacion agregada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!educacionServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        }
        educacionServ.delete(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }
    
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEducacion dtoeducacion){
        if(!educacionServ.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        if(educacionServ.existsByTituloEdu(dtoeducacion.getTituloEdu()) && educacionServ.getByTituloEdu(dtoeducacion.getTituloEdu()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa educacion ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoeducacion.getTituloEdu()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoeducacion.getInstiEdu()))
            return new ResponseEntity(new Mensaje("El Instituto es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoeducacion.getFechaEdu()))
            return new ResponseEntity(new Mensaje("La fecha es obligatoria"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoeducacion.getDescripcionEdu()))
            return new ResponseEntity(new Mensaje("La descripcion es obligatoria"), HttpStatus.BAD_REQUEST);
        
        EducacionEntity educacionEntity = educacionServ.getOne(id).get();
        educacionEntity.setTituloEdu(dtoeducacion.getTituloEdu());
        educacionEntity.setInstiEdu(dtoeducacion.getInstiEdu());
        educacionEntity.setFechaEdu(dtoeducacion.getFechaEdu());
        educacionEntity.setDescripcionEdu((dtoeducacion.getDescripcionEdu()));
        
        educacionServ.save(educacionEntity);
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
    }
}
