package com.baosight.library.interceptors;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{
	 /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
    	HttpSession session = httpServletRequest.getSession();
    	
    	if(session.getAttribute("baosightlogin") == null)
    		return false;
    	
        if ((boolean) session.getAttribute("baosightlogin")) { 
        	return true;
        }
        httpServletResponse.sendRedirect("/login");  
        System.out.println("===============登录验证拦截器==================");
        return false;
    }

    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

//    public void returnErrorResponse(HttpServletResponse response, LeeJSONResult result) throws IOException, UnsupportedEncodingException {
//        OutputStream out = null;
//        try{
//            response.setCharacterEncoding("utf-8");
//            response.setContentType("text/json");
//            out = response.getOutputStream();
//            out.write(JsonUtils.objectToJson(result).getBytes("utf-8"));
//            out.flush();
//        } finally{
//            if(out!=null){
//                out.close();
//            }
//        }
//    }
    
}
