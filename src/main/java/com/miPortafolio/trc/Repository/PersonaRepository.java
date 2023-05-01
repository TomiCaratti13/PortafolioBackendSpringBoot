
package com.miPortafolio.trc.Repository;

import com.miPortafolio.trc.Entity.PersonaEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<PersonaEntity, Integer> {
    public Optional<PersonaEntity> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
