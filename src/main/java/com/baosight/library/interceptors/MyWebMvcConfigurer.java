package com.baosight.library.interceptors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


@Configuration
public class MyWebMvcConfigurer extends WebMvcConfigurationSupport {
	
	    @Override
	    public void addInterceptors(InterceptorRegistry registry) {

	        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/content/**");

//	        registry.addInterceptor(new TwoInterceptor()).addPathPatterns("/one/**")
//	                                                     .addPathPatterns("/two/**");


	        super.addInterceptors(registry);
	    }
	    
	    
	    @Override
	    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
	    // TODO Auto-generated method stub
	    	
	    	registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
	        super.addResourceHandlers(registry);
	    }
}
