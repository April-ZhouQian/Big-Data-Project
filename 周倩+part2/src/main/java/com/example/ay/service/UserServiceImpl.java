package com.example.ay.service;

import com.example.ay.dao.UserDao;
import com.example.ay.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    UserDao userDao;

    @Override
    public void update(User user){
        User origin =userDao.findId(user.getId());
        user=replace(user,origin);
        userDao.save(user);

    }

    public User replace(User curr,User origin){
        if(curr.getId()==null){
            curr.setId(origin.getId());
        }
        if(curr.getName()==null){
            curr.setName(origin.getName());
        }
        if(curr.getTrueName()==null){
            curr.setTrueName(origin.getTrueName());
        }
        if(curr.getAge()==null){
            curr.setAge(origin.getAge());
        }
        if(curr.getScore()==null){
            curr.setScore(origin.getScore());
        }


        return curr;
    }

}
