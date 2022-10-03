package co.edu.uniquindio.unicine.repo;

import co.edu.uniquindio.unicine.dto.FuncionDTO;
import co.edu.uniquindio.unicine.entidades.Funcion;
import co.edu.uniquindio.unicine.entidades.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionRepo extends JpaRepository<Funcion, Integer> {

    @Query("select f.pelicula.nombre from Funcion f where f.codigo = :codigoFuncion")
    String obtenerNombrePelicula(Integer codigoFuncion);

    @Query("select f.pelicula from Funcion f ") //Devuelve todas las peliculas que esten dentro de las funciones
    List<Pelicula> obtenerPeliculas();

    @Query("select new co.edu.uniquindio.unicine.dto.FuncionDTO(f.pelicula.nombre, f.pelicula.estado, f.pelicula.url_imagen, f.sala.codigo, f.sala.teatro.direccion, f.sala.teatro.ciudad.nombre, f.horario) from Funcion f where f.pelicula.codigo = :codigoPelicula ")
        //Consulta para retornar la lista de funciones de una pelicula
        //Retorna nombre,estado,imagen,#Sala,direccion,ciudad y horario de la pelicula
    List<FuncionDTO> listarFunciones(Integer codigoPelicula);
}
