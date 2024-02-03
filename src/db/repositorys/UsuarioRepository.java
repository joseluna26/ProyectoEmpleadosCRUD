package db.repositorys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import db.conexion.ConexionDB;
import interfaces.RepositoryRegistro;
import models.Login;

public class UsuarioRepository implements RepositoryRegistro<Login> {
    
    // ConexionDB conexion = ConexionDB.getInstance();

    @Override
    public Login recuperarUsuario(String usuario) {
        try (Connection conexion = ConexionDB.obtenerConexion()) {
            // Se desconecta cuando acaba el try
            String q = "SELECT * FROM login WHERE usuario = ?";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(q)) {
                preparedStatement.setString(1, usuario);
                ResultSet resultSet = preparedStatement.executeQuery();
                return dameEntidadResultSet(resultSet);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se encuentra usuario", "Error de Captura!",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {

        }
        return null;
    }

    private Login dameEntidadResultSet(ResultSet resultSet) {
        String usuario = null;
        String pass = null;

        try {
            while (resultSet.next()) {
                usuario = resultSet.getString("usuario");
                pass = resultSet.getString("contrasenia");
            }
            System.out.println("Usuario desde UsuarioRepository: " + usuario);
            System.out.println("Contraseña desde UsuarioRepository: " + pass);
                
            if (usuario == null) {
                return new Login(usuario);
            } else {
                return new Login(usuario, pass);
            }
                
        } catch (Exception e) {
        }
        return null;
    }
}
