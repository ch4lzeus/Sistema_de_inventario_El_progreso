package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Conexion;
import java.util.ArrayList;
import java.util.List;
import modelo.Categoria;

public class DaoCategorias {

    // Guardar categoría
    public boolean guardarCategoria(String categoria) {
        String sql = "INSERT INTO categorias (categoria) VALUES (?)";

        Conexion conn = new Conexion();
        try (Connection con = conn.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, categoria);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al guardar categoría: " + e.getMessage());
            return false;
        }
    }

    // Obtener todas las categorías
    public List<Categoria> obtenerCategorias() {
        List<Categoria> lista = new ArrayList<>();
        String sql = "SELECT * FROM categorias";

        Conexion conn = new Conexion();
        try (Connection con = conn.conectar(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Categoria c = new Categoria();
                c.setIdCategoria(rs.getInt("idCategoria"));
                c.setCategoria(rs.getString("categoria"));
                lista.add(c);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener categorías: " + e.getMessage());
        }

        return lista;
    }

    // Actualizar categoría
    public boolean actualizarCategoria(int idCategoria, String categoria) {
        String sql = "UPDATE categorias SET categoria=? WHERE idCategoria=?";

        Conexion conn = new Conexion();
        try (Connection con = conn.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, categoria);
            ps.setInt(2, idCategoria);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar categoría: " + e.getMessage());
            return false;
        }
    }

    // Eliminar categoría
    public boolean eliminarCategoria(int idCategoria) {
        String sql = "DELETE FROM categorias WHERE idCategoria=?";

        Conexion conn = new Conexion();
        try (Connection con = conn.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idCategoria);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar categoría: " + e.getMessage());
            return false;
        }
    }
}
