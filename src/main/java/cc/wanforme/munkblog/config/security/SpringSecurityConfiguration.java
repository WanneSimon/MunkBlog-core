package cc.wanforme.munkblog.config.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//import cc.wanforme.munkblog.authen.filter.CustomAuthenticationFilter;
import cc.wanforme.munkblog.authen.filter.MRememberMeFilter;
import cc.wanforme.munkblog.authen.service.MTokenService;
import cc.wanforme.munkblog.authen.service.UserRoleAuthService;
import cc.wanforme.munkblog.properties.TokenProperty;
 
/**Spring 安全配置
 * @author wanne
 * 2020年4月26日
 * 
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter{
	/*
	 * @EnableGlobalMethodSecurity(prePostEnabled=true) 最后一个注解启用方法级的安全控制，
	 * 控制层方法前加上 @PreAuthorize("hasAuthority('permission')")要求具有permission权限、或@PreAuthorize("hasRole('USER')")要求为USER角色
	 * 
	 */

	private TokenProperty tokenProperty;
	private MTokenService mTokenService;
	private UserRoleAuthService userRoleAuthService;
	
	/** 自定义路径的权限*/
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/**").permitAll();										
//			.logout().logoutUrl("/logout")	
	//				.invalidateHttpSession(true) // 让会话失效
//				    .clearAuthentication(true).permitAll() // 或者清除授权（这样就不用手动调用了）
			// 允许所有请求通过，需要自定义参考下面的的配置和前面的注释说明
//			.and()
//			.and()
//				.formLogin().loginPage("/login");
//			.antMatchers("/static/**").permitAll()
//			.antMatchers("/css/**", "/font/**", "/image/**", "/js/**", "/media/**", 
//					"/script/**", "/style/**", "/view/**"
//					, "favicon.ico", "favicon.png").permitAll()
//			
//			.antMatchers("/", "/index", "/login", "/register").permitAll()
//			.antMatchers("/index.html", "/homepage.html", "/login.html", "/register.html").permitAll();
		
//		http.addFilterAfter(new LoginFilter(), UsernamePasswordAuthenticationFilter.class);
//		http.addFilterAfter(new BlogOwnerFilter(),  UsernamePasswordAuthenticationFilter.class);
		
		//在验证前，将验证信息添加到 SecurityContext 中
		http.addFilterBefore(rememberMeFilter(tokenProperty.getName(), mTokenService, userRoleAuthService), 
				UsernamePasswordAuthenticationFilter.class);
		// 失败了，没研究
//		http.addFilterAt(customAuthenticationFilter(), 
//				UsernamePasswordAuthenticationFilter.class);
		
		http.csrf().disable(); //允许跨域伪造请求
		http.cors().disable();
	}

//	@Bean
	/** 自定义记住我过滤器*/
	public MRememberMeFilter rememberMeFilter(String tokenName,
			MTokenService mTokenService, UserRoleAuthService userRoleAuthService) {
		return new MRememberMeFilter(tokenName, mTokenService, userRoleAuthService);
	}
	/** 自定义验证过滤器*/
//	public CustomAuthenticationFilter customAuthenticationFilter() {
//		return new CustomAuthenticationFilter();
//	}
	
    @Autowired
	public void setTokenProperty(TokenProperty tokenProperty) {
		this.tokenProperty = tokenProperty;
	}
    @Autowired
    public void setmTokenService(MTokenService mTokenService) {
		this.mTokenService = mTokenService;
	}
    @Autowired
    public void setUserRoleAuthService(UserRoleAuthService userRoleAuthService) {
		this.userRoleAuthService = userRoleAuthService;
	}
}
