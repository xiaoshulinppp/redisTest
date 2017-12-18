package com.liu.redisTest.IDao;

import com.liu.redisTest.domain.address;

public interface addressMapper {
    int countByExample(address example);

    int deleteByPrimaryKey(Long id);

    int insert(address record);

    int insertSelective(address record);

    address selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(address record);

    int updateByPrimaryKey(address record);
}