package com.csj.cn.whr.service;

import com.csj.cn.whr.dto.Activity;
import com.csj.cn.whr.mapper.ActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TODO
 * @Author chensijia
 * @Date 2020/5/716:00
 */
@Service
public class ActivityService {
    @Autowired
    private ActivityMapper activityMapper;

    public boolean insertActivity(Activity activity) {
        return activityMapper.insertSelective(activity) > 0;
    }

    public List<Activity> selectAll(){
        return activityMapper.selectByExample(null);
    }

}
