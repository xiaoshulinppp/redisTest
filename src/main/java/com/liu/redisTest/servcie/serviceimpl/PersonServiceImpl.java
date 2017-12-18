package com.liu.redisTest.servcie.serviceimpl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.liu.redisTest.IDao.UserDao;
import com.liu.redisTest.domain.person;
import com.liu.redisTest.servcie.PersonService;
import com.liu.redisTest.IDao.personMapper;
@Service("personService")
@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class) 
public class PersonServiceImpl implements PersonService{
	@Autowired
    private personMapper personMapper;
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return  personMapper.deleteByPrimaryKey(id);
		}

	public int insert(person record) {
		// TODO Auto-generated method stub
		return personMapper.insert(record);
	}

	public int insertSelective(person record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public person selectByPrimaryKey(Long id) {
		
		return personMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(person record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByPrimaryKey(person record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<person> selectByxiaoyu(Long key) {
		// TODO Auto-generated method stub
		return personMapper.selectByxiaoyu(key);
	}

	public person selectByzhonghe(Long id) {
		// TODO Auto-generated method stub
		return personMapper.selectByzhonghe(id);
	}

	public List<Map<String, Object>> selecthashmap(Long key) {
		return personMapper.selecthashmap(key);
	}

	public List<Integer> selectID() {
		return personMapper.selectID();
	}

	public List<person> selecAll(Long id) {
		
		return personMapper.selecAll(id);
	}

	public List<person> findperson(RowBounds rowBound) {
		// TODO Auto-generated method stub
		return personMapper.findperson(rowBound);
	}

	public List<person> findperson2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return personMapper.findperson2(map);
	}

}
