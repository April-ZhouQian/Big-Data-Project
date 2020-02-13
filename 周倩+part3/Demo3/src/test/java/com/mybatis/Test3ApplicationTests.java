package com.mybatis;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mybatis.dao.UserMapper;
import com.mybatis.entity.User;
import com.mybatis.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class Test3ApplicationTests {

    @Resource
    UserMapper userMapper;
    @Resource
    UserService userService;

    @Test
    public void testInsert() {
        User user=new User();
        user.setAge(40);
        user.setScore(80);
        user.setName("ha");
        user.setTrueName("mama");
        userMapper.insert(user);
    }

    //基于service实现插入
    @Test
    public void testSave(){
        User user=new User();
        user.setAge(20);
        user.setScore(90);
        user.setName("pa");
        user.setTrueName("hma");
        if(userService.save(user)==true){
            System.out.println("success!");
        }else {
            System.out.println("fail!");
        }
    }

    //基于service实现删除(根据entity)
    @Test
    public void testRemove(){
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("name","ha");
        if(userService.remove(queryWrapper)==true){
            System.out.println("success!");
        }else {
            System.out.println("fail!");
        }
    }

    //基于service实现删除（根据id）
    @Test
    public void testRemoveById(){
        if(userService.removeById(6)){
            System.out.println("success!");
        }else {
            System.out.println("fail!");
        }
    }

    //基于service进行更新(根据entity)
    @Test
    public void testUpdate(){
        User user=new User();
        user.setAge(20);
        user.setScore(90);
        user.setName("ha");
        user.setTrueName("hma");
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("name","ma");
        if(userService.update(user,queryWrapper)){
            System.out.println("success!");
        }else {
            System.out.println("fail!");
        }
    }


    //基于service进行查询（有条件）
    @Test
    public void testList(){
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.like("name","m");
        List<User>userList=userService.list(queryWrapper);
        for(User user:userList){
            System.out.println(user);
        }
    }
    //基于service查询整张表
    @Test
    public void testGetList(){
        List<User>userList=userService.list();
        for(User user:userList){
            System.out.println(user);
        }
    }

    //实现数据分页查询(切记注入分页插件)
    @Test
    public void testPageSelect(){
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.like("name","h");
        Page<User> page=new Page<User>(1,2);
        IPage<User> iPage=userService.page(page,queryWrapper);
        System.out.println("current page:"+iPage.getCurrent());
        System.out.println("page size:"+iPage.getSize());
        System.out.println("total record:"+iPage.getTotal());
        System.out.println("total page:"+iPage.getPages());
        List<User>userList=iPage.getRecords();
        for(User user:userList){
            System.out.println(user);
        }
    }
}
