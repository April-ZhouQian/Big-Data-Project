package com.example.ay.controller;

import com.example.ay.dao.UserDao;
import com.example.ay.entity.User;
import com.example.ay.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.naming.Binding;
import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping("/admin")
public class Admin_User_Controller {
    @Resource
    UserDao userDao;
    @Resource
    UserService userService;

    @ResponseBody
    @RequestMapping("/add")
    public JSONObject add(@Valid User user, BindingResult bindingResult) throws Exception{
        JSONObject result=new JSONObject();
        if(bindingResult.hasErrors()){
            result.put("success",false);
            result.put("msg",bindingResult.getFieldError().getDefaultMessage());
            return result;
        }else {

            userDao.save(user);
            result.put("success",true);
            result.put("msg","添加成功");
            return result;
        }
    }

    @ResponseBody
    @RequestMapping("/update")
    public JSONObject update(@Valid User user, BindingResult bindingResult)throws Exception{
        JSONObject result=new JSONObject();
        userService.update(user);
        result.put("success",true);
        result.put("msg","修改成功");
        return result;
    }
}
