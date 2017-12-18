package com.liu.redisTest.IDao;

import com.liu.redisTest.domain.events;

public interface eventsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(events record);

    int insertSelective(events record);

    events selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(events record);

    int updateByPrimaryKey(events record);
}