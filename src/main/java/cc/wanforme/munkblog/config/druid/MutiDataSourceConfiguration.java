package cc.wanforme.munkblog.config.druid;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;

/** 使用多数据源，一定要检查这里和yml文件中的配置<br>
 * 注：使用多数据源请放开 @Configuration, 同时关闭另一个类 - DatabaseConfiguration
 * @author wanne
 * 2020年4月22日
 * 
 */
//@Configuration
// 我用了 mybatis-plus，包扫描 和 mapper另外配置
//@MapperScan(basePackages = DruidDataSourceConfiguration.PACKAGE, sqlSessionFactoryRef="defaultSqlSessionFactory")
public class MutiDataSourceConfiguration {

//	public static final String PACKAGE = "cc.wanforme.cs.base.mapper";
//	public static final String MAPPER_LOCATION = "classpath:mapper/**/*.xml";
	// 多数据源的时候，注意区分mapper的xml位置
	// public static final String
	// MAPPER_LOCATION="classpath:mapper/master/**/*.xml";

	@Value("${master.datasource.url}")
	private String url;

	@Value("${master.datasource.username}")
	private String username;

	@Value("${master.datasource.password}")
	private String password;

	@Value("${master.datasource.driverClassName}")
	private String driverClassName;

	// 通用数据库配置
	@Value("${spring.datasource.druid.initial-size}")
	private int initialSize;

	@Value("${spring.datasource.druid.min-idle}")
	private int minIdle;

	@Value("${spring.datasource.druid.max-active}")
	private int maxActive;

	@Value("${spring.datasource.druid.max-wait}")
	private int maxWait;

	@Value("${spring.datasource.druid.time-between-eviction-runs-millis}")
	private int timeBetweenEvictionRunsMillis;

	@Value("${spring.datasource.druid.min-evictable-idle-time-millis}")
	private int minEvictableIdleTimeMillis;

	@Value("${spring.datasource.druid.validation-query}")
	private String validationQuery;

	@Value("${spring.datasource.druid.test-while-idle}")
	private boolean testWhileIdle;

	@Value("${spring.datasource.druid.test-on-borrow}")
	private boolean testOnBorrow;

	@Value("${spring.datasource.druid.test-on-return}")
	private boolean testOnReturn;

	@Value("${spring.datasource.druid.pool-prepared-statements}")
	private boolean poolPreparedStatements;

	@Value("${spring.datasource.druid.max-pool-prepared-statement-per-connection-size}")
	private int maxPoolPreparedStatementPerConnectionSize;

	@Value("${spring.datasource.druid.filters}")
	private String filters;

	@Value("${spring.datasource.druid.connection-properties}")
	private String connectionProperties;

	
	@Value("${mybatis-plus.mapper-locations}")
	private String mapper_locations;
	
	/** 下划线转驼峰命名*/
	@Value("${mybatis-plus.configuration.map-underscore-to-camel-case}")
	private boolean mapUnderscoreToCamelCase;
	/*日志输出*/
	@Value("${mybatis-plus.configuration.log-impl}")
	private String logImpl;
	
	
	
	
//	@Bean(name = "masterDataSource")
	@Bean(name = "defaultDb")
	@Primary
	public DataSource masterDataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setDriverClassName(driverClassName);
		
		this.defaultDataSourceProperties(dataSource);
		
		return dataSource;
	}
	
	/** druid 连接池DataSource通用属性补全 */
	private void defaultDataSourceProperties(DruidDataSource dataSource) {
		// 具体配置
		dataSource.setInitialSize(initialSize);
		dataSource.setMinIdle(minIdle);
		dataSource.setMaxActive(maxActive);
		dataSource.setMaxWait(maxWait);
		dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
		dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
		dataSource.setValidationQuery(validationQuery);
		dataSource.setTestWhileIdle(testWhileIdle);
		dataSource.setTestOnBorrow(testOnBorrow);
		dataSource.setTestOnReturn(testOnReturn);
		dataSource.setPoolPreparedStatements(poolPreparedStatements);
		dataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
		try {
			dataSource.setFilters(filters);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dataSource.setConnectionProperties(connectionProperties);
	}

//	@Bean(name = "masterTransactionManager")
	@Bean(name = "defaultTransactionManager")
	@Primary
	public DataSourceTransactionManager masterTransactionManager() {
		return new DataSourceTransactionManager(masterDataSource());
	}

//	@Bean(name = "masterSqlSessionFactory")
	@SuppressWarnings("unchecked")
	@Bean(name = "defaultSqlSessionFactory")
	@Primary
	public SqlSessionFactory masterSqlSessionFactory(@Qualifier("defaultDb") DataSource masterDataSource)
			throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(masterDataSource);
//		sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
//		System.out.println("mapper_locations: " + mapper_locations);
		sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapper_locations));
		
		MybatisConfiguration configuration = new MybatisConfiguration();
		configuration.setMapUnderscoreToCamelCase(mapUnderscoreToCamelCase);
		configuration.setLogImpl((Class<? extends Log>) Class.forName(logImpl));
		
		sessionFactory.setConfiguration(configuration);
		return sessionFactory.getObject();
	}
	
    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
	
}
	
