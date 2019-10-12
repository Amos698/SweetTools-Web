package win.amos698.sweettools.wishingwell.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import win.amos698.sweettools.wishingwell.repo.model.Wish;

public interface WishRepo extends JpaRepository<Wish, Integer> {
}
