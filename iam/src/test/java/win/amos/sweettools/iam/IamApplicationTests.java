package win.amos.sweettools.iam;

import com.auth0.jwt.JWT;
import com.netflix.discovery.converters.Auto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import win.amos.sweettools.iam.repo.model.Device;
import win.amos.sweettools.iam.repo.model.User;
import win.amos.sweettools.iam.service.UserService;
import win.amos.sweettools.iam.utils.JWTHelper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IamApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void testUser() {
        User user = new User();
        user.setUserName("Amos");
        user.setPassword("123456");
        user.setTag(Device.API);
        user =  userService.createUser(user);
        Assert.assertNotNull(user);
        Assert.assertNotNull(user.getId());
        Assert.assertNotNull(userService.verifyUser("Amos", "123456"));
        user.setIntro("test");
        user = userService.updateUser(user);
        Assert.assertEquals("test", user.getIntro());
        userService.deleteUser(user.getId());
    }

    @Test
    public void testToken() {
        String token = JWTHelper.createToken("Amos");
        System.out.println(token);
        Assert.assertTrue(JWTHelper.varifyToken(token));
    }

}
