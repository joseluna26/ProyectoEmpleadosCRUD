package db.repositorys;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import db.conexion.ConexionDB;
import interfaces.RepositoryInterface;
import models.Empleado;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'recuperarTodos'");
    }

    @Override
    public void agregar(Empleado entidad) {
        try (Connection conexion = ConexionDB.obtenerConexion()) {
            String query = "INSERT INTO empleados VALUES(null, ?, ?, ?, ?, ?, ?);";
            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setString(1, entidad.getNombre());
                ps.setString(2, entidad.getDomicilio());
                ps.setString(3, entidad.getTelefono());
                ps.setString(4, entidad.getEmail());
                ps.setDate(5, (Date) entidad.getFechaNacimiento());
                ps.setLong(6, entidad.getGenero().getId());
                ps.executeUpdate();
                System.out.println("Se insertó " + entidad.getNombre() + " correctamente :)");
            } catch (Exception e) {
                System.out.println("No se insertó nada :(" + e);
            }
        } catch (Exception e) {

        }

    }

    @Override
    public void modificar(Empleado entidad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificar'");
    }

    @Override
    public void eliminar(Empleado entidad) {
        try (Connection conexion = ConexionDB.obtenerConexion()) {
            String q = "DELETE FROM empleados WHERE idEmpleado = ?";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(q)) {

                preparedStatement.setLong(1, entidad.getId());
                preparedStatement.executeUpdate();
                System.out.println("Se eliminó el registro");
            } catch (Exception e) {
                System.out.println("No se leiminó nada: " + e);
            }
        } catch (Exception e) {

        }
    }

    private Empleado dameEntidadResultSet(ResultSet resultSet) {
        Long idEmpleado = null;
        String nombre = null;

        try {
            while (resultSet.next()) {
                idEmpleado = resultSet.getLong("IdEmpleado");
                nombre = resultSet.getString("nombre");
            }
            return new Empleado(idEmpleado, nombre);
        } catch (Exception e) {
        }
        return null;
    }
}
