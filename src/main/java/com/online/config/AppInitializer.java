package com.online.config;

import java.io.File;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.ServletRegistration;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	private int maxUploadSizeInMb = 50 * 1024 * 1024;

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { MvcConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { JpaConfig.class, RepositoryConfig.class };
	}

	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {
		// upload temp file will put here
		File uploadDirectory = new File(System.getProperty("java.io.tmpdir"));
		// register a MultipartConfigElement
		MultipartConfigElement multipartConfigElement = new MultipartConfigElement(uploadDirectory.getAbsolutePath(),
				maxUploadSizeInMb, maxUploadSizeInMb * 2, maxUploadSizeInMb / 2);
		registration.setMultipartConfig(multipartConfigElement);
	}
}
