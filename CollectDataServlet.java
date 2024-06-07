import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/collect_data")
public class CollectDataServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String waterBody = request.getParameter("water_body");
        String dataType = request.getParameter("data_type");
        String date = request.getParameter("date");
        
        // Use your JDBC connection to insert data into the appropriate table
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/water_quality_db", "username", "password");
            
            String sql = "INSERT INTO " + waterBody.toUpperCase() + " (data_type, date) VALUES (?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, dataType);
            stmt.setString(2, date);
            
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                response.sendRedirect("index.html?message=Data collected successfully");
            } else {
                response.sendRedirect("index.html?message=Failed to collect data");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("index.html?message=Error: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
