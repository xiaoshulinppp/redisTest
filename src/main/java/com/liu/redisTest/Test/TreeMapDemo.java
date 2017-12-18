package com.liu.redisTest.Test;  
  
import java.util.Iterator;  
import java.util.Map;  
import java.util.Map.Entry;  
import java.util.Set;  
import java.util.TreeMap;  
  
//计算字符串中出现的字符个数  
public class TreeMapDemo { 
	private int []  x={11,2,6,9,12,7,12,1,3,12,8};
	private int    max=x[0];
	private int    middle=x[1];
	private int    small=x[2];
	private int [] three=new int[3];
	
	public void tree(){
		//  冒泡排序一下啊吧
		if(max>middle)
		{
			max=three[2];
			
		}else{
			
			middel=three[2];
			
		}
	}
	
	
    public static void main(String[] args) {  
  
            String str="aabbbccdejtljlssd";  
              
            Map map=countChar(str);  
              
            show(map);  
              
    }  
      
    public static Map countChar(String str){  
    	
        char[] buf=str.toCharArray();  
          
        Map<Character, Integer> map=new TreeMap<Character, Integer>();  
          
        for(Character c:buf){  
            if(map.containsKey(c)){  
                map.put(c, map.get(c)+1);  
            }else{  
                map.put(c, 1);  
            }             
        }             
        return map;  
    }  
      
    public  static  void show(Map map){  
        //遍历  
        Set entrySet=map.entrySet();  
        Iterator<Entry> ite=entrySet.iterator();  
        while(ite.hasNext()){  
            Entry entry=ite.next();  
            System.out.println("Key:"+entry.getKey()+" Value:"+entry.getValue());  
        }         
    }  
}  