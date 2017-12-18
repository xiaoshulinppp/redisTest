package com.liu.redisTest.servcie.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.liu.redisTest.IDao.UserDao;
import com.liu.redisTest.domain.UserVO;
import com.liu.redisTest.intercept.Page;
import com.liu.redisTest.servcie.UserService;



@Service("userService")
@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class) 
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserDao userDao;
    
   //@CacheEvict(value="User",key="addUser",allEntries=true) 
    public void addUser(UserVO user) {
    	/*UserVO user2=new UserVO();
    	user2.setUsername("ffff");
    	user2.setPassword("123");
    	user2.setAge(23);
    	userDao.addUser(user2);*/
        userDao.addUser(user);
        
        
      // throw new RuntimeException("抛出个运行时异常");
    }

    @CacheEvict(value = {"getUser", "getUserById"}, allEntries = true)  
    public void deleteUser(UserVO user) {
        userDao.deleteUser(user);
    }

    @CacheEvict(value = {"getUser", "getUserById"}, allEntries = true)  
    public void updateUser(UserVO user) {
        userDao.updateUser(user);
    }

    @Cacheable(value="User",key="getUserById")
    public UserVO getUserById(int id) {
        return userDao.getUserById(id);
    }
    
    @Cacheable(value="User",key="'getUser'")
    public UserVO getUser(int id) {
        return userDao.getUser(id);
    }

	public List<UserVO> findPage(Page page) {
		// TODO Auto-generated method stub
		return userDao.findPage(page);
	}
    
    
    
    
    

}