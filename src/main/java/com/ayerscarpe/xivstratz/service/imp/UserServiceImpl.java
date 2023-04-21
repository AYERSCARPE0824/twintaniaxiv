package com.ayerscarpe.xivstratz.service.imp;

import com.ayerscarpe.xivstratz.entity.User;
import com.ayerscarpe.xivstratz.mapper.UserMapper;
import com.ayerscarpe.xivstratz.service.UserService;
import com.ayerscarpe.xivstratz.util.Result;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import java.sql.SQLIntegrityConstraintViolationException;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    final
    UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    //  增加用户
    public Result insert(User user){
        //todo-用全局异常处理器代替 try-catch 处理异常
        try {
            userMapper.insert(user);
        }catch (Exception e){
            if(e.getCause() instanceof SQLIntegrityConstraintViolationException){
                System.out.println("用户名已注册");
                return Result.regError();
            }
        }
        return Result.regSuccess();
    }

    //  查找特定用户
    public String selectOne(User user){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", user.getUsername());
        return userMapper.selectOne(queryWrapper).getPassword();
    }
}
