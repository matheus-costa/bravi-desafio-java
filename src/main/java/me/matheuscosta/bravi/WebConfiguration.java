package me.matheuscosta.bravi;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration {
	@Bean
	@SuppressWarnings("rawtypes")
    ServletRegistrationBean h2servletRegistration(){
        @SuppressWarnings("unchecked")
		ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
        registrationBean.addUrlMappings("/h2/*");
        return registrationBean;
    }
}
