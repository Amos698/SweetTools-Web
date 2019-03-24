package win.amos698.sweettools.mrepository.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import win.amos698.sweettools.mrepository.repo.model.User;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {


    User findByEmailAndUsed(String email, Integer used);

    User findByPhoneAndUsed(String phone, Integer used);

}
