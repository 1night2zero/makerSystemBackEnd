package zstu.edu.eduservice.controller;

import org.springframework.web.bind.annotation.*;
import zstu.edu.commonutils.R;

@RestController
@RequestMapping("/eduservice/user")
@CrossOrigin    // 跨域
public class EduLoginController {
    @PostMapping("login")
    public R login() {
        return R.ok().data("token", "admin");
    }

    @GetMapping("info")
    public R info() {
        return R.ok().data("roles", "[admin]").data("name", "admin").data("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }
}
