
package com.miPortafolio.trc.Repository;

import com.miPortafolio.trc.Entity.HabilidadEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HabilidadRepository extends JpaRepository<HabilidadEntity, Integer>{
    public Optional<HabilidadEntity> findByNombreHys(String nombreHys);
    public boolean existsByNombreHys(String nombreHys);
}
