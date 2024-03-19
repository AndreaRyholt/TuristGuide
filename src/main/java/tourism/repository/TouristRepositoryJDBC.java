package tourism.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import tourism.model.Tags;
import tourism.model.TouristAttraction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static tourism.manager.ConnectionManager.getConnection;

@Repository
public class TouristRepositoryJDBC {
    //ved ikke om det er rigtigt det her
    //HUSK AT HARDCODE DA DET ANDET IKKE VIRKER LIGE NU
    //@Value("${spring.datasource.url}")
    private String db_url = "jdbc:mysql://localhost:3306/turist_guide";


    @Value("${spring.datasource.username}")
    private String  username;

    @Value("${spring.datasource.password")
    private String pw;

    public List<TouristAttraction> findAll(){
        List<TouristAttraction> attractions = new ArrayList<>();
        try (Connection con = getConnection(db_url, username, pw)) {
            String SQL = "SELECT * FROM attractions";
            String SQL2 = "SELECT TAG_NAME FROM ATTRACTION_TAG WHERE ATTRACTIONS_ID = ?";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String city = rs.getString("city");
                PreparedStatement preparedStatement = con.prepareStatement(SQL2);
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                List<Tags> tags = (List<Tags>) resultSet; //TODO LAV METODE SOM LAVER DET OM TIL ENUM
                attractions.add(new TouristAttraction(name, description, city, tags));
            }
            return attractions;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<TouristAttraction> getAttractionFromTag(Tags enumTag) {
        return null;
    }

    public TouristAttraction postAttraction(TouristAttraction attraction) {
        return null;
    }

    public TouristAttraction updateAttraction(TouristAttraction attraction) {
        return null;
    }

    public TouristAttraction deleteAttraction(String name) {
        return null;
    }

    public TouristAttraction findName(String name) {
        return null;
    }

    public TouristAttraction findUrlName(String urlName) {
        return null;
    }

    public List<String> getCityList() {
        return null;
    }
}
