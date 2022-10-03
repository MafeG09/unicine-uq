package co.edu.uniquindio.unicine.repo;

import co.edu.uniquindio.unicine.entidades.TipoSala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoSalaRepo extends JpaRepository<TipoSala, Integer> {
}
