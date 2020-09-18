package cc.wanforme.coorush;

import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

public class CmCodeGenerator {
	
	
	public static void main(String[] args) {
		String[] tables = {
//				"blog", "blog_quotation", "book", "bookmark", "comic_words", "daily_log",
//				"efile", "game", "image_file", "munk_tag", 
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
		packageCfg.setParent("cc.wanforme.munkblog");
		packageCfg.setModuleName("base");
		generator.setPackageInfo(packageCfg);
		
	      // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                String path = projectPath + "/src/main/resources/mapper/" + packageCfg.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
                return path;
            }
        });
        cfg.setFileOutConfigList(focList);
		
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
		
		System.out.println("finished");
	}
	
	private static DataSourceConfig dataSourceConfig() {
		DataSourceConfig config = new DataSourceConfig();
		config.setDriverName("com.mysql.jdbc.Driver");
		config.setUrl("jdbc:mysql://localhost:3306/MunkBlog?useUnicode=true&characterEncoding=UTF-8&atuoReconnect=true&serverTimezone=GMT%2B8");
		config.setUsername("root");
		config.setPassword("wansmmecc");
		config.setSchemaName("cmcore");
		return config;
	}
	
}

