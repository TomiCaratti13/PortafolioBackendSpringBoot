
package com.miPortafolio.trc.Security.Repository;

import com.miPortafolio.trc.Security.Entity.Rol;
import com.miPortafolio.trc.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
