package cc.wanforme.munkblog.config.druid;

import javax.sql.DataSource;

import org.apache.ibatis.logging.Log;
//import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
//import com.baomidou.mybatisplus.annotation.DbType;
//import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
//import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
//import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
//import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;

/**数据库库配置用的是这个，单数据源<br>
 * @author wanne
 * 2020年4月26日
 * 
 */
@Configuration
public class DatabaseConfiguration {

	/** 如果要这样注入，该路径只能填一个*/
	@Value("${mybatis-plus.mapper-locations}")
	private String mapper_locations;
	
	@Value("${mybatis-plus.type-aliases-package}")
	private String type_aliases_package;
	
	@Value("${mybatis-plus.configuration.map-underscore-to-camel-case}")
	private boolean configuration_map_underscore_to_camel_case;
	
	@Value("${mybatis-plus.configuration.log-impl}")
	private String configuration_log_impl;
	
	
	
	@Primary
	@Bean(name = "datasource")
	@ConfigurationProperties("spring.datasource.druid.default")
	public DataSource datasource() {
		return DruidDataSourceBuilder.create().build();
	}
	
	@Primary
	@Bean(name = "transactionManager")
	public DataSourceTransactionManager transactionManager(@Qualifier("datasource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
	
	// 没有 持久层 就不要使用
	@SuppressWarnings("unchecked")
	@Primary
	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(@Qualifier("datasource") DataSource masterDataSource)
			throws Exception {
//		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//		sessionFactory.setDataSource(masterDataSource);
//		sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapper_locations));
//		return sessionFactory.getObject();

		MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(masterDataSource);

		MybatisConfiguration configuration = new MybatisConfiguration();
		configuration.setJdbcTypeForNull(JdbcType.NULL);
		configuration.setMapUnderscoreToCamelCase(configuration_map_underscore_to_camel_case);
		configuration.setCacheEnabled(false);
		configuration.setLogImpl((Class<? extends Log>) Class.forName(configuration_log_impl));
		sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapper_locations));
		sqlSessionFactory.setConfiguration(configuration);
		
		// PerformanceInterceptor(),OptimisticLockerInterceptor()
		// 添加分页功能 （使用PageHelper，忽略）
//	    sqlSessionFactory.setPlugins(new Interceptor[]{
//	    	mybatisPlusInterceptor()
//	    });
		
	    
	    return sqlSessionFactory.getObject();
	}
	
}
