package Paquete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/eva2";
        String user = "claudio";
        String password = "123456";

        try {
            
            Connection connection = DriverManager.getConnection(url, user, password);

           
            String consulta = "SELECT u.username, u.password, p.* FROM usuario u JOIN persona p ON u.rut = p.rut WHERE u.username = ?";
            String usernameConsulta = "tuusuario"; 

            try (PreparedStatement statement = connection.prepareStatement(consulta)) {
                statement.setString(1, usernameConsulta);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    
                    Persona persona = new Persona();
                    persona.setRut(resultSet.getString("rut"));
                    persona.setNombre(resultSet.getString("nombre"));
                    persona.setApellido(resultSet.getString("apellido"));
                    persona.setTelefono(resultSet.getString("telefono"));
                    persona.setFechaIngreso(resultSet.getDate("fechaIngreso").toLocalDate());

                    Usuario usuario = new Usuario();
                    usuario.setUsername(resultSet.getString("username"));
                    usuario.setPassword(resultSet.getString("password"));
                    usuario.setPersona(persona);

                    System.out.println(usuario);
                } else {
                    System.out.println("Usuario no encontrado.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
