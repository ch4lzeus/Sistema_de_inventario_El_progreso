package controlador;

import java.sql.*;
import modelo.Conexion;

public class DaoEstadisticas {

    // ==================== CONTAR ADMINISTRADORES ====================
    public int contarAdministradores() {
        String sql = "SELECT COUNT(*) as total FROM usuarios WHERE tipoUsuario = 'Administrador'";
        
        try (Connection con = new Conexion().conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return rs.getInt("total");
            }

        } catch (SQLException e) {
            System.out.println("Error al contar administradores: " + e.getMessage());
        }

        return 0;
    }

    // ==================== CONTAR USUARIOS (TODOS) ====================
    public int contarUsuarios() {
        String sql = "SELECT COUNT(*) as total FROM usuarios";
        
        try (Connection con = new Conexion().conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return rs.getInt("total");
            }

        } catch (SQLException e) {
            System.out.println("Error al contar usuarios: " + e.getMessage());
        }

        return 0;
    }

    // ==================== CONTAR ENTRADAS ====================
    public int contarEntradas() {
        String sql = "SELECT COUNT(*) as total FROM entrada";
        
        try (Connection con = new Conexion().conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return rs.getInt("total");
            }

        } catch (SQLException e) {
            System.out.println("Error al contar entradas: " + e.getMessage());
        }

        return 0;
    }

    // ==================== CONTAR PROVEEDORES ====================
    public int contarProveedores() {
        String sql = "SELECT COUNT(*) as total FROM proveedor";
        
        try (Connection con = new Conexion().conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return rs.getInt("total");
            }

        } catch (SQLException e) {
            System.out.println("Error al contar proveedores: " + e.getMessage());
        }

        return 0;
    }

    // ==================== CONTAR CATEGORÍAS ====================
    public int contarCategorias() {
        String sql = "SELECT COUNT(*) as total FROM categorias";
        
        try (Connection con = new Conexion().conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return rs.getInt("total");
            }

        } catch (SQLException e) {
            System.out.println("Error al contar categorías: " + e.getMessage());
        }

        return 0;
    }

    // ==================== CONTAR SALIDAS ====================
    public int contarSalidas() {
        String sql = "SELECT COUNT(*) as total FROM salidas";
        
        try (Connection con = new Conexion().conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return rs.getInt("total");
            }

        } catch (SQLException e) {
            System.out.println("Error al contar salidas: " + e.getMessage());
        }

        return 0;
    }

    // ==================== MÉTODO PARA CARGAR TODAS LAS ESTADÍSTICAS ====================
    public void cargarTodasLasEstadisticas(
            javax.swing.JLabel lblAdministradores,
            javax.swing.JLabel lblUsuarios,
            javax.swing.JLabel lblEntradas,
            javax.swing.JLabel lblProveedores,
            javax.swing.JLabel lblCategorias,
            javax.swing.JLabel lblSalidas) {
        
        lblAdministradores.setText(String.valueOf(contarAdministradores()));
        lblUsuarios.setText(String.valueOf(contarUsuarios()));
        lblEntradas.setText(String.valueOf(contarEntradas()));
        lblProveedores.setText(String.valueOf(contarProveedores()));
        lblCategorias.setText(String.valueOf(contarCategorias()));
        lblSalidas.setText(String.valueOf(contarSalidas()));
    }
}