package Paquete;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.security.DigestException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServletResponse {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpRequest request, HttpServletResponse response)
            throws DigestException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String url = "jdbc:mysql://localhost:3306/Eva2";
        String user = "claudio";
        String dbPassword = "123456";

        try {

            Connection connection = DriverManager.getConnection(url, user, dbPassword);


            String consulta = "SELECT * FROM usuario WHERE username = ? AND password = ?";
            try (PreparedStatement statement = connection.prepareStatement(consulta)) {
                statement.setString(1, username);
                statement.setString(2, password);

                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {

                    response.sendRedirect("exito.jsp");
                } else {

                    response.sendRedirect("error.jsp");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();

            response.sendRedirect("error.jsp");
        }
    }
}
