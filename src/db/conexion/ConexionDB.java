package db.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionDB {
    private static Connection conexion;
    private static String user = "root";
    private static String pass = "admin";
    private static String db = "crudempleados";
    private static int port = 3306;
    private static String url = "jdbc:mysql://localhost:" + port + "/" + db;

    // private static ConexionDB instancia;


    // ConexionDB conectar = ConexionDB.getInstance();

    private ConexionDB() {
        //!  Constructor privado patrón singleton
    }

    // public static ConexionDB getInstance() {

    //     if (instancia == null) {
    //         instancia = new ConexionDB();
    //     }
    //     return instancia;
    // }

    public static Connection obtenerConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, user, pass);
            // System.out.println("Se conectó a la DBF");
            return conexion;
        } catch (Exception ex) {
            // System.out.println("Error al conectar la base de datos");
        }
        return null;
    }

    // public static void cerrarConexion(Connection conexion) {
    //     try {
    //         if (conexion == null || conexion.isClosed())
    //             return;
    //         conexion.close();
    //     } catch (Exception e) {
    //         System.out.println("Error al cerrar la conexión");
    //     }
    // }
}
