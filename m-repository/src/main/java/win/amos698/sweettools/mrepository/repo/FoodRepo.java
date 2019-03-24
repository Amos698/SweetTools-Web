package win.amos698.sweettools.mrepository.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import win.amos698.sweettools.mrepository.repo.model.Food;

public interface FoodRepo extends JpaRepository<Food, Long> {
}
