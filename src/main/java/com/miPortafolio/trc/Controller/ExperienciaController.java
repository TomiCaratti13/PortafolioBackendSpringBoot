
package com.miPortafolio.trc.Controller;

import com.miPortafolio.trc.Dto.DtoExperiencia;
import com.miPortafolio.trc.Entity.ExperienciaEntity;
import com.miPortafolio.trc.Security.Controller.Mensaje;
import com.miPortafolio.trc.Service.ExperienciaService;
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
@RequestMapping("/experiencia")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://tomascaratti-portafolio.web.app")
public class ExperienciaController {
    @Autowired
    ExperienciaService experienciaServ;
    
    @GetMapping("/lista")
    public ResponseEntity<List<ExperienciaEntity>> list(){
        List<ExperienciaEntity> list = experienciaServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<ExperienciaEntity> getById(@PathVariable("id") int id){
        if(!experienciaServ.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        ExperienciaEntity experiencia = experienciaServ.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody DtoExperiencia dtoexperiencia){      
        if(StringUtils.isBlank(dtoexperiencia.getCargoExp()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(experienciaServ.existsByCargoExp(dtoexperiencia.getCargoExp()))
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoexperiencia.getEmpresaExp()))
            return new ResponseEntity(new Mensaje("La empresa es obligatoria"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoexperiencia.getFechaExp()))
            return new ResponseEntity(new Mensaje("La fecha es obligatoria"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoexperiencia.getDescripcionExp()))
            return new ResponseEntity(new Mensaje("La descripcion es obligatoria"), HttpStatus.BAD_REQUEST);
        
        ExperienciaEntity experienciaEntity = new ExperienciaEntity(
                dtoexperiencia.getCargoExp(),
                dtoexperiencia.getEmpresaExp(),
                dtoexperiencia.getFechaExp(),
                dtoexperiencia.getDescripcionExp());
        experienciaServ.save(experienciaEntity);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!experienciaServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        }
        experienciaServ.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }
    
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExperiencia dtoexperiencia){
        if(!experienciaServ.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        if(experienciaServ.existsByCargoExp(dtoexperiencia.getCargoExp()) && experienciaServ.getByCargoExp(dtoexperiencia.getCargoExp()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoexperiencia.getCargoExp()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoexperiencia.getEmpresaExp()))
            return new ResponseEntity(new Mensaje("La empresa es obligatoria"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoexperiencia.getFechaExp()))
            return new ResponseEntity(new Mensaje("La fecha es obligatoria"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoexperiencia.getDescripcionExp()))
            return new ResponseEntity(new Mensaje("La descripcion es obligatoria"), HttpStatus.BAD_REQUEST);
        
        ExperienciaEntity experienciaEntity = experienciaServ.getOne(id).get();
        experienciaEntity.setCargoExp(dtoexperiencia.getCargoExp());
        experienciaEntity.setEmpresaExp(dtoexperiencia.getEmpresaExp());
        experienciaEntity.setFechaExp(dtoexperiencia.getFechaExp());
        experienciaEntity.setDescripcionExp((dtoexperiencia.getDescripcionExp()));
        
        experienciaServ.save(experienciaEntity);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
    }
}
