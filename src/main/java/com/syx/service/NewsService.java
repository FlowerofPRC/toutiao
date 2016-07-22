package com.syx.service;

import com.syx.dao.NewsDAO;
import com.syx.model.News;
import com.syx.util.ToutiaoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOError;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

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

    public int addNews(News news) {
        newsDAO.addNews(news);
        return news.getId();
    }

//    public News getById(int newsId) {
//        return newsDAO.getById(newsId);
//    }

    public String saveImage(MultipartFile file) throws IOException{
        int dotPos = file.getOriginalFilename().lastIndexOf(".");
        if(dotPos < 0){
            return null;
        }
        String fileExt = file.getOriginalFilename().substring(dotPos+1).toLowerCase();
        if (ToutiaoUtil.isFileAllowed(fileExt)){
            return null;
        }

        String filename = UUID.randomUUID().toString().replaceAll("-","") + "." + fileExt;
        Files.copy(file.getInputStream(),new File(ToutiaoUtil.IMAGE_DIR+filename).toPath(),
                StandardCopyOption.REPLACE_EXISTING);
        return ToutiaoUtil.TOUTIAO_DOMAIN + "image?name=" + filename;
    }
}
