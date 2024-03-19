package tourism.repository;

import tourism.model.TouristAttraction;

import java.util.List;

public interface ITouristRepository {
    public List<TouristAttraction> findAll();
}
