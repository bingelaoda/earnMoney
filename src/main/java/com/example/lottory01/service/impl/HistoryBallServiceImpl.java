package com.example.lottory01.service.impl;

import com.example.lottory01.bean.BallHistory;
import com.example.lottory01.dao.HistoryBallDao;
import com.example.lottory01.service.HistoryBallService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * ClassName:HistoryBallServiceImpl
 * Description:
 */
@Service
public class HistoryBallServiceImpl implements HistoryBallService {


    @Autowired
    private HistoryBallDao historyBallDao;

    @Override
    public Page<BallHistory> findAll() {
        Sort sort = new Sort(Sort.Direction.DESC,"code");
        Pageable pageable = new PageRequest(0,10,sort);
        Page<BallHistory> all = historyBallDao.findAll(pageable);
        return all;
    }

    @Override
    public BallHistory findOne(String code) {
        System.out.println("code="+code);
        return historyBallDao.findOne(code);
    }
}
