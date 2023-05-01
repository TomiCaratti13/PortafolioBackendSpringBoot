
package com.miPortafolio.trc.Service;

import com.miPortafolio.trc.Entity.ExperienciaEntity;
import com.miPortafolio.trc.Repository.ExperienciaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienciaService {
    @Autowired
    ExperienciaRepository experienciaRepo;
    
    public List<ExperienciaEntity> list(){
        return experienciaRepo.findAll();
    }
    
    public Optional<ExperienciaEntity> getOne(int id) {
        return experienciaRepo.findById(id);
    }
    
    public Optional<ExperienciaEntity> getByCargoExp(String cargoExp) {
        return experienciaRepo.findByCargoExp(cargoExp);
    }
    
    public void save(ExperienciaEntity experiencia) {
        experienciaRepo.save(experiencia);
    }
    
    public void delete(int id) {
        experienciaRepo.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return experienciaRepo.existsById(id);
    }
    
    public boolean existsByCargoExp(String cargoExp) {
        return experienciaRepo.existsByCargoExp(cargoExp);
    }
}
