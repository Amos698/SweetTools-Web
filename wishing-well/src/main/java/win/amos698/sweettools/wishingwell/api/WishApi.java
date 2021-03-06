package win.amos698.sweettools.wishingwell.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import win.amos698.sweettools.wishingwell.api.model.Result;
import win.amos698.sweettools.wishingwell.repo.model.Wish;
import win.amos698.sweettools.wishingwell.service.WishService;

@RestController
@RequestMapping("/wishing-well")
public class WishApi {

    private final WishService wishService;

    @Autowired
    public WishApi(WishService wishService) {
        this.wishService = wishService;
    }

    @PostMapping("/wish")
    public Result<Wish> createWish(@RequestParam long userId,
                                   @RequestParam String wishName,
                                   @RequestParam String wishDesc,
                                   @RequestParam String wishImg) {
        Wish wish = wishService.createWish(userId, wishName, wishDesc, wishImg);
        if (wish == null) {
            return new Result<>("401", "参数错误", null);
        } else {
            return new Result<>("201", "创建成功", wish);
        }
    }

    @GetMapping("/wish/{wishId}")
    public Result<Wish> readWish(@PathVariable long wishId) {
        Wish wish = wishService.readWish(wishId);
        if (wish == null) {
            return new Result<>("401", "参数错误", null);
        } else {
            return new Result<>("200", "查询成功", wish);
        }
    }

    @PutMapping("/wish/{wishId}")
    public Result<Wish> updateWish(@PathVariable long wishId,
                                   @RequestParam(required = false) String wishName,
                                   @RequestParam(required = false) String wishDesc,
                                   @RequestParam(required = false) String wishImg) {

        Wish wish = wishService.readWish(wishId);
        if (wishName != null) {
            wish.setWishName(wishName);
        }

        if (wishDesc != null) {
            wish.setWishDesc(wishDesc);
        }

        if (wishImg != null) {
            wish.setWishImg(wishImg);
        }

        wish = wishService.updateWish(wish);
        if (wish == null) {
            return new Result<>("401", "参数错误", null);
        } else {
            return new Result<>("200", "修改成功", wish);
        }
    }

    @DeleteMapping("/wish/{wishId}")
    public void deleteWish(@PathVariable long wishId) {
        wishService.deleteWish(wishId);
    }

    @GetMapping("/pick-wish/{userId}")
    public Result<Wish> pickWish(@PathVariable long userId) {
        Wish wish = wishService.pickWish(userId);
        if (wish == null) {
            return new Result<>("401", "参数错误", null);
        } else {
            return new Result<>("200", "获取成功", wish);
        }
    }
}
