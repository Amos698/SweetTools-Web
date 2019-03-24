package win.amos698.sweettools.mrepository.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import win.amos698.sweettools.mrepository.repo.WishRepo;
import win.amos698.sweettools.mrepository.repo.model.Wish;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/wishing-well")
public class WishRepoApi {

    private WishRepo wishRepo;

    @Autowired
    public WishRepoApi(WishRepo wishRepo) {
        this.wishRepo = wishRepo;
    }

    @PostMapping("/add")
    public void addWish(@RequestBody Wish wish) {
        wishRepo.save(wish);
    }

    @DeleteMapping("/delete")
    public void deleteWish(@RequestParam Long id) {
        wishRepo.deleteById(id);
    }

    @PutMapping("/update")
    public void updateWish(@RequestBody Wish wish) {
        Optional<Wish> wishOptional = wishRepo.findById(wish.getId());
        if (wishOptional.isPresent()) {
            Wish w = wishOptional.get();
            if (wish.getGiftName() != null) {
                w.setGiftName(wish.getGiftName());
            }
            if (wish.getGiftDesc() != null) {
                w.setGiftDesc(wish.getGiftDesc());
            }
            if (wish.getGiftImg() != null) {
                w.setGiftImg(wish.getGiftImg());
            }
            wishRepo.save(w);
        }
    }

    @GetMapping("/findAll")
    public List<Wish> findAll() {
        return wishRepo.findAll();
    }

    @GetMapping("/findById")
    public Wish findById(@RequestParam Long id) {
        Optional<Wish> wishOptional = wishRepo.findById(id);
        return wishOptional.orElse(new Wish());
    }
}
