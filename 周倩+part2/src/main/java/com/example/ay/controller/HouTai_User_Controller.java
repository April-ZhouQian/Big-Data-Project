package com.example.ay.controller;

import com.example.ay.dao.UserDao;
import com.example.ay.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/houtai")
public class HouTai_User_Controller {
    @Resource
    private UserDao userDao;

    @RequestMapping("/manage")
    public ModelAndView manage()throws Exception{
        ModelAndView mav=new ModelAndView();

        List<User> userList=userDao.findAll();
        mav.addObject("userList",userList);
        mav.addObject("title","数据列表");
        mav.setViewName("/manage");
        return mav;
    }

    @RequestMapping("/add")
    public ModelAndView add()throws Exception{
        ModelAndView mav=new ModelAndView();
        mav.addObject("title","添加数据");
        mav.setViewName("/add");
        return mav;
    }

    @RequestMapping("/edit")
    public ModelAndView edit(@RequestParam(value = "id",required = false) Integer id)throws Exception{
        ModelAndView mav=new ModelAndView();
        User user=userDao.getOne(id);
        mav.addObject("user",user);
        mav.setViewName("/edit");
        mav.addObject("title","修改数据");
        return mav;
    }

    @RequestMapping("/del")
    public String del(@RequestParam(value = "id",required = false) Integer id)throws Exception{
        userDao.deleteById(id);
        return "redirect:/houtai/manage";
    }
}
