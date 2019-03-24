package win.amos698.sweettools.mrepository.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import win.amos698.sweettools.mrepository.repo.UserRepo;
import win.amos698.sweettools.mrepository.repo.model.User;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserRepoApi {

    private UserRepo userRepo;

    @Autowired
    public UserRepoApi(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping(value = "/add")
    public void addUser(@RequestBody User user) {
        user.setUsed(1);
        userRepo.save(user);
    }

    @DeleteMapping(value = "/delete")
    public void deleteUser(@RequestParam Long id) {
        User user = userRepo.getOne(id);
        user.setUsed(0);
        userRepo.save(user);
    }

    @PutMapping(value = "/update")
    public void updateUser(@RequestBody User user) {
        Optional<User> userOptional = userRepo.findById(user.getId());
        if (userOptional.isPresent()) {
            User u = userOptional.get();
            if (user.getPassword() != null) {
                u.setPassword(user.getPassword());
            }
            if (user.getEmail() != null) {
                u.setEmail(user.getEmail());
            }
            if (user.getPhone() != null) {
                u.setPhone(user.getPhone());
            }
            userRepo.save(u);
        }

    }

    @GetMapping(value = "/findById")
    public User findUserById(@RequestParam Long id) {
        Optional<User> userOptional = userRepo.findById(id);
        return userOptional.orElse(new User());
    }

    @GetMapping(value = "/findByEmail")
    public User findUserByEmail(@RequestParam String email) {
        User user = userRepo.findByEmailAndUsed(email, 1);
        if (user != null) {
            return user;
        } else {
            return new User();
        }
    }

    @GetMapping(value = "/findByPhone")
    public User findUserByPhone(@RequestParam String phone) {
        User user = userRepo.findByPhoneAndUsed(phone, 1);
        if (user != null) {
            return user;
        } else {
            return new User();
        }
    }
}
