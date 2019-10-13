package win.amos698.sweettools.wishingwell.service;

import org.springframework.transaction.annotation.Transactional;
import win.amos698.sweettools.wishingwell.repo.model.Wish;

public interface WishService {

    @Transactional
    Wish createWish(long userId, String wishName, String wishDesc, String wishImg);

    Wish readWish(long wishId);

    @Transactional
    Wish updateWish(Wish wish);

    @Transactional
    void deleteWish(long wishId);

    Wish pickWish(long userId);
}
