package com.baosight.library.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baosight.library.domain.Book;
import com.baosight.library.service.BookService;
import com.baosight.library.util.Paging;

@Controller
public class LendingController {
	
	@Autowired
	private BookService bookService;
	
//	@RequestMapping(value = "/content/books", method = RequestMethod.GET)
//	@ResponseBody
//	public HashMap<String, Object> login(HttpServletRequest httpServletRequest) {
//		
//		//System.out.println("88888888888888888888888888888888");
//
//		String start=httpServletRequest.getParameter("start");
//		String length=httpServletRequest.getParameter("length");
//		
//		HashMap<String,Object> map=Paging.page(length, start);
//		
//		String bookno=httpServletRequest.getParameter("columns[1][search][value]");
//		String bookname=httpServletRequest.getParameter("columns[2][search][value]");
//		String booktype=httpServletRequest.getParameter("columns[3][search][value]");
//		String bookstatus=httpServletRequest.getParameter("columns[7][search][value]");
//
//		map.put("bookno", bookno);
//		map.put("bookname", bookname);
//		map.put("booktype", booktype);
//		map.put("bookstatus", bookstatus);
//		map.put("oreder", "11");
//		
//		HashMap<String, Object> countmap=new HashMap<String, Object>();
//		String count=bookService.count(countmap);
//		List<Book> list =bookService.findBooks(map);
//		
//		HashMap<String, Object> resultmap=new HashMap<String, Object>();
////	    resultmap.put("draw", page);
////		map.put("recordsTotal", "5");
////		map.put("recordsFiltered", "111");
//		resultmap.put("iTotalRecords", count);
//		resultmap.put("iTotalDisplayRecords", count);
//		resultmap.put("data", list);
//		return resultmap;
//	}
	
	@RequestMapping(value = "/content/lending", method = RequestMethod.GET)
	public String booklist() {
		return "content/lending";
	}
	
//	
//	@RequestMapping(value = "/content/book/add", method = RequestMethod.POST)
//	@ResponseBody
//	public String bookadd(HttpServletRequest httpServletRequest) {
//		String bookno=httpServletRequest.getParameter("add_bookno");
//		String bookname=httpServletRequest.getParameter("add_bookname");
//		String booktype=httpServletRequest.getParameter("add_booktype");
//		String bookauthor=httpServletRequest.getParameter("add_bookauthor");
////		System.out.println(bookno);
////		System.out.println(bookname);
////		System.out.println(booktype);
////		System.out.println(bookauthor);
//		
//		HashMap<String, Object> countmap=new HashMap<String, Object>();
//		countmap.put("bookno", bookno);
//		String count=bookService.count(countmap);
//		if(!count.equals("0"))
//			return "99";
//		
//		HashMap<String, Object> map=new HashMap<String, Object>();
//		map.put("bookno", bookno);
//		map.put("bookname", "《"+bookname+"》");
//		map.put("booktype", booktype);
//		map.put("bookauthor", bookauthor);
//		
//		try {
//			bookService.addBook(map);
//			return "0";
//		} catch (Exception e) {
//			// TODO: handle exception
//			return "1";
//		}
//	}
//	
//	
//	@RequestMapping(value = "/content/book/update", method = RequestMethod.POST)
//	@ResponseBody
//	public String bookupdate(HttpServletRequest httpServletRequest) {
//		String bookid=httpServletRequest.getParameter("add_bookid");
//		String bookname=httpServletRequest.getParameter("add_bookname");
//		String booktype=httpServletRequest.getParameter("add_booktype");
//		String bookauthor=httpServletRequest.getParameter("add_bookauthor");
////		System.out.println(bookno);
////		System.out.println(bookname);
////		System.out.println(booktype);
////		System.out.println(bookauthor);
//		
//		HashMap<String, Object> map=new HashMap<String, Object>();
//		map.put("bookid", bookid);
//		//map.put("bookno", bookno);
//		map.put("bookname", "《"+bookname+"》");
//		map.put("booktype", booktype);
//		map.put("bookauthor", bookauthor);
//		try {
//			bookService.updateBook(map);
//			return "0";
//		} catch (Exception e) {
//			// TODO: handle exception
//			return "1";
//		}
//	}
	

}
