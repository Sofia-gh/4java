package com.zhiyou100.gym.service.impl;

import com.zhiyou100.gym.mapper.ICoachMapper;
import com.zhiyou100.gym.mapper.IMemberRechargeMapper;
import com.zhiyou100.gym.mapper.IStaffMapper;
import com.zhiyou100.gym.pojo.MemberRecharge;
import com.zhiyou100.gym.service.IFinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("financeService")
public class FinanceServiceImpl implements IFinanceService {
    @Autowired
    private IMemberRechargeMapper memberRechargeMapper;
    @Autowired
    private ICoachMapper coachMapper;
    @Autowired
    private IStaffMapper staffMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Integer> find() {
        List<MemberRecharge> recharges = memberRechargeMapper.selectList(null);
        int a = 0;
        int b = 0;
        for (MemberRecharge recharge:recharges) {
            if (recharge.getItemNumber()/20000>0){
                a += recharge.getMoney();
            }else {
                b += recharge.getMoney();
            }
        }
        List<Integer> finances = new ArrayList<>();
        finances.add(a);
        finances.add(b);
        int c = 0;
        c += (coachMapper.selectCount(null)+staffMapper.selectCount(null))*4000;
        finances.add(c);
        return finances;
    }
}
