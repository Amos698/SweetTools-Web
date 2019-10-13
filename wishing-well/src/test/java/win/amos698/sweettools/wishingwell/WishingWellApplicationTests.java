package win.amos698.sweettools.wishingwell;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import win.amos698.sweettools.wishingwell.api.WishApi;
import win.amos698.sweettools.wishingwell.repo.model.Lover;
import win.amos698.sweettools.wishingwell.repo.model.Wish;
import win.amos698.sweettools.wishingwell.service.LoverService;
import win.amos698.sweettools.wishingwell.service.WishService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WishingWellApplicationTests {

    @Autowired
    private WishService wishService;

    @Autowired
    private LoverService loverService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testWishService() {
        Wish wish = wishService.createWish(1, "口红", "dior999", "imgUrl");
        System.out.println(wish.toString());
        Wish w1 = wishService.readWish(wish.getId());

        System.out.println(w1);

        w1.setWishDesc("ysl777");
        w1 = wishService.updateWish(w1);

        System.out.println(w1);

        wishService.deleteWish(w1.getId());

    }

    @Test
    public void testRandomPick() {
//        for (int i = 0; i < 100; i++) {
//            wishService.createWish(1, "k" + i, "d" + i, "imgUrl" + i);
//        }
//
//        for (int i = 0; i < 100; i++) {
//            wishService.createWish(2, "b" + i, "a" + i, "imgUrl" + i);
//        }

        Wish wish = wishService.pickWish(1);
        System.out.println(wish);
    }

    @Test
    public void testLoverService() {
        Lover lover = loverService.createLover(1, 2);
        System.out.println(lover);

        System.out.println(loverService.readLover(1));

        lover = loverService.updateLover(1, 3);
        System.out.println(lover);

        System.out.println(loverService.deleteLover(1));
    }

}
