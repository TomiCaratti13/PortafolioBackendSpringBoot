package com.miPortafolio.trc.Service;

import com.miPortafolio.trc.Entity.PersonaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.miPortafolio.trc.Repository.PersonaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

@Service
@Transactional
public class PersonaService {

    @Autowired
    PersonaRepository personaRepo;
    
    public List<PersonaEntity> list(){
        return personaRepo.findAll();
    }
    
    public Optional<PersonaEntity> getOne(int id) {
        return personaRepo.findById(id);
    }
    
    public Optional<PersonaEntity> getByNombre(String nombre) {
        return personaRepo.findByNombre(nombre);
    }
    
    public void save(PersonaEntity persona) {
        personaRepo.save(persona);
    }
    
    public void delete(int id) {
        personaRepo.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return personaRepo.existsById(id);
    }
    
    public boolean existsByNombre(String nombre) {
        return personaRepo.existsByNombre(nombre);
    }
}
