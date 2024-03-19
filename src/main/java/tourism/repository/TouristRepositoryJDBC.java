package tourism.repository;

import org.springframework.beans.factory.annotation.Value;
import tourism.model.TouristAttraction;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static tourism.manager.ConnectionManager.getConnection;

public class TouristRepositoryJDBC {
    //ved ikke om det er rigtigt det her
    @Value("${spring.datasource.url}")
    private String db_url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password")
    private String pw;

    public List<TouristAttraction> findAll(){
        List<TouristAttraction> attractions = new ArrayList<>();
        try (Connection con = getConnection(db_url, username, pw)) {
            String SQL = "SELECT * FROM attractions";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String city = rs.getString("city");
                attractions.add(new TouristAttraction(id, name, description, city));
            }
            return attractions;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
