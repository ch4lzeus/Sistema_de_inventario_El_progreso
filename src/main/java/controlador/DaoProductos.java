package controlador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Categoria;
import modelo.Conexion;
import modelo.Producto;

public class DaoProductos {

    // GUARDAR PRODUCTO
    public boolean guardarProducto(String nombre, int stock, int idCategoria, double precioV) {

        String sql = "INSERT INTO productos (nombre, stock, idCategoria, precioV) VALUES (?, ?, ?, ?)";

        Conexion conn = new Conexion();

        try (Connection con = conn.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ps.setInt(2, stock);
            ps.setInt(3, idCategoria);
            ps.setDouble(4, precioV);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al guardar producto: " + e.getMessage());
            return false;
        }
    }

    // LISTAR PRODUCTOS
    public List<Producto> obtenerProductos() {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM productos";

        Conexion conn = new Conexion();

        try (Connection con = conn.conectar(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Producto p = new Producto();
                p.setIdProducto(rs.getInt("idproducto"));
                p.setNombre(rs.getString("nombre"));
                p.setStock(rs.getInt("stock"));
                p.setIdCategoria(rs.getInt("idCategoria"));
                p.setPrecioV(rs.getDouble("precioV"));

                lista.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener productos: " + e.getMessage());
        }

        return lista;
    }

    // ACTUALIZAR
    public boolean actualizarProducto(int id, String nombre, int stock, int idCategoria, double precioV) {

        String sql = "UPDATE productos SET nombre=?, stock=?, idCategoria=?, precioV=? WHERE idproducto=?";

        Conexion conn = new Conexion();

        try (Connection con = conn.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ps.setInt(2, stock);
            ps.setInt(3, idCategoria);
            ps.setDouble(4, precioV);
            ps.setInt(5, id);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar producto: " + e.getMessage());
            return false;
        }
    }

    // ELIMINAR
    public boolean eliminarProducto(int id) {
        String sql = "DELETE FROM productos WHERE idproducto=?";

        Conexion conn = new Conexion();

        try (Connection con = conn.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar producto: " + e.getMessage());
            return false;
        }
    }

    // DAO PARA OBTENER CATEGORÍAS Y CARGAR EN EL COMBO
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

}
