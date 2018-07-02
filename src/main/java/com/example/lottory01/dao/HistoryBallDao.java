package com.example.lottory01.dao;

import com.example.lottory01.bean.BallHistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ClassName:HistoryBallDao
 * Description:
 */
@Repository
public interface HistoryBallDao extends JpaRepository<BallHistory,String> {
}
