package com.syx.service;

import com.syx.dao.UserDAO;
import com.syx.model.*;
import com.syx.util.ToutiaoUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;


/**
 * Created by Administrator on 2016/7/12.
 */
@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public Map<String,Object> register(String username, String password){
        Map<String,Object> map = new HashMap<String,Object>();
        if(StringUtils.isBlank(username)){
            map.put("msgname","用户名不能为空");
        }

        if(StringUtils.isBlank(username)){
            map.put("msgpwd","密码不能为空");
        }

        User user = userDAO.selectByName(username);
        if(user != null){
            map.put("msgname","用户名已经被注册");
        }

        user = new User();
        user.setName(username);
        user.setSalt(UUID.randomUUID().toString().substring(0,5));
        user.setHeadUrl(String.format("Http://images.nowcoder.com/head/%dt.png", new Random().nextInt(1000)));
        user.setPassword(ToutiaoUtil.MD5(password+user.getSalt()));
        userDAO.addUser(user);

        return map;
    }

    public User getUser(int id){
        return userDAO.selectById(id);
    }
}
