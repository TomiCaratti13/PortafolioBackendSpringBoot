
package com.miPortafolio.trc.Repository;

import com.miPortafolio.trc.Entity.ExperienciaEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepository extends JpaRepository<ExperienciaEntity, Integer>{
    public Optional<ExperienciaEntity> findByCargoExp(String cargoExp);
    public boolean existsByCargoExp(String cargoExp);
}
