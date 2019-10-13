package win.amos698.sweettools.wishingwell.api;

import org.springframework.web.bind.annotation.*;
import win.amos698.sweettools.wishingwell.api.model.Result;
import win.amos698.sweettools.wishingwell.repo.model.Lover;

@RestController
@RequestMapping("/lover")
public class LoverApi {

    @PostMapping("/{uid}")
    public Result<Lover> createLover(@PathVariable long uid, @RequestParam long lid) {
        return null;
    }

    @GetMapping("/{uid}")
    public Result<Lover> readLover(@PathVariable long uid) {
        return null;
    }

    @PutMapping("/{uid}")
    public Result<Lover> updateLover(@PathVariable long uid, @RequestParam long lid) {
        return null;
    }

    @DeleteMapping("/{uid}")
    public Result<Lover> deleteLover(@PathVariable long uid) {
        return null;
    }


}
