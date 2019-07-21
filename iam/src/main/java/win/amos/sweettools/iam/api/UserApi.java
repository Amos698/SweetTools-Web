package win.amos.sweettools.iam.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import win.amos.sweettools.iam.api.model.Result;
import win.amos.sweettools.iam.repo.model.User;
import win.amos.sweettools.iam.service.UserService;
import win.amos.sweettools.iam.utils.JWTHelper;

@RestController
@RequestMapping("/iam")
public class UserApi {

    private final UserService userService;

    @Autowired
    public UserApi(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/token")
    public Result<User> signIn(@RequestParam String username,
                               @RequestParam String password) {
        User user = userService.verifyUser(username, password);
        if (user == null) {
            return Result.getErrorResult("401", "用户名密码错误");
        } else {
            return new Result<>(JWTHelper.createToken(username), "201", "登录成功", user);
        }
    }

    @PostMapping(value = "/user")
    public Result<User> addUser(@RequestBody User u) {
        User user = userService.createUser(u);
        if (user == null) {
            return Result.getErrorResult("401", "用户名重复");
        } else {
            return new Result<>(JWTHelper.createToken(u.getUserName()), "201", "创建成功", user);
        }
    }

    @PutMapping(value = "user/{uid}")
    public Result<User> updateUser(@PathVariable Long uid,
                                   @RequestHeader("Auth-Token") String token,
                                   @RequestParam(required = false) String password,
                                   @RequestParam(required = false) String intro,
                                   @RequestParam(required = false) String avator) {
        if (!JWTHelper.varifyToken(token)) {
            return Result.getErrorResult("400", "无效的token");
        }

        User user = userService.findUser(uid);
        if (password != null) {
            user.setPassword(password);
        }

        if (intro != null) {
            user.setIntro(intro);
        }

        if (avator != null) {
            user.setAvator(avator);
        }

        user = userService.updateUser(user);

        if (user == null) {
            return Result.getErrorResult("400", "更新用户失败");
        } else {
            return new Result<>(token, "200", "更新成功", user);
        }
    }
}
