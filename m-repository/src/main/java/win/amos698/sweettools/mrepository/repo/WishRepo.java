package win.amos698.sweettools.mrepository.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import win.amos698.sweettools.mrepository.repo.model.Wish;

public interface WishRepo extends JpaRepository<Wish, Long> {
}
