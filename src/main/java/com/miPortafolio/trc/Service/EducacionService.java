
package com.miPortafolio.trc.Service;

import com.miPortafolio.trc.Entity.EducacionEntity;
import com.miPortafolio.trc.Repository.EducacionRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EducacionService {
    @Autowired
    EducacionRepository educacionRepo;
    
    public List<EducacionEntity> list(){
        return educacionRepo.findAll();
    }
    
    public Optional<EducacionEntity> getOne(int id) {
        return educacionRepo.findById(id);
    }
    
    public Optional<EducacionEntity> getByTituloEdu(String tituloEdu) {
        return educacionRepo.findByTituloEdu(tituloEdu);
    }
    
    public void save(EducacionEntity educacion) {
        educacionRepo.save(educacion);
    }
    
    public void delete(int id) {
        educacionRepo.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return educacionRepo.existsById(id);
    }
    
    public boolean existsByTituloEdu(String tituloEdu) {
        return educacionRepo.existsByTituloEdu(tituloEdu);
    }
}
