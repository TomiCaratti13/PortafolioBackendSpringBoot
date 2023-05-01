
package com.miPortafolio.trc.Service;

import com.miPortafolio.trc.Entity.HabilidadEntity;
import com.miPortafolio.trc.Repository.HabilidadRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

   
@Service
@Transactional
public class HabilidadService {
    @Autowired
    HabilidadRepository habilidadRepo;
    
    public List<HabilidadEntity> list(){
        return habilidadRepo.findAll();
    }
    
    public Optional<HabilidadEntity> getOne(int id) {
        return habilidadRepo.findById(id);
    }
    
    public Optional<HabilidadEntity> getByNombreHys(String nombreHys) {
        return habilidadRepo.findByNombreHys(nombreHys);
    }
    
    public void save(HabilidadEntity habilidad) {
        habilidadRepo.save(habilidad);
    }
    
    public void delete(int id) {
        habilidadRepo.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return habilidadRepo.existsById(id);
    }
    
    public boolean existsByNombreHys(String nombreHys) {
        return habilidadRepo.existsByNombreHys(nombreHys);
    }
}