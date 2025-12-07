package controlador;

import modelo.Conexion;
import java.sql.*;

public class LoginDAO {

    private Connection connection;

    // Constructor que obtiene la conexión desde la clase Conexion
    public LoginDAO() {
        Conexion conexion = new Conexion();
        this.connection = conexion.conectar();
    }

    // Método para verificar si las credenciales son correctas
    public boolean validarUsuario(String usuario, String contrasena) {
        boolean esValido = false;
        String sql = "SELECT * FROM usuarios WHERE usuario = ? AND pass = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, usuario);
            stmt.setString(2, contrasena);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                esValido = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return esValido;
    }

    // Método para obtener el tipo de rol de un usuario
    public String obtenerRol(String usuario) {
        String rol = "";
        String sql = "SELECT tipoUsuario FROM usuarios WHERE usuario = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, usuario);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                rol = rs.getString("tipoUsuario");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rol;
    }
}
