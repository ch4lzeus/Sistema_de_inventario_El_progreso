package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Conexion;
import java.util.ArrayList;
import java.util.List;
import modelo.Usuario;

public class DaoUsuarios {

    // Método para guardar un nuevo usuario
    public boolean guardarUsuario(String nombre, String apellido, String documento, String direccion,
            String telefono, String tipoUsuario, String usuario, String pass) {
        String sql = "INSERT INTO usuarios (nombre, apellido, documento, direccion, telefono, tipoUsuario, usuario, pass) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        // Crear una instancia de la conexión
        Conexion conn = new Conexion();
        try (Connection con = conn.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            // Asignar los parámetros de la consulta SQL
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, documento);
            ps.setString(4, direccion);
            ps.setString(5, telefono);
            ps.setString(6, tipoUsuario);
            ps.setString(7, usuario);
            ps.setString(8, pass);

            // Ejecutar la consulta
            int filasAfectadas = ps.executeUpdate();

            // Si las filas afectadas es mayor a 0, el registro fue exitoso
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.out.println("Error al guardar el usuario: " + e.getMessage());
            return false;
        }
    }

    // Método para obtener todos los usuarios desde la base de datos
    public List<Usuario> obtenerUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios"; // Consulta para obtener todos los usuarios

        Conexion conn = new Conexion();
        try (Connection con = conn.conectar(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            // Procesar los resultados y agregar los usuarios a la lista
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setDocumento(rs.getString("documento"));
                usuario.setDireccion(rs.getString("direccion"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setTipoUsuario(rs.getString("tipoUsuario"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setPass(rs.getString("pass"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los usuarios: " + e.getMessage());
        }

        return usuarios;  // Devolvemos la lista de usuarios
    }

    // Método para actualizar un usuario
    public boolean actualizarUsuario(int idUsuario, String nombre, String apellido, String documento, String direccion,
            String telefono, String tipoUsuario, String usuario, String pass) {

        // Consulta SQL para actualizar los datos del usuario
        String sql = "UPDATE usuarios SET nombre = ?, apellido = ?, documento = ?, direccion = ?, telefono = ?, "
                + "tipoUsuario = ?, usuario = ?, pass = ? WHERE idUsuario = ?";

        // Crear una instancia de la conexión
        Conexion conn = new Conexion();

        // Usar el try-with-resources para asegurar que la conexión y el PreparedStatement se cierren correctamente
        try (Connection con = conn.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            // Asignar los parámetros de la consulta SQL
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, documento);
            ps.setString(4, direccion);
            ps.setString(5, telefono);
            ps.setString(6, tipoUsuario);
            ps.setString(7, usuario);
            ps.setString(8, pass);
            ps.setInt(9, idUsuario);  // Establecer el ID del usuario a actualizar

            // Ejecutar la consulta
            int filasAfectadas = ps.executeUpdate();

            // Si las filas afectadas es mayor a 0, la actualización fue exitosa
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar el usuario: " + e.getMessage());
            return false;
        }
    }

    // Método para eliminar un usuario
    public boolean eliminarUsuario(int idUsuario) {
        String sql = "DELETE FROM usuarios WHERE idUsuario = ?";  // Consulta SQL para eliminar un usuario

        Conexion conn = new Conexion();
        try (Connection con = conn.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            // Establecer el parámetro de la consulta SQL (ID del usuario)
            ps.setInt(1, idUsuario);

            // Ejecutar la consulta
            int filasAfectadas = ps.executeUpdate();

            // Si las filas afectadas es mayor a 0, la eliminación fue exitosa
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar el usuario: " + e.getMessage());
            return false;
        }
    }

}
