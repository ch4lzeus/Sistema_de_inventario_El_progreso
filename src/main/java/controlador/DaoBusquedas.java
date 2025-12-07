package controlador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.*;

public class DaoBusquedas {

    // ==================== BUSCAR ENTRADAS POR FECHA ====================
    public List<Entrada> buscarEntradasPorFecha(Date fecha) {
        List<Entrada> lista = new ArrayList<>();
        String sql = "SELECT * FROM entrada WHERE fecha = ?";

        try (Connection con = new Conexion().conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDate(1, fecha);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Entrada e = new Entrada();
                e.setIdEntrada(rs.getInt("identrada"));
                e.setIdProducto(rs.getInt("idproducto"));
                e.setStock(rs.getInt("stock"));
                e.setFecha(rs.getDate("fecha"));
                e.setIdProveedor(rs.getInt("idproveedor"));
                e.setPrecioE(rs.getDouble("precioE"));
                e.setPrecioV(rs.getDouble("precioV"));
                e.setTotal(rs.getDouble("total"));
                lista.add(e);
            }

        } catch (SQLException ex) {
            System.out.println("Error al buscar entradas por fecha: " + ex.getMessage());
        }

        return lista;
    }

    // ==================== BUSCAR PRODUCTOS POR NOMBRE ====================
    public List<Producto> buscarProductosPorNombre(String nombre) {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM productos WHERE nombre = ?";

        try (Connection con = new Conexion().conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Producto p = new Producto();
                p.setIdProducto(rs.getInt("idproducto"));
                p.setNombre(rs.getString("nombre"));
                p.setStock(rs.getInt("stock"));
                p.setIdCategoria(rs.getInt("idCategoria"));
                p.setPrecioV(rs.getDouble("precioV"));
                lista.add(p);
            }

        } catch (SQLException ex) {
            System.out.println("Error al buscar productos por nombre: " + ex.getMessage());
        }

        return lista;
    }

    // ==================== BUSCAR PROVEEDORES POR DNI ====================
    public List<Proveedor> buscarProveedoresPorDNI(String dni) {
        List<Proveedor> lista = new ArrayList<>();
        String sql = "SELECT * FROM proveedor WHERE documento = ?";

        try (Connection con = new Conexion().conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Proveedor p = new Proveedor();
                p.setIdProveedor(rs.getInt("idproveedor"));
                p.setNombre(rs.getString("nombre"));
                p.setApellido(rs.getString("apellido"));
                p.setDocumento(rs.getString("documento"));
                p.setRsocial(rs.getString("Rsocial"));
                p.setDireccion(rs.getString("direccion"));
                p.setTelefono(rs.getString("telefono"));
                p.setCorreo(rs.getString("correo"));
                lista.add(p);
            }

        } catch (SQLException ex) {
            System.out.println("Error al buscar proveedores por DNI: " + ex.getMessage());
        }

        return lista;
    }

    // ==================== BUSCAR SALIDAS POR FECHA ====================
    public List<Salida> buscarSalidasPorFecha(Date fecha) {
        List<Salida> lista = new ArrayList<>();
        String sql = "SELECT * FROM salidas WHERE fecha = ?";

        try (Connection con = new Conexion().conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDate(1, fecha);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Salida s = new Salida();
                s.setIdSalida(rs.getInt("idSalida"));
                s.setNumSalida(rs.getString("numSalida"));
                s.setFecha(rs.getDate("fecha"));
                s.setSubtotal(rs.getDouble("subtotal"));
                s.setIgv(rs.getDouble("igv"));
                s.setTotal(rs.getDouble("total"));
                lista.add(s);
            }

        } catch (SQLException ex) {
            System.out.println("Error al buscar salidas por fecha: " + ex.getMessage());
        }

        return lista;
    }
}