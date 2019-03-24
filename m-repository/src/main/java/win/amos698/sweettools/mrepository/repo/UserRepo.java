package win.amos698.sweettools.mrepository.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import win.amos698.sweettools.mrepository.repo.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
}
