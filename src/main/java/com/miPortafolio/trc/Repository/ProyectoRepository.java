
package com.miPortafolio.trc.Repository;

import com.miPortafolio.trc.Entity.ProyectoEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepository extends JpaRepository<ProyectoEntity, Integer>{
    public Optional<ProyectoEntity> findByNombrePro(String nombrePro);
    public boolean existsByNombrePro(String nombrePro);
}