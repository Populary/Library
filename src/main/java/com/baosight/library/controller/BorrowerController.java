package com.baosight.library.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baosight.library.domain.Borrower;
import com.baosight.library.service.BorrowerService;
import com.baosight.library.util.Paging;

@Controller
public class BorrowerController {
	
	@Autowired
	private BorrowerService borrowerService;
	
	@RequestMapping(value = "/content/borrowers", method = RequestMethod.GET)
	@ResponseBody
	public HashMap<String, Object> login(HttpServletRequest httpServletRequest) {
		
		String start=httpServletRequest.getParameter("start");
		String length=httpServletRequest.getParameter("length");
		
		HashMap<String,Object> map=Paging.page(length, start);
		
		String workno=httpServletRequest.getParameter("columns[1][search][value]");
		String name=httpServletRequest.getParameter("columns[2][search][value]");
		String dep=httpServletRequest.getParameter("columns[3][search][value]");
		String status=httpServletRequest.getParameter("columns[5][search][value]");

		map.put("workno", workno);
		map.put("name", name);
		map.put("dep", dep);
		map.put("status", status);
		map.put("oreder", "11");
		
		HashMap<String, Object> countmap=new HashMap<String, Object>();
		String count=borrowerService.count(countmap);
		List<Borrower> list =borrowerService.findBorrowers(map);
		
		HashMap<String, Object> resultmap=new HashMap<String, Object>();
//	    resultmap.put("draw", page);
//		map.put("recordsTotal", "5");
//		map.put("recordsFiltered", "111");
		resultmap.put("iTotalRecords", count);
		resultmap.put("iTotalDisplayRecords", count);
		resultmap.put("data", list);
		return resultmap;
	}
	
	@RequestMapping(value = "/content/borrowerlist", method = RequestMethod.GET)
	public String Borrowerlist() {
		//model.addAttribute("borrowerlist", borrowerService.getTypeList());
		return "content/borrowerlist";
	}
	
	
	@RequestMapping(value = "/content/borrower/add", method = RequestMethod.POST)
	@ResponseBody
	public String Borroweradd(HttpServletRequest httpServletRequest) {
		String workno=httpServletRequest.getParameter("add_workno");
		String name=httpServletRequest.getParameter("add_name");
		String dep=httpServletRequest.getParameter("add_dep");
		String tele=httpServletRequest.getParameter("add_tele");
//		System.out.println(workno);
//		System.out.println(name);
//		System.out.println(dep);
//		System.out.println(tele);
		
		HashMap<String, Object> countmap=new HashMap<String, Object>();
		countmap.put("workno", workno);
		String count=borrowerService.count(countmap);
		if(!count.equals("0"))
			return "99";
		
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("workno", workno);
		map.put("name", name);
		map.put("dep", dep);
		map.put("tele", tele);
		
		try {
			borrowerService.addBorrower(map);
			return "0";
		} catch (Exception e) {
			// TODO: handle exception
			return "1";
		}
	}
	
	
	@RequestMapping(value = "/content/borrower/update", method = RequestMethod.POST)
	@ResponseBody
	public String Borrowerupdate(HttpServletRequest httpServletRequest) {
		String name=httpServletRequest.getParameter("update_name");
		String id=httpServletRequest.getParameter("update_id");
		String tele=httpServletRequest.getParameter("update_tele");
		String dep=httpServletRequest.getParameter("update_dep");
//		System.out.println(name);
//		System.out.println(id);
//		System.out.println(tele);
//		System.out.println(dep);
		
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("name", name);
		map.put("id", id);
		map.put("tele", tele);
		map.put("dep", dep);
		try {
			borrowerService.updateBorrower(map);
			return "0";
		} catch (Exception e) {
			// TODO: handle exception
			return "1";
		}
	}
	

}
