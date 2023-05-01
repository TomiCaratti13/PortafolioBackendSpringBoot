
package com.miPortafolio.trc.Service;

import com.miPortafolio.trc.Entity.ProyectoEntity;
import com.miPortafolio.trc.Repository.ProyectoRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProyectoService {
    @Autowired
    ProyectoRepository proyectoRepo;
    
    public List<ProyectoEntity> list(){
        return proyectoRepo.findAll();
    }
    
    public Optional<ProyectoEntity> getOne(int id) {
        return proyectoRepo.findById(id);
    }
    
    public Optional<ProyectoEntity> getByNombrePro(String nombrePro) {
        return proyectoRepo.findByNombrePro(nombrePro);
    }
    
    public void save(ProyectoEntity proyecto) {
        proyectoRepo.save(proyecto);
    }
    
    public void delete(int id) {
        proyectoRepo.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return proyectoRepo.existsById(id);
    }
    
    public boolean existsByNombrePro(String nombrePro) {
        return proyectoRepo.existsByNombrePro(nombrePro);
    }
}
