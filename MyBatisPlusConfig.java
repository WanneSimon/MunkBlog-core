package cc.wanforme.cmcore.config;

import org.springframework.context.annotation.Bean;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;

/** mybatis部分配置
 * @author wanne
 * 2020年7月21日
 */
public class MyBatisPlusConfig {

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
	
}
