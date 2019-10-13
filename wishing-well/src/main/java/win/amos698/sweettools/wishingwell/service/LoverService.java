package win.amos698.sweettools.wishingwell.service;

import org.springframework.transaction.annotation.Transactional;
import win.amos698.sweettools.wishingwell.repo.model.Lover;

public interface LoverService {

    @Transactional
    Lover createLover(long uid, long lid);

    Lover readLover(long uid);

    @Transactional
    Lover updateLover(long uid, long lid);

    @Transactional
    int deleteLover(long uid);
}
