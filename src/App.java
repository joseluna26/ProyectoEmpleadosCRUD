// import java.util.List;

import db.repositorys.EmpleadoRepository;
// import db.repositorys.GeneroRepository;
import models.Empleado;
// import models.Genero;

public class App {
    public static void main(String[] args) throws Exception {
        // GeneroRepository generoRepository = new GeneroRepository();
        // Genero g1 = new Genero(null, "Drag queen");
        // Genero g2 = new Genero(null, "Masculino");

        // generoRepository.agregar(g1);
        // List<Genero> lista = generoRepository.recuperarTodos();

        // for (Genero genero : lista) {
        // System.out.println("nombre: " + genero.getNombre());
        // }

        // Genero g = generoRepository.recuperarId(1L);
        // g.setNombre("M");
        // generoRepository.modificar(g);

        // g = generoRepository.recuperarId(1L);
        // System.out.println(g.getId());
        // System.out.println(g.getNombre());

        // generoRepository.eliminar(g);

        // Agregar Empleado
        // EmpleadoRepository empleadoRepository = new EmpleadoRepository();
        // Genero g = generoRepository.recuperarId(1L);
        // System.out.println(g);
        // Empleado em = new Empleado(null, "Alberto Martínez", "Calle 1", "1111111111",
        // "alberto@gmail.com", null, g);
        // empleadoRepository.agregar(em);

        // Eliminar Empleado//
        EmpleadoRepository empleadoRepository = new EmpleadoRepository();
        Empleado em = empleadoRepository.recuperarId(1L);
        empleadoRepository.eliminar(em);
        System.out.println(em);
    }
}
