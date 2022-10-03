package co.edu.uniquindio.unicine.repo;

import co.edu.uniquindio.unicine.entidades.Compra;
import co.edu.uniquindio.unicine.entidades.Entrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepo extends JpaRepository<Compra, Integer> {

   @Query("select e from Compra c join c.entradas e where c.codigo = :codigo")
   List<Entrada> obtenerEntradas(Integer codigo); //Dado el id de una compra retornar las entradas asociadas
}
