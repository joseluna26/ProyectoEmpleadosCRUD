package db.repositorys;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import db.conexion.ConexionDB;
import interfaces.RepositoryInterface;
import models.Empleado;
import models.Genero;

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
                // System.out.println("Se insertó " + entidad.getNombre() + " correctamente :)");
                JOptionPane.showMessageDialog(null, "Se insertó " + entidad.getNombre() + " correctamente", "éxito!", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se insertó al empleado", "Error!", JOptionPane.ERROR_MESSAGE);

            }
        } catch (Exception e) {

        }
    }

    @Override
    public void modificar(Empleado entidad) {
        try (Connection conexion = ConexionDB.obtenerConexion()) {
            String q = "UPDATE empleados SET id_genero = ?, nombre = ?, domicilio = ?, telefono = ?, email = ?, fecha_nacimiento = ?  WHERE idEmpleado = ?";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(q)) {
                
                preparedStatement.setLong(1, entidad.getGenero().getId());
                preparedStatement.setString(2, entidad.getNombre());
                preparedStatement.setString(3, entidad.getDomicilio());
                preparedStatement.setString(4, entidad.getTelefono());
                preparedStatement.setString(5, entidad.getEmail());
                preparedStatement.setDate(6, (Date) entidad.getFechaNacimiento());
                preparedStatement.setLong(7, entidad.getId());

                
                preparedStatement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Se Modificó el registro de " + entidad.getNombre() + " correctamente", "éxito!", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se modificó el registro del Empleado" + e, "Error!", JOptionPane.ERROR_MESSAGE);
                // System.out.println("Nombre: " +entidad.getNombre()+" " + entidad.getId());
                // System.out.println("No se modificó el registro del Empleado" + e);
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
                JOptionPane.showMessageDialog(null, "Se eliminó el registro " + entidad.getNombre() + " correctamente", "éxito!", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se eliminó el registro del empleado", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {

        }
    }

    private Empleado dameEntidadResultSet(ResultSet resultSet) {
        Integer idEmpleado = null;
        String nombre = null;
        String domicilio = null;
        String telefono = null;
        String email = null;
        Date fecnac = null;
        Genero genero = null;

        try {
            while (resultSet.next()) {
                idEmpleado = resultSet.getInt("IdEmpleado");
                nombre = resultSet.getString("nombre");
                domicilio = resultSet.getString("domicilio");
                telefono = resultSet.getString("telefono");
                email = resultSet.getString("email");
                fecnac = resultSet.getDate("fecha_nacimiento");
                // genero = resultSet.getLong("id_Genero");
                
            }
            return new Empleado(idEmpleado, nombre, domicilio, telefono, email, fecnac, genero);
        } catch (Exception e) {
        }
        return null;
    }
}
