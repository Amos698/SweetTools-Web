package win.amos.sweettools.iam.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import win.amos.sweettools.iam.repo.model.User;

public interface UserRepo extends JpaRepository<User, Long> {

    User findByUserNameAndUsed(String userName, Integer used);
}
