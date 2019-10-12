package win.amos698.sweettools.wishingwell.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import win.amos698.sweettools.wishingwell.repo.WishRepo;
import win.amos698.sweettools.wishingwell.repo.model.Wish;
import win.amos698.sweettools.wishingwell.service.WishService;

@Service
public class WishServiceImpl implements WishService {

    private final WishRepo wishRepo;

    @Autowired
    public WishServiceImpl(WishRepo wishRepo) {
        this.wishRepo = wishRepo;
    }

    @Override
    public Wish createWish(int userId, String wishName, String wishDesc, String wishImg) {
        Wish wish = new Wish(userId, wishName, wishDesc, wishImg);
        return wishRepo.save(wish);
    }

    @Override
    public Wish readWish(int wishId) {
        return wishRepo.getOne(wishId);
    }

    @Override
    public Wish updateWish(Wish wish) {
        return wishRepo.save(wish);
    }

    @Override
    public void deleteWish(int wishId) {
        wishRepo.deleteWish(wishId);
    }

    @Override
    public Wish pickWish(int userId) {
        return wishRepo.pickOne(userId);
    }
}
