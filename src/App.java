
// import db.repositorys.EmpleadoRepository;
// import java.util.List;

// import db.repositorys.LoginRepository;
// import db.repositorys.GeneroRepository;
// import models.Empleado;
// import models.Genero;
// import models.Login;


import javax.swing.SwingUtilities;

// import screens.FraEmpleados;
import screens.FrmLogin;
// import screens.FraRegistro;

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

        // GeneroRepository generoRepository = new GeneroRepository();
        // Genero g = generoRepository.recuperarId(1L);
        // g.setNombre("M");
        // generoRepository.modificar(g);

        // Genero g = generoRepository.recuperarId(1L);
        // System.out.println(g.getId());
        // System.out.println(g.getNombre());
        // generoRepository.eliminar(g);

        // Agregar Empleado //
        // EmpleadoRepository empleadoRepository = new EmpleadoRepository();
        // Genero g = generoRepository.recuperarId(1L);
        // System.out.println(g);
        // Empleado em = new Empleado(null, "Alberto Martínez", "Calle 1", "1111111111",
        // "alberto@gmail.com", null, g);
        // empleadoRepository.agregar(em);

        // Eliminar Empleado //
        // EmpleadoRepository empleadoRepository = new EmpleadoRepository();
        // Empleado em = empleadoRepository.recuperarId(1L);
        // empleadoRepository.eliminar(em);
        // System.out.println(em);

        // Modificar Empleado //
        // EmpleadoRepository empleadoRepository = new EmpleadoRepository();
        // Empleado em = empleadoRepository.recuperarId(1L);
        // em.setNombre("Carlos");
        // empleadoRepository.modificar(em);

        // Recuperar empleados //
        // EmpleadoRepository empleadoRepository = new EmpleadoRepository();
        // List<Empleado> lista = empleadoRepository.recuperarTodos();
        // for (Empleado empleado : lista) {
        // System.out.println("nombre: " + empleado.getNombre());
        // }

        // Agregar Login //
        // LoginRepository loginRepository = new LoginRepository();
        // Login l1 = new Login(null, "Manuel", "manuel@gmail.com", "manuel_luna",
        // "641016");
        // Login l2 = new Login(null, "Luis", "luis@gmail.com", "jluna", "123456");
        // Login l3 = new Login(null, "Carlos", "carlos@gmail.com", "lunaC", "631020");
        // loginRepository.agregar(l1);
        // loginRepository.agregar(l2);
        // loginRepository.agregar(l3);

        // Eliminar Login //
        // LoginRepository loginRepository = new LoginRepository();
        // Login lo = loginRepository.recuperarId(1L);
        // loginRepository.eliminar(lo);
        // System.out.println(lo);

        // Modificar Login //
        // LoginRepository loginRepository = new LoginRepository();
        // Login lo = loginRepository.recuperarId(1L);
        // lo.setNombre("Manuel Luna Velázquez");
        // lo.setEmail("lunav64@gmail.com");
        // lo.setUsuario("lunavm");
        // loginRepository.modificar(lo);

        // Recuperar login TODOS //
        // LoginRepository loginRepository = new LoginRepository();
        // List<Login> lista = loginRepository.recuperarTodos();
        // for (Login login : lista) {
        // System.out.println("nombre: " + login.getNombre());
        // }

        
        SwingUtilities.invokeLater(() -> new FrmLogin());
        // SwingUtilities.invokeLater(() -> new FraRegistro());
        // SwingUtilities.invokeLater(() -> new FraEmpleados());

    }
}
