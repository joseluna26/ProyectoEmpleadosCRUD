package db.repositorys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import db.conexion.ConexionDB;
import interfaces.RepositoryInterface;
import models.Login;

public class LoginRepository implements RepositoryInterface<Login> {

    @Override
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

    @Override
    public List<Login> recuperarTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'recuperarTodos'");
    }

    @Override
    public void agregar(Login entidad) {
        try (Connection conexion = ConexionDB.obtenerConexion()) {
            String query = "INSERT INTO login VALUES(null, ?, ?, ?, ?);";
            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setString(1, entidad.getNombre());
                ps.setString(2, entidad.getEmail());
                ps.setString(3, entidad.getUsuario());
                ps.setString(4, entidad.getContrasenia());
                ps.executeUpdate();
                System.out.println("Se insertó " + entidad.getNombre() + " correctamente :)");
            } catch (Exception e) {
                System.out.println("No se insertó nada :(" + e);
            }
        } catch (Exception e) {

        }
    }

    @Override
    public void modificar(Login entidad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificar'");
    }

    @Override
    public void eliminar(Login entidad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
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
