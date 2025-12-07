package controlador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Salida;
import modelo.DetalleSalida;
import modelo.Conexion;

public class DaoSalida {

    // ==================== GUARDAR SALIDA ====================
    public boolean guardarSalida(Salida salida) {
        String sql = "INSERT INTO salidas (numSalida, fecha, subtotal, igv, total) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = new Conexion().conectar(); PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, salida.getNumSalida());
            ps.setDate(2, salida.getFecha());
            ps.setDouble(3, salida.getSubtotal());
            ps.setDouble(4, salida.getIgv());
            ps.setDouble(5, salida.getTotal());

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    salida.setIdSalida(rs.getInt(1));
                    return true;
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al guardar la salida: " + e.getMessage());
        }

        return false;
    }

    // ==================== GUARDAR DETALLE + ACTUALIZAR STOCK ====================
    public boolean guardarDetallesSalida(DetalleSalida detalleSalida) {
        Connection con = null;

        try {
            con = new Conexion().conectar();
            con.setAutoCommit(false); // Iniciar transacción

            // 1. INSERTAR el detalle de salida
            String sqlDetalle = "INSERT INTO detallesalida (idSalida, idproducto, cantidad, importe) VALUES (?, ?, ?, ?)";
            try (PreparedStatement psDetalle = con.prepareStatement(sqlDetalle)) {
                psDetalle.setInt(1, detalleSalida.getIdSalida());
                psDetalle.setInt(2, detalleSalida.getIdProducto());
                psDetalle.setInt(3, detalleSalida.getCantidad());
                psDetalle.setDouble(4, detalleSalida.getImporte());
                psDetalle.executeUpdate();
            }

            // 2. RESTAR el stock del producto
            String sqlStock = "UPDATE productos SET stock = stock - ? WHERE idproducto = ?";
            try (PreparedStatement psStock = con.prepareStatement(sqlStock)) {
                psStock.setInt(1, detalleSalida.getCantidad());
                psStock.setInt(2, detalleSalida.getIdProducto());
                psStock.executeUpdate();
            }

            con.commit(); // Confirmar transacción
            return true;

        } catch (SQLException e) {
            System.out.println("Error al guardar el detalle de salida: " + e.getMessage());
            try {
                if (con != null) {
                    con.rollback(); // Revertir si hay error
                }
            } catch (SQLException ex) {
                System.out.println("Error al hacer rollback: " + ex.getMessage());
            }
            return false;
        } finally {
            try {
                if (con != null) {
                    con.setAutoCommit(true);
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
    }

    // ==================== ELIMINAR SALIDA + DEVOLVER STOCK ====================
    public boolean eliminarSalida(int idSalida) {
        Connection con = null;

        try {
            con = new Conexion().conectar();
            con.setAutoCommit(false);

            // 1. OBTENER los detalles antes de eliminar (para devolver el stock)
            List<DetalleSalida> detalles = obtenerDetallesSalida(idSalida);

            // 2. DEVOLVER el stock de cada producto
            String sqlStock = "UPDATE productos SET stock = stock + ? WHERE idproducto = ?";
            try (PreparedStatement psStock = con.prepareStatement(sqlStock)) {
                for (DetalleSalida detalle : detalles) {
                    psStock.setInt(1, detalle.getCantidad());
                    psStock.setInt(2, detalle.getIdProducto());
                    psStock.executeUpdate();
                }
            }

            // 3. ELIMINAR los detalles de salida
            String sqlDetalle = "DELETE FROM detallesalida WHERE idSalida = ?";
            try (PreparedStatement psDetalle = con.prepareStatement(sqlDetalle)) {
                psDetalle.setInt(1, idSalida);
                psDetalle.executeUpdate();
            }

            // 4. ELIMINAR la salida
            String sqlSalida = "DELETE FROM salidas WHERE idSalida = ?";
            try (PreparedStatement psSalida = con.prepareStatement(sqlSalida)) {
                psSalida.setInt(1, idSalida);
                psSalida.executeUpdate();
            }

            con.commit();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al eliminar la salida: " + e.getMessage());
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException ex) {
                System.out.println("Error al hacer rollback: " + ex.getMessage());
            }
            return false;
        } finally {
            try {
                if (con != null) {
                    con.setAutoCommit(true);
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
    }

    // ==================== MÉTODOS AUXILIARES ====================
    public String obtenerUltimoNumeroSalida() {
        String sql = "SELECT numSalida FROM salidas ORDER BY idSalida DESC LIMIT 1";

        try (Connection con = new Conexion().conectar(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return rs.getString("numSalida");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el último número de salida: " + e.getMessage());
        }
        return null;
    }

    public List<Salida> obtenerSalidas() {
        List<Salida> salidas = new ArrayList<>();
        String sql = "SELECT * FROM salidas";

        try (Connection con = new Conexion().conectar(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Salida salida = new Salida();
                salida.setIdSalida(rs.getInt("idSalida"));
                salida.setNumSalida(rs.getString("numSalida"));
                salida.setFecha(rs.getDate("fecha"));
                salida.setSubtotal(rs.getDouble("subtotal"));
                salida.setIgv(rs.getDouble("igv"));
                salida.setTotal(rs.getDouble("total"));
                salidas.add(salida);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener las salidas: " + e.getMessage());
        }

        return salidas;
    }

    public List<DetalleSalida> obtenerDetallesSalida(int idSalida) {
        List<DetalleSalida> detalles = new ArrayList<>();
        String sql = "SELECT * FROM detallesalida WHERE idSalida = ?";

        try (Connection con = new Conexion().conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idSalida);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    DetalleSalida detalle = new DetalleSalida();
                    detalle.setId(rs.getInt("id"));
                    detalle.setIdSalida(rs.getInt("idSalida"));
                    detalle.setIdProducto(rs.getInt("idproducto"));
                    detalle.setCantidad(rs.getInt("cantidad"));
                    detalle.setImporte(rs.getDouble("importe"));
                    detalles.add(detalle);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener los detalles de salida: " + e.getMessage());
        }

        return detalles;
    }

    // Método para obtener la cantidad de un detalle específico
    public int obtenerCantidadDetalle(int idSalida) {
        String sql = "SELECT cantidad FROM detallesalida WHERE idSalida = ? LIMIT 1";

        try (Connection con = new Conexion().conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idSalida);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("cantidad");
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener cantidad del detalle: " + e.getMessage());
        }

        return 0;
    }
}
