package com.cq.distributedsharding;


import com.cq.distributedsharding.dao.OrderDao;
import com.cq.distributedsharding.entity.OrderEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class DistributedshardingApplicationTest {
    @Autowired
    private OrderDao orderDao;

    @Test
    public void insert() {
        for (int i = 0; i < 20; i++) {
            OrderEntity orderEntity = new OrderEntity();
            orderEntity.setUserId(new Random().nextInt(999));
            orderDao.save(orderEntity);
        }
    }
}