package tourism.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import tourism.model.Tags;
import tourism.model.TouristAttraction;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {

    private final ArrayList<TouristAttraction> attractionsList = new ArrayList<>();
    private final List<String> cityList = List.of("København", "Odense", "Århus", "Aalborg", "Randers");




   public TouristRepository() {
        attractionsList.add(new TouristAttraction("Tivoli", "Stor forlystelsespark i midten af København.","København", List.of(Tags.FORLYSTELSESPARK, Tags.UDENDØRS, Tags.BØRN)));
        attractionsList.add(new TouristAttraction("Den Lille Havfrue", "En havfrue på en sten, fra H. C. Andersens kendte eventyr 'Den lille Havfrue'.", "København", List.of(Tags.UDENDØRS, Tags.KUNST)));
        attractionsList.add(new TouristAttraction("Djurs Sommerland", "Forlystelsespark for børn.", "Nimtofte", List.of(Tags.UDENDØRS, Tags.FORLYSTELSESPARK,Tags.BØRN)));
        attractionsList.add(new TouristAttraction("Glyptoteket", "Kunstmuseum i København.","København", List.of(Tags.KUNST,Tags.MUSEUM,Tags.INDENDØRS)));
        attractionsList.add(new TouristAttraction("Bakken", "Danmarks ældste forlystelsespark.","Klampenborg", List.of(Tags.UDENDØRS,Tags.PARK,Tags.FORLYSTELSESPARK)));
    }

    public TouristAttraction findName(String name){
        for (TouristAttraction touristAttraction : attractionsList){
            if (touristAttraction.getName().contains(name)){
                return touristAttraction;
            }
        }
        return null;
    }

    public TouristAttraction findUrlName(String urlName){
        for (TouristAttraction touristAttraction : attractionsList){
            if (touristAttraction.getUrlName().equalsIgnoreCase(urlName)){
                return touristAttraction;
            }
        }
        return null;
    }

    public List<TouristAttraction> getAttractionFromTag(Tags tag) {
        List<TouristAttraction> matchingAttraction = new ArrayList<>();
        for (TouristAttraction attraction : attractionsList){
            if (attraction.getTags().contains(tag)){
                matchingAttraction.add(attraction);
            }
        }
        return matchingAttraction;
    }

    public TouristAttraction postAttraction(TouristAttraction attraction){
        attractionsList.add(attraction);
        return attraction;
    }

    public TouristAttraction updateAttraction(TouristAttraction attraction){
        for (int i = 0; i < attractionsList.size(); i++) {
            if (attractionsList.get(i).getName().equalsIgnoreCase(attraction.getName())){
                attractionsList.set(i,attraction);
                return attraction;
            }
        }
        return null;
    }

    public TouristAttraction deleteAttraction(String name){
        TouristAttraction attraction = null;
        for (TouristAttraction touristAttraction : attractionsList){
            if (touristAttraction.getName().equalsIgnoreCase(name)){
                attraction = touristAttraction;
            }
        }
        if (attraction!=null){
            attractionsList.remove(attraction);
        }
        return attraction;
    }


    public ArrayList<TouristAttraction> getAttractionsList() {
        return attractionsList;
    }
    public List<String> getCityList(){
        return cityList;
    }

}
