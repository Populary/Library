package com.baosight.library.util;

import java.util.HashMap;

import org.springframework.util.StringUtils;

public class Paging {
	
	public static HashMap<String,Object> page(String length,String start){
		
		HashMap<String,Object> map=new HashMap<>();
		
	    String page;
		
		if(length==null||StringUtils.isEmpty(length)){
			length="10";
		}
			
		if(start==null||StringUtils.isEmpty(start)){
			page="1";
		}
		else{
			page=Integer.parseInt(start)/Integer.parseInt(length)+1+"";
		}
		
		map.put("limit", length);
		map.put("offset", (Integer.parseInt(page)-1)*Integer.parseInt(length));
		
		return map;
		
	}

	
}
