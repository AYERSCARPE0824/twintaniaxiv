package com.ayerscarpe.xivstratz.service;

import com.ayerscarpe.xivstratz.entity.User;
import com.ayerscarpe.xivstratz.service.imp.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.sql.SQLIntegrityConstraintViolationException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserTest {

    @Resource
    private UserServiceImpl userService;

    @Test
    public void userTest() throws Exception{
        User user = new User();
        user.setUsername("testUsername1");
        user.setPassword("testPassword1");
        userService.insert(user);
        try {
            userService.insert(user);
        }catch (Exception e){
            if(e.getCause() instanceof SQLIntegrityConstraintViolationException){
                System.out.println("用户名已注册");
            }
        }finally {
            userService.selectOne(user);
        }
    }
}
