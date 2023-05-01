
package com.miPortafolio.trc.Repository;

import com.miPortafolio.trc.Entity.EducacionEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacionRepository extends JpaRepository<EducacionEntity, Integer>{
    public Optional<EducacionEntity> findByTituloEdu(String tituloExp);
    public boolean existsByTituloEdu(String tituloExp);
}
