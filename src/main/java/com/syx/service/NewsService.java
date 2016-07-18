package com.syx.service;

import com.syx.dao.NewsDAO;
import com.syx.model.News;
import com.syx.util.ToutiaoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOError;
import java.io.IOException;
import java.nio.file.Files;
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

    public String saveImage(MultipartFile file) throws IOException{
        int dotPos = file.getOriginalFilename().lastIndexOf(".");
        if(dotPos < 0){
            return null;
        }
        String fileExt = file.getOriginalFilename().substring(dotPos+1);
        if (ToutiaoUtil.isFileAllowed(fileExt)){
            return null;
        }

        Files.copy(file.getInputStream(),)
    }
}
