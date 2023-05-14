
package com.miPortafolio.trc.Controller;

import com.miPortafolio.trc.Dto.DtoPersona;
import com.miPortafolio.trc.Entity.PersonaEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.miPortafolio.trc.Security.Controller.Mensaje;
import com.miPortafolio.trc.Service.PersonaService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/personas")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://tomascaratti-portafolio.web.app")
public class PersonaController {
    @Autowired
    PersonaService personaService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<PersonaEntity>> list(){
        List<PersonaEntity> list = personaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<PersonaEntity> getById(@PathVariable("id")int id){
        if(!personaService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        PersonaEntity persona = personaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    
    /*@DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!personaService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        personaService.delete(id);
        return new ResponseEntity(new Mensaje("Persona eliminada"), HttpStatus.OK);
    }*/
    
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody DtoPersona dtopersona){
        if(personaService.existsByNombre(dtopersona.getNombre()))
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtopersona.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtopersona.getApellido()))
            return new ResponseEntity(new Mensaje("El apellido es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtopersona.getTitulo()))
            return new ResponseEntity(new Mensaje("El apellido es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtopersona.getDescripcion()))
            return new ResponseEntity(new Mensaje("La descripcion es obligatoria"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtopersona.getImgPerfil()))
            return new ResponseEntity(new Mensaje("La foto de perfil es obligatoria"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtopersona.getCurriculum()))
            return new ResponseEntity(new Mensaje("La foto de perfil es obligatoria"), HttpStatus.BAD_REQUEST);
        
        PersonaEntity educacion = new PersonaEntity(
                dtopersona.getNombre(),
                dtopersona.getApellido(),
                dtopersona.getTitulo(),
                dtopersona.getDescripcion(),
                dtopersona.getImgPerfil(),
                dtopersona.getImgBanner(),
                dtopersona.getCurriculum());
        personaService.save(educacion);
        return new ResponseEntity(new Mensaje("PersonaEntity creada"), HttpStatus.OK);
                
    }
    
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoPersona dtopersona){
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        if(personaService.existsByNombre(dtopersona.getNombre()) && personaService.getByNombre(dtopersona.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtopersona.getNombre()))
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtopersona.getApellido()))
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtopersona.getTitulo()))
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtopersona.getDescripcion()))
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtopersona.getImgPerfil()))
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtopersona.getCurriculum()))
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        
        PersonaEntity personaEntity = personaService.getOne(id).get();
        personaEntity.setNombre(dtopersona.getNombre());
        personaEntity.setApellido(dtopersona.getApellido());
        personaEntity.setTitulo(dtopersona.getTitulo());
        personaEntity.setDescripcion(dtopersona.getDescripcion());
        personaEntity.setImgPerfil(dtopersona.getImgPerfil());
        personaEntity.setImgBanner(dtopersona.getImgBanner());
        personaEntity.setCurriculum(dtopersona.getCurriculum());
        
        personaService.save(personaEntity);
        
        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
    }
   
}
