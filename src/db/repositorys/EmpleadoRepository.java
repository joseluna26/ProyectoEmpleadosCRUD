package db.repositorys;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.conexion.ConexionDB;
import interfaces.RepositoryInterface;
import models.Empleado;
// import models.Genero;

public class EmpleadoRepository implements RepositoryInterface<Empleado> {

    @Override
    public Empleado recuperarId(Long id) {
        try (Connection conexion = ConexionDB.obtenerConexion()) {
            // Se desconecta cuando acaba el try
            String q = "SELECT * FROM empleados WHERE idEmpleado = ?";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(q)) {
                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                return dameEntidadResultSet(resultSet);
            } catch (Exception e) {

            }
        } catch (Exception e) {

        }
        return null;
    }

    @Override
    public List<Empleado> recuperarTodos() {
        try (Connection conexion = ConexionDB.obtenerConexion()) {
            String q = "SELECT * FROM empleados";
            try (Statement statement = conexion.createStatement();
                    ResultSet resultSet = statement.executeQuery(q)) {

                List<Empleado> lista = new ArrayList<>();
                while (resultSet.next()) {
                    Integer id = resultSet.getInt("idEmpleado");
                    String nombre = resultSet.getString("nombre");
                    Empleado em = new Empleado(id, nombre);
                    lista.add(em);
                }
                return lista;
            } catch (Exception e) {

            }
        } catch (Exception e) {
            
        }
        return null;
    }

    @Override
    public void agregar(Empleado entidad) {
        try (Connection conexion = ConexionDB.obtenerConexion()) {
            String query = "INSERT INTO empleados VALUES(null, ?, ?, ?, ?, ?, ?);";
            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setLong(1, entidad.getGenero().getId());
                ps.setString(2, entidad.getNombre());
                ps.setString(3, entidad.getDomicilio());
                ps.setString(4, entidad.getTelefono());
                ps.setString(5, entidad.getEmail());
                ps.setDate(6, (Date) entidad.getFechaNacimiento());
                ps.executeUpdate();
                System.out.println("Se insertó " + entidad.getNombre() + " correctamente :)");
            } catch (Exception e) {
                System.out.println("No se insertó al empleado :(" + e);
            }
        } catch (Exception e) {

        }
    }

    @Override
    public void modificar(Empleado entidad) {
        try (Connection conexion = ConexionDB.obtenerConexion()) {
            String q = "UPDATE empleados SET nombre = ? WHERE idEmpleado = ?";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(q)) {
                preparedStatement.setString(1, entidad.getNombre());
                preparedStatement.setLong(2, entidad.getId());
                preparedStatement.executeUpdate();
                System.out.println("Se modificó la info del Empleado");
            } catch (Exception e) {
                System.out.println("No se modificó el registro del Empleado" + e);
            }
        } catch (Exception e) {

        }
    }

    @Override
    public void eliminar(Empleado entidad) {
        try (Connection conexion = ConexionDB.obtenerConexion()) {
            String q = "DELETE FROM empleados WHERE idEmpleado = ?";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(q)) {

                preparedStatement.setLong(1, entidad.getId());
                preparedStatement.executeUpdate();
                System.out.println("Se eliminó el Empleado");
            } catch (Exception e) {
                System.out.println("No se leiminó registro de empleado");
            }
        } catch (Exception e) {

        }
    }

    private Empleado dameEntidadResultSet(ResultSet resultSet) {
        Integer idEmpleado = null;
        String nombre = null;

        try {
            while (resultSet.next()) {
                idEmpleado = resultSet.getInt("IdEmpleado");
                nombre = resultSet.getString("nombre");
            }
            return new Empleado(idEmpleado, nombre);
        } catch (Exception e) {
        }
        return null;
    }
}
