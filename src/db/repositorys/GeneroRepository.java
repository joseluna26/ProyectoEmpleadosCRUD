package db.repositorys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.conexion.ConexionDB;
import interfaces.RepositoryInterface;
import models.Genero;

public class GeneroRepository implements RepositoryInterface<Genero> {
    @Override
    public Genero recuperarId(Long i) {
        try (Connection conexion = ConexionDB.obtenerConexion()) {
            String q = "SELECT * FROM generos WHERE idGenero = ?";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(q)) {
                preparedStatement.setLong(1, i);
                ResultSet resultSet = preparedStatement.executeQuery();
                return dameEntidadResultSet(resultSet);
            } catch (Exception e) {

            }
        } catch (Exception e) {

        }
        return null;
    }

    @Override
    public List<Genero> recuperarTodos() {
        try (Connection conexion = ConexionDB.obtenerConexion()) {
            String q = "SELECT * FROM generos";
            try (Statement statement = conexion.createStatement();
                    ResultSet resultSet = statement.executeQuery(q)) {

                List<Genero> lista = new ArrayList<>();
                while (resultSet.next()) {
                    Long id = resultSet.getLong("idGenero");
                    String nombre = resultSet.getString("nombre");
                    Genero g = new Genero(id, nombre);
                    lista.add(g);
                }
                return lista;
            } catch (Exception e) {

            }

        } catch (Exception e) {

        }
        return null;

    }

    @Override
    public void agregar(Genero entidad) {
        try (Connection conexion = ConexionDB.obtenerConexion()) {
            // Se desconecta cuando acaba el try
            String q = "INSERT INTO generos VALUES(null, ?);";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(q)) {
                preparedStatement.setString(1, entidad.getNombre());
                preparedStatement.executeUpdate();
                System.out.println("Se insertó " + entidad.getNombre() + " correctamente :)");
            } catch (Exception e) {
                System.out.println("No se insertó nada :(");
            }
        } catch (Exception e) {

        }
    }

    @Override
    public void modificar(Genero entidad) {
        try (Connection conexion = ConexionDB.obtenerConexion()) {
            String q = "UPDATE generos SET nombre = ? WHERE idGenero = ?";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(q)) {
                preparedStatement.setString(1, entidad.getNombre());
                preparedStatement.setLong(2, entidad.getId());
                preparedStatement.executeUpdate();
            } catch (Exception e) {

            }
        } catch (Exception e) {

        }
    }

    @Override
    public void eliminar(Genero entidad) {
        try (Connection conexion = ConexionDB.obtenerConexion()) {
            String q = "DELETE FROM generos WHERE idGenero = ?";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(q)) {

                preparedStatement.setLong(1, entidad.getId());
                preparedStatement.executeUpdate();
            } catch (Exception e) {

            }
        } catch (Exception e) {

        }
    }

    private Genero dameEntidadResultSet(ResultSet resultSet) {
        Long idGenero = null;
        String nombre = null;

        try {
            while (resultSet.next()) {
                idGenero = resultSet.getLong("idGenero");
                nombre = resultSet.getString("nombre");
            }
            return new Genero(idGenero, nombre);
        } catch (Exception e) {
        }
        return null;
    }
}
