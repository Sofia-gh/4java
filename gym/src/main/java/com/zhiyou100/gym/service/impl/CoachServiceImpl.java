package com.zhiyou100.gym.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhiyou100.gym.mapper.ICoachMapper;
import com.zhiyou100.gym.pojo.Coach;
import com.zhiyou100.gym.service.ICoachService;
import com.zhiyou100.gym.util.QiniuUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

/**
 * @author Sofia
 */
@Service("coachService")
public class CoachServiceImpl implements ICoachService {
    @Autowired
    private ICoachMapper coachMapper;
    @Autowired
    private QiniuUtil qiniuUtil;

    private static final int KEY = 10;

    @Override
    public int findCurrentPage(Integer page){
        if (page == null || page < 1) {
            page = 1;
        }
        return page;
    }

    @Override
    public List<Coach> findByPage(Integer page,String key) {
        IPage<Coach> coachPage = new Page<>(page,KEY);
        if (StringUtils.isEmpty(key)){
            return coachMapper.selectPage(coachPage,null).getRecords();
        }
        return coachMapper.selectPage(coachPage,new QueryWrapper<Coach>().like("name",key).or().like("label",key)).getRecords();
    }

    @Override
    public int findMaxPage(String key) {
        int count;
        if (StringUtils.isEmpty(key)){
            count = coachMapper.selectCount(null);
        }else {
            count = coachMapper.selectCount(new QueryWrapper<Coach>().like("name",key).or().like("label",key));
        }
        int mPage = count / KEY;
        if (count % KEY != 0) {
            mPage ++;
        }
        return mPage;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(Coach coach,MultipartFile file) {
       // 为了防止图片名出现重复使得图片出现替换
        String fileName = String.valueOf(Instant.now().getEpochSecond())+file.getOriginalFilename();
        //	上传，需要抛出异常
        String path = "D:/code/git/gym/src/main/resources/static/img/"+fileName;
        try {
            file.transferTo(new File(path));
        }catch (Exception e){
            e.printStackTrace();
        }
//        FileInputStream inputStream = null;
//        try {
//            inputStream = (FileInputStream)file.getInputStream();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        String path = qiniuUtil.uploadImg(inputStream, fileName);
        coach.setPicture(fileName);
        return coachMapper.insert(coach);
    }

    @Override
    public Coach findById(Integer id) {
        return coachMapper.selectById(id);
    }

    @Override
    public int update(Coach coach, MultipartFile file) {
        if (!file.isEmpty()){
            // 为了防止图片名出现重复使得图片出现替换
            String fileName = String.valueOf(Instant.now().getEpochSecond())+file.getOriginalFilename();
            //	上传，需要抛出异常
            String path = "D:/code/git/gym/src/main/resources/static/img/"+fileName;
            try {
                file.transferTo(new File(path));
            }catch (Exception e){
                e.printStackTrace();
            }
            coach.setPicture(fileName);
        }
        coach.setUpdateTime(Timestamp.valueOf(LocalDateTime.now()));
        return coachMapper.updateById(coach);
    }
}
