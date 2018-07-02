package com.example.lottory01.service;

import com.example.lottory01.bean.BallHistory;

import org.springframework.data.domain.Page;

/**
 * ClassName:HistoryBallService
 * Description:
 */
public interface HistoryBallService {
    Page<BallHistory> findAll();

    BallHistory findOne(String code);
}
