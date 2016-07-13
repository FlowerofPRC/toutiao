package com.syx.service;

import com.syx.dao.NewsDAO;
import com.syx.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/7/12.
 */
@Service
public class NewsService {
    @Autowired
    private NewsDAO newsDAO;

    public List<News> getLatestNews(int userId, int offset ,int limit){
        return newsDAO.selectByUserIdAndOffset(userId,offset,limit);
    }
}
