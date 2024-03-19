package tourism.service;

import tourism.model.Tags;
import tourism.model.TouristAttraction;
import tourism.repository.TouristRepository;
import org.springframework.stereotype.Service;
import tourism.repository.TouristRepositoryJDBC;

import java.util.ArrayList;
import java.util.List;

@Service
public class TouristService {

    private TouristRepositoryJDBC repository;


    public TouristService(TouristRepositoryJDBC repository) {
        this.repository = repository;

    }

    public List<TouristAttraction> getAllAttractions()  {
        return repository.findAll();
    }

    public List<TouristAttraction> getAttractionFromTag(String tag) {
        try {
            Tags enumTag = Tags.valueOf(tag);
            return repository.getAttractionFromTag(enumTag);
        }
        catch (IllegalArgumentException e) {
            return null;
        }
    }



    public TouristAttraction addAttraction(TouristAttraction attraction) {
        return  repository.postAttraction(attraction);
    }

    public TouristAttraction updateAttraction(TouristAttraction attraction) {
        return repository.updateAttraction(attraction);
    }

    public TouristAttraction deleteAttraction(String name){
        return repository.deleteAttraction(name);
    }

    public TouristAttraction findName(String name){
        return repository.findName(name);
    }
    public TouristAttraction findUrlName(String urlName){
        return repository.findUrlName(urlName);
    }

    public List<String> getCitylist(){
        return repository.getCityList();
    }
}
