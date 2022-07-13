package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.gcu.business.ProductsBusinessInterface;
import com.gcu.business.ProductsBusinessService;
import com.gcu.business.UsersBusinessInterface;
import com.gcu.business.UsersBusinessService;

@Configuration
public class SpringConfig
{
	@Bean(name="usersBusinessService", initMethod="init", destroyMethod="destroy")
	@Scope(value="prototype", proxyMode=ScopedProxyMode.TARGET_CLASS)
	@SessionScope
	public UsersBusinessInterface getUsersBusiness()
	{
		//Specify which service class to use as configuration
		return new UsersBusinessService();
	}
	
	@Bean(name="productsBusinessService", initMethod="init", destroyMethod="destroy")
	@Scope(value="prototype", proxyMode=ScopedProxyMode.TARGET_CLASS)
	@SessionScope
	public ProductsBusinessInterface getProductsBusiness()
	{
		//Specify which service class to use as configuration
		return new ProductsBusinessService();
	}
}
