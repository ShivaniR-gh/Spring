package com.xworkz.app.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MedicineWeb extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MedicineConfigure.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
