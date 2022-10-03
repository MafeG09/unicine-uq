package co.edu.uniquindio.unicine.repo;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.entidades.Compra;
import co.edu.uniquindio.unicine.entidades.Cupon;
import co.edu.uniquindio.unicine.entidades.Persona;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepo extends JpaRepository <Cliente,Integer> {

    @Query("select c from Cliente c where c.correo = ?1")
    Cliente  obtener(String email);

    Cliente findByCorreo(String correo); //Consulta por inferencia

    @Query("select c from Cliente c where c.correo = :correo and c.password = :password")
    Cliente comprobarAutenticacion(String correo, String password);

    Cliente findByCorreoAndPassword(String correo, String password); //Consulta por inferencia

    @Query("select c from Cliente c where c.estado = :estado")
    List<Cliente> obtenerPorEstado(boolean estado, Pageable paginador);

    @Query("select com from Cliente cli, in (cli.compras) com where cli.correo = :correo")
    List<Compra> obtenerCompraIn(String correo);  //Compras de una persona dado su correo (Desde el cliente)

    @Query("select com from Cliente cli join cli.compras com where cli.correo = :correo")
    List<Compra> obtenerCompraJoin(String correo);

    @Query("select c from Compra c where c.cliente.correo = :correo")
    List<Compra> obtenerCompra(String correo); //Compras de una persona dado su correo (Desde la compra)

    @Query("select cup from Cliente cli join cli.cuponClientes cup where cli.correo = :correo")
    List<Cupon> obtenerCuponesJoin(String correo);

    @Query("select cli.cuponClientes from Cliente cli  where cli.correo = :correo")
    List<Cupon> obtenerCupones(String correo); //Se trae del cliente los cupones sin join

    @Query("select comp from Cliente cli join cli.compras comp")
    List<Compra> obtenerCompraClientes();//Compras de todos los clientes

    @Query("select cli.nombre, comp from Cliente cli left join cli.compras comp")
    List<Object[]> obtenerCompraClientesLeftJoin();//Compras de todos los clientes y muestra los clientes a pesar de no tener compras
                                                //Se retorna el nombre del cliente y la compra

}
