package cn.ling.medicalview.utils.shiroutil;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Shiro的配置类
 * 加入依赖- 配置- 直接使用
 * @author lenovo
 *
 */
@Configuration
public class ShiroConfig {

	/**
	 * 创建ShiroFilterFactoryBean
	 */
	@Bean
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager securityManager){
        System.out.println("进入了ShiroFilterFactoryBean");
	    ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		//设置安全管理器
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		//添加 Shiro内置过滤器
		/**
		 * Shiro内置过滤器，可以实现权限相关的拦截器
		 *    常用的过滤器：
		 *       anon: 无需认证（登录）可以访问
		 *       authc: 必须认证才可以访问
		 *       user: 如果使用rememberMe的功能可以直接访问
		 *       perms： 该资源必须得到资源权限才可以访问
		 *       role: 该资源必须得到角色权限才可以访问
		 */
		Map<String,String> filterMap = new LinkedHashMap<String,String>();
		//无需认证（登录）可以访问
		filterMap.put("/portal/*", "anon");
        filterMap.put("/index", "anon");
        filterMap.put("/login", "anon");
        filterMap.put("/psd", "anon");
        filterMap.put("/register", "anon");
        filterMap.put("/success", "anon");
		//必须认证才可以访问
		filterMap.put("/admin/*", "authc");
		//授权过滤器
		//注意：当前授权拦截后，shiro会自动跳转到未授权页面
        //admin:adminTY  授权字符串
		//filterMap.put("/admin/*", "perms[1]");
        //filterMap.put("/admin/*", "perms[admin:adminY]");
		//filterMap.put("/update", "perms[user:update]");
		
		//修改调整的登录页面
		shiroFilterFactoryBean.setLoginUrl("/login.html");
		//设置未授权提示页面
		shiroFilterFactoryBean.setUnauthorizedUrl("/noAuth");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
		return shiroFilterFactoryBean;
	}
	
	/**
	 * 创建DefaultWebSecurityManager
	 */
	@Bean(name="securityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm){
        System.out.println("进入了DefaultWebSecurityManager");
	    DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		//关联realm
		securityManager.setRealm(userRealm);
		return securityManager;
	}
	
	/**
	 * 创建Realm
	 */
	@Bean(name="userRealm")
	public UserRealm getRealm(){
        System.out.println("进入了UserRealm");
		return new UserRealm();
	}
	
	/**
	 * 配置ShiroDialect，用于thymeleaf和shiro标签配合使用
	 */
	@Bean
	public ShiroDialect getShiroDialect(){
        System.out.println("进入了ShiroDialect");
		return new ShiroDialect();
	}
}
