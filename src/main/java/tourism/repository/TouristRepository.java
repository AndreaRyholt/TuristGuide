package tourism.repository;

import org.springframework.stereotype.Repository;
import tourism.model.Tags;
import tourism.model.TouristAttraction;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {
    private final ArrayList<TouristAttraction> attractionsList = new ArrayList<>();

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

    public TouristAttraction getAttractionFromTag(String tag) {
        for (TouristAttraction attractionTag : attractionsList){
            if (attractionTag.getTags().contains(tag)){
                return attractionTag;
            }
        }
        return null;
    }

    public TouristAttraction addAttraction(TouristAttraction attraction){
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
}
