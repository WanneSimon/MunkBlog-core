package cc.wanforme.coorush;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

public class CmCodeGenerator {
	
	
	public static void main(String[] args) {
		String[] tables = {
				"user"
		};
		
		AutoGenerator generator = new AutoGenerator();
		
		// 全局配置
		GlobalConfig global = new GlobalConfig();
		String projectPath = System.getProperty("user.dir");
		global.setOutputDir(projectPath+"/src/main/java");
		global.setAuthor("wanne");
		global.setOpen(true);
		global.setSwagger2(true);
		generator.setGlobalConfig(global);
		
		// 数据源配置
		generator.setDataSource(dataSourceConfig());
	
		// 包配置
		PackageConfig packageCfg = new PackageConfig();
		packageCfg.setParent("cc.wanforme.coorush");
		packageCfg.setModuleName("base");
		generator.setPackageInfo(packageCfg);
		
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel); // 表名下划线转驼峰
        strategy.setColumnNaming(NamingStrategy.underline_to_camel); // 列名下划线转驼峰
        strategy.setRestControllerStyle(true);
        strategy.setInclude(tables); //表
        strategy.setControllerMappingHyphenStyle(true);
        generator.setStrategy(strategy);
        
        // 模板引擎
        generator.setTemplateEngine(new FreemarkerTemplateEngine());
        
        // 执行
		generator.execute();
	}
	
	private static DataSourceConfig dataSourceConfig() {
		DataSourceConfig config = new DataSourceConfig();
		config.setUrl("jdbc:mysql://localhost:3306/CelesteSquirrel?useUnicode=true&characterEncoding=UTF-8&atuoReconnect=true&serverTimezone=GMT%2B8");
		config.setUsername("root");
		config.setPassword("wansmmecc");
		config.setSchemaName("cmcore");
		return config;
	}
	
}

