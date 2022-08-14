package com.shreeganesh.SpringREST3.config;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DeploymentDescriptor extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		Class arr[] = {BeansConfig.class};
		return arr;
	}

	@Override
	protected String[] getServletMappings() {

		String arr[]= {"/"};
		return arr;
	}

}
