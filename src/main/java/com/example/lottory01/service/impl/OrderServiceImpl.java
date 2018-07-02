package com.example.lottory01.service.impl;

import com.example.lottory01.bean.Order;
import com.example.lottory01.dao.OrderDao;
import com.example.lottory01.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName:OrderServiceImpl
 * Description:
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public void save(Order order) {
        orderDao.save(order);
    }
}
