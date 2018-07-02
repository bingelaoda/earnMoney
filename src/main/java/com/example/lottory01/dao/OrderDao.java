package com.example.lottory01.dao;

import com.example.lottory01.bean.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ClassName:OrderDao
 * Description:
 */
@Repository
public interface OrderDao extends JpaRepository<Order,String> {
}
