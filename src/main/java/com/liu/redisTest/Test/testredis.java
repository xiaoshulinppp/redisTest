package com.liu.redisTest.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.liu.redisTest.domain.UserVO;
import com.liu.redisTest.domain.person;
import com.liu.redisTest.intercept.Page;
import com.liu.redisTest.servcie.PersonService;
import com.liu.redisTest.servcie.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class testredis {
	
	//@Resource(name = "personService")
	private PersonService personService = null;
//	@Resource(name = "userService")
	private	UserService userService =null;
	
	
    public void findUser() {
		
		Page page =new Page();
		page.setPageNo(2);
		List<UserVO> userlist=userService.findPage(page);
       // List<User> users = userMapper.findPage(page);
        page.setResults(userlist);
        System.out.println(page);
		
	}

	public void testHash (){
		HashMap hashmap=new HashMap();
		// * @see SortedSet
		// * @see HashSet
		// * @see TreeSet
	  Set HashSet	=hashmap.keySet();
	  
	}
	@Test
	public void moapao(){
		
		int[] unsorted = { 6, 2, 4, 1, 5, 9 };
		 for (int i = 0; i < unsorted.length; i++)
	        {
	            for (int j = i; j < unsorted.length; j++)
	            {
	                if (unsorted[i] > unsorted[j])
	                {
	                    int temp = unsorted[i];
	                    unsorted[i] = unsorted[j];
	                    unsorted[j] = temp;
	                }
	            }
	        }
		System.out.println(unsorted);
		
	}
	
	
	public void testCache() throws IOException{
		
		userService.getUser(1);
		System.out.println(userService.getUser(1));
		System.out.println(userService.getUser(1));
		System.out.println(userService.getUser(1));
		System.out.println(userService.getUser(1));
		
		
		person person2= personService.selectByPrimaryKey(1L);
		 
		/* List <Map<String,Object>>list4=personService.selecthashmap(1L);
           for(Map<String,Object> map:list4){
           	System.out.println(map.get("ID")) ;
           	System.out.println(map.get("NAME")) ;
           	System.out.println(map.get("AGE")) ;
           	}
           	
           List<Integer> list5=personService.selectID();
           for(Integer intid:list5){
           	System.out.println(intid);
           }
           
		List list= personService.selectByxiaoyu(50L);*/
		/*System.out.println(list);*/
		//public static byte[] serialize(Object object) {
		 List<person> person=	personService.selecAll(1L);
			
			List list= personService.selectByxiaoyu(38L);
			System.out.println(personService.selectByxiaoyu(38L));
			System.out.println(personService.selectByxiaoyu(38L));
			System.out.println(personService.selectByxiaoyu(38L));
			System.out.println(personService.selectByxiaoyu(38L));
			//personService.deleteByPrimaryKey(1L);
			
			System.out.println(personService.selectByxiaoyu(38L));
			System.out.println(list);
		
		
			ObjectOutputStream oos = null;
			ByteArrayOutputStream baos = null;
		//	try {
				// 序列化
				baos = new ByteArrayOutputStream();
				oos = new ObjectOutputStream(baos);
				oos.writeObject(person2);
				byte[] bytes = baos.toByteArray();
				System.out.println(bytes);
				
			//	return bytes;
		//	} catch (Exception e) {
			//	e.printStackTrace();
		//	}
		//	return null;
		//}

		/*public static Object unserialize(byte[] bytes) {
			if (bytes == null)
				return null;
		*/	ByteArrayInputStream bais = null;
			try {
				// 反序列化
				bais = new ByteArrayInputStream(bytes);
				ObjectInputStream ois = new ObjectInputStream(bais);
				//return 
				person o=(person)ois.readObject();
				
				System.out.println(o.getName());
				
				System.out.println(o.getAge());
			//	 ObjectInputStream ois = new ObjectInputStream(fis);  
				  // Student st1 = (Student) ois.readObject();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	/**
     * 逻辑分页，实现过程：先把所有数据都查出来，再从内存中从0开始，取3条数据；
     */
  
    public void findperson() {
      //  logger.info("查询学生逻辑分页");
        int offset = 0;            //start；开始
        int limit = 3;            //limit： 每页大小；
        RowBounds rowBound = new RowBounds(offset, limit);    //RowBounds里面有分页信息
        List<person> personList=personService.findperson(rowBound);
        for(person person:personList){
            System.out.println(person);
        }
    }
    

    public void findperson2() {
       // logger.info("查询学生物理分页");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("start", 0);
        map.put("size", 3);
        List<person> personList=personService.findperson2(map);
        for(person person:personList){
            System.out.println(person);
        }
    }
	
	
	
	
}
