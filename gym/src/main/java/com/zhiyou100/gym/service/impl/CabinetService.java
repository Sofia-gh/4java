package com.zhiyou100.gym.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhiyou100.gym.mapper.ICabinetMapper;
import com.zhiyou100.gym.pojo.Cabinet;
import com.zhiyou100.gym.service.ICabinetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Sofia
 */
@Service
public class CabinetService implements ICabinetService {
    @Autowired
    private ICabinetMapper cabinetMapper;

    @Override
    public int findCurrentPage(Integer page){
        if (page == null || page < 1) {
            page = 1;
        }
        return page;
    }

    @Override
    public List<Cabinet> findByPage(Integer page) {
        IPage<Cabinet> cabinetIPage = new Page<>(page,10);
        return cabinetMapper.selectPage(cabinetIPage,null).getRecords();
    }

    @Override
    public int findMaxPage() {
        int count = cabinetMapper.selectCount(null);
        int mPage = count / 10;
        if (count % 10 != 0) {
            mPage ++;
        }
        return mPage;
    }

    @Override
    public int insert(Cabinet cabinet) {
        return cabinetMapper.insert(cabinet);
    }

    @Override
    public int update(Cabinet cabinet) {
        return cabinetMapper.updateById(cabinet);
    }

    @Override
    public int delete(Integer id) {
        return cabinetMapper.deleteById(id);
    }

}
