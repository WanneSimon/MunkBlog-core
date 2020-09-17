package cc.wanforme.munkblog.config.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
 
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

//	@Autowired
//	private DataSource dataSource;

	
	/** 自定义路径的权限*/
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			// 允许所有请求通过，需要自定义参考下面的的配置和前面的注释说明
			.antMatchers("/**").permitAll(); 
		
//			.antMatchers("/static/**").permitAll()
//			.antMatchers("/css/**", "/font/**", "/image/**", "/js/**", "/media/**", 
//					"/script/**", "/style/**", "/view/**"
//					, "favicon.ico", "favicon.png").permitAll()
//			
//			.antMatchers("/", "/index", "/login", "/register").permitAll()
//			.antMatchers("/index.html", "/homepage.html", "/login.html", "/register.html").permitAll();
		
//		http.addFilterAfter(new LoginFilter(), UsernamePasswordAuthenticationFilter.class);
//		http.addFilterAfter(new BlogOwnerFilter(),  UsernamePasswordAuthenticationFilter.class);
		
		http.csrf().disable(); //允许跨域伪造请求
		http.cors().disable();
	}

    
	
}
