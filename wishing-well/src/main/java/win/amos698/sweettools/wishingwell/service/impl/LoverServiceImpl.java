package win.amos698.sweettools.wishingwell.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import win.amos698.sweettools.wishingwell.repo.LoverRepo;
import win.amos698.sweettools.wishingwell.repo.model.Lover;
import win.amos698.sweettools.wishingwell.service.LoverService;

@Service
public class LoverServiceImpl implements LoverService {

    private final LoverRepo loverRepo;

    @Autowired
    public LoverServiceImpl(LoverRepo loverRepo) {
        this.loverRepo = loverRepo;
    }

    @Override
    public Lover createLover(long uid, long lid) {
        Lover lover = loverRepo.getLover(uid);
        if (lover == null) {
            lover = new Lover(uid, lid);
            return loverRepo.save(lover);
        } else {
            return null;
        }

    }

    @Override
    public Lover readLover(long uid) {
        return loverRepo.getLover(uid);
    }

    @Override
    public Lover updateLover(long uid, long lid) {
        Lover lover = loverRepo.getLover(uid);
        lover.setGid(lid);
        return loverRepo.save(lover);
    }

    @Override
    public int deleteLover(long uid) {
        return loverRepo.deleteWish(uid);
    }
}
