package win.amos698.sweettools.wishingwell.api;

import org.springframework.web.bind.annotation.*;
import win.amos698.sweettools.wishingwell.api.model.Result;
import win.amos698.sweettools.wishingwell.repo.model.Lover;
import win.amos698.sweettools.wishingwell.service.LoverService;

@RestController
@RequestMapping("/lover")
public class LoverApi {

    private final LoverService loverService;

    public LoverApi(LoverService loverService) {
        this.loverService = loverService;
    }

    @PostMapping("/{uid}")
    public Result<Lover> createLover(@PathVariable long uid, @RequestParam long lid) {
        Lover lover = loverService.createLover(uid, lid);
        if (lover == null) {
            return new Result<>("401", "参数错误", null);
        } else {
            return new Result<>("200", "创建成功", lover);
        }
    }

    @GetMapping("/{uid}")
    public Result<Lover> readLover(@PathVariable long uid) {
        Lover lover = loverService.readLover(uid);
        if (lover == null) {
            return new Result<>("401", "参数错误", null);
        } else {
            return new Result<>("200", "获取成功", lover);
        }
    }

    @PutMapping("/{uid}")
    public Result<Lover> updateLover(@PathVariable long uid, @RequestParam long lid) {
        Lover lover = loverService.updateLover(uid, lid);
        if (lover == null) {
            return new Result<>("401", "参数错误", null);
        } else {
            return new Result<>("200", "更新成功", lover);
        }
    }

    @DeleteMapping("/{uid}")
    public Result<Long> deleteLover(@PathVariable long uid) {
        int line = loverService.deleteLover(uid);
        if (line > 0) {
            return new Result<>("200", "删除成功", uid);
        } else {
            return new Result<>("400", "删除失败", null);
        }
    }


}
