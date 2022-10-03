package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.entidades.Compra;
import co.edu.uniquindio.unicine.entidades.Cupon;
import co.edu.uniquindio.unicine.repo.ClienteRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.jdbc.Sql;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClienteTest {

    @Autowired
    private ClienteRepo clienteRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrar() {

        //ArrayList<String> telefonos = new ArrayList<>();
        //telefonos.add("312258");

        String[] tels = new String[]{"36589", "12596"};
        Cliente cliente = new Cliente("Pedro", "pedro@mail.com", "1234", "ruta", Arrays.asList(tels));
        Cliente cliente1 = clienteRepo.save(cliente);
        Assertions.assertNotNull(cliente1); //Verifica que el nombre sea el del cliente
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar(){

        Cliente buscado = clienteRepo.findById(1).orElse(null);
        clienteRepo.delete(buscado);
        Assertions.assertNull(clienteRepo.findById(1).orElse(null));

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar(){

        Cliente guardado = clienteRepo.findById(4).orElse(null);
        guardado.setCorreo("pepe_Nuevo@email.com");
        Cliente nuevo = clienteRepo.save(guardado);
        Assertions.assertEquals("pepe_Nuevo@email.com", nuevo.getCorreo());

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtener(){

        Optional<Cliente> buscado = clienteRepo.findById(4);
        Assertions.assertNotNull(buscado.orElse(null));


    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){

       List<Cliente> lista = clienteRepo.findAll();
       lista.forEach(System.out::println); //Paradigma programacion funcional
    }
////////////////////////////////////////////////////////////////////////////////////
    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerPorCorreo() {
        //CONSULTA POR MÉTODO OBTENER EN CLIENTEREPO
        //Cliente cliente = clienteRepo.obtener("luisa@email.com");
        //System.out.println(cliente);

        //CONSULTA POR INFERENCIA DESDE CLIENTEREPO
        Cliente cliente = clienteRepo.findByCorreo("luis@email.com");
        Assertions.assertNotNull(cliente);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void comprobarAutenticacion() {

        //CONSULTA MEDIANTE METODO E INFERENCIA DESDE CLIENTEREPO
        Cliente cliente = clienteRepo.findByCorreoAndPassword("luisa@email.com", "7u6t");
        //System.out.println(cliente);
        Assertions.assertNotNull(cliente);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void paginador(){

        List<Cliente> lista = clienteRepo.findAll(PageRequest.of(2,2)).toList(); //toList lo convierte en una lista
        lista.forEach(System.out::println); //Paradigma programacion funcional
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void paginadorEstado(){

        List<Cliente> lista = clienteRepo.obtenerPorEstado(true, PageRequest.of(0,3));//toList lo convierte en una lista
        lista.forEach(System.out::println); //Paradigma programacion funcional
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void ordenarRegistros(){

        List<Cliente> lista = clienteRepo.findAll(Sort.by("nombre").descending()); //Ordena. El .descending orden descendentemente
        //List<Cliente> lista = clienteRepo.findAll(PageRequest.of(0,3 , Sort.by("nombre"))).toList(); //ODENA Y PAGINA
        lista.forEach(System.out::println); //Paradigma programacion funcional
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerCompra(){

        List<Compra> compras = clienteRepo.obtenerCompraIn("pepe@email.com");
        compras.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerCupones(){

        List<Cupon> cupones = clienteRepo.obtenerCupones("pepe@email.com");
        //cupones.forEach(System.out::println);
        Assertions.assertEquals(1, cupones.size()); //Numero de cupones que le corresponden a ese email
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerComprasPorCliente() {

        //List<Compra> compras = clienteRepo.obtenerCompraClientes();
        List<Object[]> compras = clienteRepo.obtenerCompraClientesLeftJoin();
        compras.forEach( o ->
                System.out.println(o[0] + " , " + o[1])); //Si en la colsutas hay mas aspectos separados por , se concatenan mas posiciones
    }


}
