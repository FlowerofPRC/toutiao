package com.syx.controller;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.syx.model.News;
import com.syx.model.ViewObject;
import com.syx.service.NewsService;
import com.syx.service.UserService;
import com.syx.util.ToutiaoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/12.
 */
@Controller
public class LoginController {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(LoginController.class);

    @Autowired
    UserService userService;

    @RequestMapping(path = {"/reg/"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String reg(Model model, @RequestParam("username") String username,
                      @RequestParam("password") String password,
                      @RequestParam(value ="rember", defaultValue = "0") int rememberme){

        try{
            Map<String,Object> map = userService.register(username, password);
            if(map.isEmpty()){
                return ToutiaoUtil.getJSONString(0,"注册成功");
            }else {
                return ToutiaoUtil.getJSONString(1,map);
            }

        }catch (Exception e){
            logger.error("注册异常" + e.getMessage());
            return ToutiaoUtil.getJSONString(1,"注册异常");
        }
    }

}
