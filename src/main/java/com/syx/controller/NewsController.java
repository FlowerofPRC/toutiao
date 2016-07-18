package com.syx.controller;

import com.syx.util.ToutiaoUtil;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Administrator on 2016/7/18.
 */
@Controller
public class NewsController {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(NewsController.class);
    @RequestMapping(path = {"/uploadImage/"}, method = {RequestMethod.POST})
    @ResponseBody
    public String uploadImage(@RequestParam("file")MultipartFile file){
        try {

        }catch (Exception e){
            logger.error("上传图片失败"+ e.getMessage());
            return ToutiaoUtil.getJSONString(1,"上传失败");
        }
    }
}
