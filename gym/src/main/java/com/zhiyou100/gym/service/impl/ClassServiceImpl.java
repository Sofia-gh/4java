package com.zhiyou100.gym.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhiyou100.gym.mapper.IClassMapper;
import com.zhiyou100.gym.pojo.Class;
import com.zhiyou100.gym.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Sofia
 */
@Service("classService")
public class ClassServiceImpl implements IClassService {
    @Autowired
    private IClassMapper classMapper;

    private static final int KEY = 10;

    @Override
    public int findCurrentPage(Integer page){
        if (page == null || page < 1) {
            page = 1;
        }
        return page;
    }

    @Override
    public List<Class> findByPage(Integer page) {
        IPage<Class> classPage = new Page<>(page,KEY);
        return classMapper.selectPage(classPage,null).getRecords();
    }

    @Override
    public int findMaxPage() {
        int count = classMapper.selectCount(null);
        int mPage = count / KEY;
        if (count % KEY != 0) {
            mPage ++;
        }
        return mPage;
    }

    @Override
    public int insert(Class c) {
        return classMapper.insert(c);
    }

    @Override
    public int start(Class c) {
        c.setStatus(2);
        return classMapper.updateById(c);
    }

    @Override
    public int end(Class c) {
        c.setStatus(3);
        return classMapper.updateById(c);
    }

    @Override
    public List<Class> find(String key) {
        return classMapper.selectList(new QueryWrapper<Class>().like("name",key).or().like("type",key));
    }

}
