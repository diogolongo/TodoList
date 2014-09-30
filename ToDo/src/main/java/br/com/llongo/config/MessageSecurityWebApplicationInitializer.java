package br.com.llongo.config;

import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class MessageSecurityWebApplicationInitializer
      extends AbstractSecurityWebApplicationInitializer {
	public MessageSecurityWebApplicationInitializer() {
        super(SecurityConfig.class);
    }
}