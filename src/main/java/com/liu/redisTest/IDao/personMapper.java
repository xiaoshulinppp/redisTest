package com.liu.redisTest.IDao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.liu.redisTest.domain.person;

public interface personMapper {
    
	public int deleteByPrimaryKey(Long id);

	public int insert(person record);

    public int insertSelective(person record);

    public person selectByPrimaryKey(Long id);
    
    public int updateByPrimaryKeySelective(person record);

    public int updateByPrimaryKey(person record);
    
    public List<person> selectByxiaoyu (Long key);
    
    public List<Map<String,Object>> selecthashmap (Long key);
    
    public List<Integer> selectID();
    public  person selectByzhonghe(Long id);
    public List<person> selecAll(Long id);
  //逻辑分页 RowBounds里面有分页信息
       public List<person> findperson(RowBounds rowBound);
        
       //物理分页
       public List<person> findperson2(Map<String, Object> map);
    
    
    
}