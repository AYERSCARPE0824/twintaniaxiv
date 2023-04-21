package com.ayerscarpe.xivstratz.controller;

import com.ayerscarpe.xivstratz.entity.User;
import com.ayerscarpe.xivstratz.service.imp.UserServiceImpl;
import com.ayerscarpe.xivstratz.util.Result;
import com.ayerscarpe.xivstratz.util.Token;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(allowCredentials = "true", origins = "http://localhost:9528")// 允许跨域来源为前端端口号
@RestController
public class UserController {

    final
    UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @ApiOperation("登陆验证")
    @PostMapping("/user/login")
    public Result login(@RequestBody User user){
        String token = Token.generateToken(user.getUsername());
        if(userService.selectOne(user).equals(user.getPassword())){
            return Result.success().data("token", token);
        }else {
            return Result.error().data("token", token);
        }
    }

    @ApiOperation("用户信息")
    @GetMapping("/user/getInfo")
    public Result info(String token){
        String username = Token.getClaimsByToken(token).getSubject();
        return Result.success().data("username", username).data("avatar","https://parsefiles.back4app.com/JPaQcFfEEQ1ePBxbf6wvzkPMEqKYHhPYv8boI1Rc/1fee426572ea6970d334a408ebce9534_low_res_VK%20Play%20Cloud.png");
    }

    @ApiOperation("退出登录")
    @PostMapping("/user/logout")
    public Result logout(){
        return Result.success();
    }


    @PostMapping("/user/register")
    public Result register(@RequestBody User user){
        return userService.insert(user);
    }
}
