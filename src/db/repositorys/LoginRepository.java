package db.repositorys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import db.conexion.ConexionDB;
import helpers.Password;
import models.Login;


public class LoginRepository {
    public Login recuperarId(Long id) {
        
        try (Connection conexion = ConexionDB.obtenerConexion()) {
            // Se desconecta cuando acaba el try
            String q = "SELECT * FROM login WHERE id = ?";
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

    public List<Login> recuperarTodos() {
        try (Connection conexion = ConexionDB.obtenerConexion()) {
            String q = "SELECT * FROM login";
            try (Statement statement = conexion.createStatement();
                    ResultSet resultSet = statement.executeQuery(q)) {

                List<Login> lista = new ArrayList<>();
                while (resultSet.next()) {
                    Long id = resultSet.getLong("id");
                    String nombre = resultSet.getString("nombre");
                    Login lo = new Login(id, nombre);
                    lista.add(lo);
                }
                return lista;
            } catch (Exception e) {

            }
        } catch (Exception e) {

        }
        return null;
    }

    public void agregar(Login entidad) {
        try (Connection conexion = ConexionDB.obtenerConexion()) {
            String query = "INSERT INTO login VALUES(null, ?, ?, ?, ?);";
            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setString(1, entidad.getNombre());
                ps.setString(2, entidad.getEmail());
                ps.setString(3, entidad.getUsuario());
                String pass = entidad.getContrasenia();
                ps.setString(4, Password.encriptar(pass));
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Se insertó " + entidad.getNombre() + " correctamente", "éxito!",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se insertó el Registro", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {

        }
    }

    private Login dameEntidadResultSet(ResultSet resultSet) {
        Long id = null;
        String nombre = null;
        String email = null;
        String usuario = null;
        String contra = null;

        try {
            while (resultSet.next()) {
                id = resultSet.getLong("Id");
                nombre = resultSet.getString("nombre");
                email = resultSet.getString("email");
                usuario = resultSet.getString("usuario");
                contra = resultSet.getString("contrasenia");

            }
            return new Login(id, nombre, email, usuario, contra);
        } catch (Exception e) {
        }
        return null;
    }

}
