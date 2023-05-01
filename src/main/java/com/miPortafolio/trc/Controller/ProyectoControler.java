
package com.miPortafolio.trc.Controller;

import com.miPortafolio.trc.Dto.DtoProyecto;
import com.miPortafolio.trc.Entity.ProyectoEntity;
import com.miPortafolio.trc.Security.Controller.Mensaje;
import com.miPortafolio.trc.Service.ProyectoService;
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
@RequestMapping("/proyecto")
@CrossOrigin(origins = "http://localhost:4200")
public class ProyectoControler {
    @Autowired
    ProyectoService proyectoServ;
    
    @GetMapping("/lista")
    public ResponseEntity<List<ProyectoEntity>> list(){
        List<ProyectoEntity> list = proyectoServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<ProyectoEntity> getById(@PathVariable("id") int id){
        if(!proyectoServ.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        ProyectoEntity proyecto = proyectoServ.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody DtoProyecto dtoproyecto){      
        if(StringUtils.isBlank(dtoproyecto.getNombrePro()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(proyectoServ.existsByNombrePro(dtoproyecto.getNombrePro()))
            return new ResponseEntity(new Mensaje("Esa proyecto existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoproyecto.getAutorPro()))
            return new ResponseEntity(new Mensaje("El autor es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoproyecto.getDescripcionPro()))
            return new ResponseEntity(new Mensaje("La descripcion es obligatoria"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoproyecto.getImgPro()))
            return new ResponseEntity(new Mensaje("La descripcion es obligatoria"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoproyecto.getUrlLive()))
            return new ResponseEntity(new Mensaje("La url-live es obligatoria"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoproyecto.getUrlRepo()))
            return new ResponseEntity(new Mensaje("La url-github es obligatoria"), HttpStatus.BAD_REQUEST);
        
        ProyectoEntity proyectoEntity = new ProyectoEntity(
                dtoproyecto.getNombrePro(),
                dtoproyecto.getAutorPro(),
                dtoproyecto.getDescripcionPro(),
                dtoproyecto.getImgPro(),
                dtoproyecto.getUrlLive(),
                dtoproyecto.getUrlRepo());
        
        proyectoServ.save(proyectoEntity);
        
        return new ResponseEntity(new Mensaje("Proyecto agregada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!proyectoServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        }
        proyectoServ.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminada"), HttpStatus.OK);
    }
    
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoProyecto dtoproyecto){
        if(!proyectoServ.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        if(proyectoServ.existsByNombrePro(dtoproyecto.getNombrePro()) && proyectoServ.getByNombrePro(dtoproyecto.getNombrePro()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa proyecto ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoproyecto.getNombrePro()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoproyecto.getAutorPro()))
            return new ResponseEntity(new Mensaje("El autor es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoproyecto.getDescripcionPro()))
            return new ResponseEntity(new Mensaje("La descripcion es obligatoria"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoproyecto.getImgPro()))
            return new ResponseEntity(new Mensaje("La imagen es obligatoria"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoproyecto.getUrlLive()))
            return new ResponseEntity(new Mensaje("La url live es obligatoria"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoproyecto.getUrlRepo()))
            return new ResponseEntity(new Mensaje("La url repo github es obligatoria"), HttpStatus.BAD_REQUEST);
        
        ProyectoEntity proyectoEntity = proyectoServ.getOne(id).get();
        proyectoEntity.setNombrePro(dtoproyecto.getNombrePro());
        proyectoEntity.setAutorPro(dtoproyecto.getAutorPro());
        proyectoEntity.setImgPro(dtoproyecto.getImgPro());
        proyectoEntity.setDescripcionPro((dtoproyecto.getDescripcionPro()));
        proyectoEntity.setUrlLive((dtoproyecto.getUrlLive()));
        proyectoEntity.setUrlLive((dtoproyecto.getUrlRepo()));
        
        proyectoServ.save(proyectoEntity);
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
    }
}
