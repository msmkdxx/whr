package com.csj.cn.whr.controller;

import com.csj.cn.whr.dto.Activity;
import com.csj.cn.whr.service.ActivityService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author chensijia
 * @Date 2020/5/715:26
 */
@RestController
@RequestMapping(value = "/test")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @ApiOperation("上传图片")
    @PostMapping("upload")
    public boolean uploadHeadPhoto(@RequestParam MultipartFile headPhotoFile, Activity activity, HttpServletRequest request) throws IOException {
        if (headPhotoFile.isEmpty()) {
            System.out.println("文件未上传");
        } else {
            //获取image/jpeg
            String contentType = headPhotoFile.getContentType();
            if (contentType.startsWith("image")) {
                //获取Web项目的全路径，图片保存路径
                String realPath = request.getSession().getServletContext().getRealPath("/") + "upload";
                String newFileName = new SimpleDateFormat("yyyyMMdd").format(new Date()) + ".jpg";
                FileUtils.copyInputStreamToFile(headPhotoFile.getInputStream(), new File(realPath, newFileName));
                //将图片路径插入数据库
                activity.setActivityImgurl("upload/" + newFileName);
                return activityService.insertActivity(activity);
            }
        }
        return false;
    }

    @GetMapping(value = "select")
    public List<Activity> selectAll(){
        return activityService.selectAll();
    }
}
