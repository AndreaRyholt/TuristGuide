package tourism.repository;

import org.springframework.stereotype.Repository;
import tourism.manager.ConnectionManager;
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
    // -----  FJERN FINAL FRA DE NEDENUNDER HVIS VI FÅR DET TIL AT VIRKE UDEN HARDCODE ------
    //@Value("$spring.datasource.url}")
    private final String db_url = "jdbc:mysql://localhost:3306/turist_guide";


    //@Value("${spring.datasource.username}")
    private String username="root"; //SKRIV USERNAME

    //@Value("${spring.datasource.password")
    private String pw="-mads18B"; //SKRIV PASSWORD

    public List<TouristAttraction> findAll() {
        List<TouristAttraction> attractions = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(db_url, username, pw)) {
            String SQL = "SELECT attractions.*, GROUP_CONCAT(attraction_tag.tag_name) AS tag_names " +
                    "FROM attractions " +
                    "JOIN attraction_tag " +
                    "ON attractions.id = attraction_tag.attractions_id " +
                    "GROUP BY attractions.id";

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                String name = rs.getString("name");
                String description = rs.getString("description");
                String city = rs.getString("city");
                String tagNames = rs.getString("tag_names");
                String[] tags = tagNames.split(",");
                List<Tags> tag_enums = new ArrayList<>();

                for (String tag : tags) {
                    tag_enums.add(getTagFromTagName(tag));
                }

                attractions.add(new TouristAttraction(name, description, city, tag_enums));
            }
            return attractions;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<TouristAttraction> getAttractionFromTag(Tags enumTag) {
        List<TouristAttraction> attractions = new ArrayList<>();
        String enum_name = enumTag.getDisplayValue();
        try (Connection con = DriverManager.getConnection(db_url, username, pw)) {
            String SQL = "SELECT * FROM attractions INNER JOIN attraction_tag ON attractions.id = attraction_tag.attractions_id WHERE attraction_tag.tag_name = ?";
            PreparedStatement preparedStatement = con.prepareStatement(SQL);
            preparedStatement.setString(1, enum_name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                String city = resultSet.getString("city");
                attractions.add(new TouristAttraction(name, description, city, getTagsFromID(id))); //DET HER VIRKER IKKE
                // TODO BRUG GROUP_CONCAT LIGESOM I findAll OG findName...
            }
            return attractions;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public TouristAttraction postAttraction(TouristAttraction attraction) { //TODO
        return null;
    }

    public TouristAttraction updateAttraction(TouristAttraction attraction) {
        return null;
    }

    public TouristAttraction deleteAttraction(String name) {
        return null;
    }

    public TouristAttraction getAttractionFromName(String name) {
        try (Connection con = DriverManager.getConnection(db_url, username, pw)) {
            String SQL = "SELECT attractions.*, GROUP_CONCAT(attraction_tag.tag_name) AS tag_names " +
                    "FROM attractions " +
                    "JOIN attraction_tag " +
                    "ON attractions.id = attraction_tag.attractions_id " +
                    "WHERE name = ? " +
                    "GROUP BY attractions.id";
            PreparedStatement preparedStatement = con.prepareStatement(SQL);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String attractionName = resultSet.getString("name");
                String description = resultSet.getString("description");
                String city = resultSet.getString("city");
                List<Tags> enum_tags = getTagListFromString(resultSet, "tag_names");
                return new TouristAttraction(attractionName, description, city, enum_tags);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private List<Tags> getTagListFromString(ResultSet resultSet, String columLabel) throws SQLException {
        List<Tags> tagsList = new ArrayList<>();
        String[] tagArray = resultSet.getString(columLabel).split(",");
        for (String tag : tagArray) {
            tagsList.add(getTagFromTagName(tag));
        }
        return tagsList;
    }

    public TouristAttraction findUrlName(String urlName) {
        return null;
    }

    public List<String> getCityList() {
        return null;
    }

    public Tags getTagFromTagName(String tagName) { //skal måske være et andet sted eller laves smartere
        switch (tagName) {
            case "FORLYSTELSESPARK" -> {
                return Tags.FORLYSTELSESPARK;
            }
            case "PARK" -> {
                return Tags.PARK;
            }
            case "SPISESTEDER" -> {
                return Tags.SPISESTEDER;
            }
            case "UDENDØRS" -> {
                return Tags.UDENDØRS;
            }
            case "HC_ANDERSEN" -> {
                return Tags.HC_ANDERSEN;
            }
            case "EVENTYR" -> {
                return Tags.EVENTYR;
            }
            case "BØRN" -> {
                return Tags.BØRN;
            }
            case "KUNST" -> {
                return Tags.KUNST;
            }
            case "MUSEUM" -> {
                return Tags.MUSEUM;
            }
            case "INDENDØRS" -> {
                return Tags.INDENDØRS;
            }
            default -> {
                return null; //forkert tagName
            }
        }
    }

    public List<Tags> getTagsFromID(int id) { //den her kan ikke bruges
        List<Tags> tags = new ArrayList<>();
        try (Connection con = getConnection(db_url, username, pw)) {
            String SQL = "SELECT tag_name FROM ATTRACTION_TAG WHERE attractions_id = ?";
            PreparedStatement preparedStatement = con.prepareStatement(SQL);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                tags.add(getTagFromTagName(resultSet.getString("tag_name")));
            }
            return tags;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
