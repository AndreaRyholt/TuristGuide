package tourism.model;

import java.util.List;

public class TouristAttraction {
    private String name;
    private String description;
    private List<Tags> tags;
    private String city;
    private String urlName;

    public TouristAttraction(){
        //det her er for /create til at virke
    }

    public TouristAttraction(String name, String description, String city, List<Tags> tags) {
        this.name = name;
        this.description = description;
        this.urlName = this.name.replace(" ", "-");
        this.city = city;
        this.tags = tags;
    }

    public String getName() {
        return name;
    }
    public String getUrlName(){
        return urlName;
    }
    public String getDescription(){
        return description;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public String getCity(){
        return city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }

    public void setCity(String city) {
        this.city = city;
    }
}