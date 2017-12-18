package com.liu.redisTest.Test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.xml.registry.infomodel.User;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.liu.redisTest.domain.UserVO;
import com.liu.redisTest.domain.events;
import com.liu.redisTest.domain.person;
import com.liu.redisTest.redis.RedisUtil;
import com.liu.redisTest.servcie.PersonService;
import com.liu.redisTest.servcie.UserService;

public class Testmybatis {
	private static Logger logger = Logger.getLogger(Testmybatis.class);
	
	//@Resource这样注入不进来，想要注入进来需要配置注解扫描。
	//private SessionFactory sessionFactory;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}


	public void test() {
		 ApplicationContext testContext = new ClassPathXmlApplicationContext("applicationContext.xml");  
		 PersonService personService = (PersonService)testContext.getBean("personService");  

		 /*redisUtil.put("test", "nihao");
		System.out.println(redisUtil.get("test")); */
		 List<person> person=	personService.selecAll(1L);
		
		List list= personService.selectByxiaoyu(1L);
		System.out.println(list);
		
		//. events ev =person.getEvents();
		 /*person person2= personService.selectByPrimaryKey(1L);
		 
		 List <Map<String,Object>>list4=personService.selecthashmap(1L);
            for(Map<String,Object> map:list4){
            	System.out.println(map.get("ID")) ;
            	System.out.println(map.get("NAME")) ;
            	System.out.println(map.get("AGE")) ;
            	}
            	
            List<Integer> list5=personService.selectID();
            for(Integer intid:list5){
            	System.out.println(intid);
            }
            
		List list= personService.selectByxiaoyu(50L);
		System.out.println(list);
		
	     person person=	personService.selectByzhonghe(1L);
		//. events ev =person.getEvents();
		 
		 List listadd=person.getAddress();
		 System.out.println();*/
		//UserService userService2 = (UserService) BeanFactory.getInstance().getBean("userService2");
		// BeanFactory.getInstance().getBean("messageService")
	//	userService.addUser(null);
		
		// assertNotNull(userService);  
		 //UserVO user = (UserVO)testService.getUserById(1);
		/* UserVO user=new UserVO();
		 user.setUsername("你好啊啊啊啊");
		
		 testService.addUser(user);
		 UserVO user3= testService.getUserById(1);
		 System.out.println(user3.getUsername());
		 System.out.println(user.getPassword());*/
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
	

}
