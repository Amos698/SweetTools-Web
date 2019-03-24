package win.amos698.sweettools.mrepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import win.amos698.sweettools.mrepository.repo.UserRepo;
import win.amos698.sweettools.mrepository.repo.model.User;

import java.util.Optional;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MRepositoryApplicationTests {

    @Autowired
    private UserRepo userRepo;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testUserCRUD() {
//        User user = new User();
//        user.setName("autotest" + Math.random());
//        user.setPassword("passwd");
//        user.setEmail("test" + Math.random() + "@test.com");
//        user.setPhone("123" + Math.random());
//        user.setSex(1);
//        user.setUsed(1);
//        User u = userRepo.save(user);
//
//        userRepo.getOne(u.getId());
//        u.setSex(0);
//        userRepo.save(u);
//        userRepo.deleteById(u.getId());
        Optional<User> u = userRepo.findById(1L);
        u.ifPresent(System.out::println);
    }

}
