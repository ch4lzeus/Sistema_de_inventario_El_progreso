package controlador;

import modelo.Proveedor;
import modelo.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoProveedor {

    public boolean guardarProveedor(Proveedor p) {
        String sql = "INSERT INTO proveedor (nombre, apellido, documento, Rsocial, direccion, telefono, correo) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        Conexion conn = new Conexion();

        try (Connection con = conn.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getNombre());
            ps.setString(2, p.getApellido());
            ps.setString(3, p.getDocumento());
            ps.setString(4, p.getRsocial());
            ps.setString(5, p.getDireccion());
            ps.setString(6, p.getTelefono());
            ps.setString(7, p.getCorreo());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("ERROR al guardar proveedor: " + e.getMessage());
            return false;
        }
    }

    public List<Proveedor> obtenerProveedores() {
        List<Proveedor> lista = new ArrayList<>();
        String sql = "SELECT * FROM proveedor";

        Conexion conn = new Conexion();

        try (Connection con = conn.conectar(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

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

        } catch (SQLException e) {
            System.out.println("ERROR al obtener proveedores: " + e.getMessage());
        }

        return lista;
    }

    public boolean actualizarProveedor(Proveedor p) {
        String sql = "UPDATE proveedor SET nombre=?, apellido=?, documento=?, Rsocial=?, direccion=?, telefono=?, correo=? "
                   + "WHERE idproveedor=?";

        Conexion conn = new Conexion();

        try (Connection con = conn.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getNombre());
            ps.setString(2, p.getApellido());
            ps.setString(3, p.getDocumento());
            ps.setString(4, p.getRsocial());
            ps.setString(5, p.getDireccion());
            ps.setString(6, p.getTelefono());
            ps.setString(7, p.getCorreo());
            ps.setInt(8, p.getIdProveedor());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("ERROR al actualizar proveedor: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarProveedor(int id) {
        String sql = "DELETE FROM proveedor WHERE idproveedor=?";

        Conexion conn = new Conexion();

        try (Connection con = conn.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("ERROR al eliminar proveedor: " + e.getMessage());
            return false;
        }
    }
}
