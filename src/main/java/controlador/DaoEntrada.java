package controlador;

import modelo.Conexion;
import modelo.Entrada;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoEntrada {

    // ==================== GUARDAR ENTRADA + SUMAR STOCK ====================
    public boolean guardarEntrada(Entrada e) {
        Connection con = null;

        try {
            con = new Conexion().conectar();
            con.setAutoCommit(false); // Iniciar transacción

            // 1. INSERTAR la entrada
            String sqlEntrada = "INSERT INTO entrada (idproducto, stock, fecha, idproveedor, precioE, precioV, total) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement psEntrada = con.prepareStatement(sqlEntrada)) {
                psEntrada.setInt(1, e.getIdProducto());
                psEntrada.setInt(2, e.getStock());
                psEntrada.setDate(3, e.getFecha());
                psEntrada.setInt(4, e.getIdProveedor());
                psEntrada.setDouble(5, e.getPrecioE());
                psEntrada.setDouble(6, e.getPrecioV());
                psEntrada.setDouble(7, e.getTotal());
                psEntrada.executeUpdate();
            }

            // 2. SUMAR el stock al producto
            String sqlActualizarStock = "UPDATE productos SET stock = stock + ? WHERE idproducto = ?";
            try (PreparedStatement psStock = con.prepareStatement(sqlActualizarStock)) {
                psStock.setInt(1, e.getStock());
                psStock.setInt(2, e.getIdProducto());
                psStock.executeUpdate();
            }

            con.commit(); // Confirmar transacción
            return true;

        } catch (SQLException ex) {
            System.out.println("Error al guardar entrada: " + ex.getMessage());
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException rollbackEx) {
                System.out.println("Error al hacer rollback: " + rollbackEx.getMessage());
            }
            return false;
        } finally {
            try {
                if (con != null) {
                    con.setAutoCommit(true);
                    con.close();
                }
            } catch (SQLException closeEx) {
                System.out.println("Error al cerrar conexión: " + closeEx.getMessage());
            }
        }
    }

    // ==================== ELIMINAR ENTRADA + RESTAR STOCK ====================
    public boolean eliminarEntrada(int idEntrada) {
        Connection con = null;

        try {
            con = new Conexion().conectar();
            con.setAutoCommit(false);

            // 1. OBTENER los datos de la entrada antes de eliminar
            String sqlObtener = "SELECT idproducto, stock FROM entrada WHERE identrada = ?";
            int idProducto = 0;
            int stockARestar = 0;

            try (PreparedStatement psObtener = con.prepareStatement(sqlObtener)) {
                psObtener.setInt(1, idEntrada);
                ResultSet rs = psObtener.executeQuery();

                if (rs.next()) {
                    idProducto = rs.getInt("idproducto");
                    stockARestar = rs.getInt("stock");
                } else {
                    return false; // No existe la entrada
                }
            }

            // 2. RESTAR el stock del producto (devolver a como estaba antes)
            String sqlRestarStock = "UPDATE productos SET stock = stock - ? WHERE idproducto = ?";
            try (PreparedStatement psRestar = con.prepareStatement(sqlRestarStock)) {
                psRestar.setInt(1, stockARestar);
                psRestar.setInt(2, idProducto);
                psRestar.executeUpdate();
            }

            // 3. ELIMINAR la entrada
            String sqlEliminar = "DELETE FROM entrada WHERE identrada = ?";
            try (PreparedStatement psEliminar = con.prepareStatement(sqlEliminar)) {
                psEliminar.setInt(1, idEntrada);
                psEliminar.executeUpdate();
            }

            con.commit();
            return true;

        } catch (SQLException ex) {
            System.out.println("Error al eliminar entrada: " + ex.getMessage());
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException rollbackEx) {
                System.out.println("Error al hacer rollback: " + rollbackEx.getMessage());
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

    // ==================== OBTENER ENTRADAS ====================
    public List<Entrada> obtenerEntradas() {
        List<Entrada> lista = new ArrayList<>();
        String sql = "SELECT * FROM entrada";

        try (Connection con = new Conexion().conectar(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

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
            System.out.println("Error al obtener entradas: " + ex.getMessage());
        }

        return lista;
    }
}
