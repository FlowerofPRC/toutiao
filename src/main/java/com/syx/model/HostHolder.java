package com.syx.model;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/7/14.
 */
@Component
public class HostHolder {
    private static ThreadLocal<User> users = new ThreadLocal<User>();

    public User getUser() {
        return users.get();
    }

    public void setUser(User user){
        users.set(user);
    }

    public void clear() {
        users.remove();
    }
}
