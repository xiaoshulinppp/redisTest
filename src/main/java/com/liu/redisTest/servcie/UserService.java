package com.liu.redisTest.servcie;

import java.util.List;

import com.liu.redisTest.domain.UserVO;
import com.liu.redisTest.intercept.Page;

public interface UserService {
    
        public void addUser(UserVO user);
        
        public void deleteUser(UserVO user);
        
        public void updateUser(UserVO user);
        
        public UserVO getUserById(int id);
        
        public UserVO getUser(int id);
        public List<UserVO> findPage(Page page);
}