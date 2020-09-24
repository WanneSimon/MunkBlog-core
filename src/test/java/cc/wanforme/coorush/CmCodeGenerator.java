//package cc.wanforme.coorush;
//
//import java.io.File;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.baomidou.mybatisplus.core.toolkit.StringPool;
//import com.baomidou.mybatisplus.generator.AutoGenerator;
//import com.baomidou.mybatisplus.generator.InjectionConfig;
//import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
//import com.baomidou.mybatisplus.generator.config.FileOutConfig;
//import com.baomidou.mybatisplus.generator.config.GlobalConfig;
//import com.baomidou.mybatisplus.generator.config.PackageConfig;
//import com.baomidou.mybatisplus.generator.config.StrategyConfig;
//import com.baomidou.mybatisplus.generator.config.TemplateConfig;
//import com.baomidou.mybatisplus.generator.config.po.TableInfo;
//import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
//import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
//
//public class CmCodeGenerator {
//	
//	
//	public static void main(String[] args) {
//		String[] tables = {
////				"blog", "blog_quotation", "book", "bookmark", "comic_words", "daily_log",
////				"efile", "game", "image_file", "munk_tag", 
////				"user"
//				"bookmark_folder"
//		};
//		
//		AutoGenerator generator = new AutoGenerator();
//		
//		// 全局配置
//		GlobalConfig global = new GlobalConfig();
//		String projectPath = System.getProperty("user.dir");
//		global.setOutputDir(projectPath+"/src/main/java");
//		global.setAuthor("wanne");
//		global.setOpen(true);
//		global.setSwagger2(true);
//		
//		generator.setGlobalConfig(global);
//		
//		// 数据源配置
//		generator.setDataSource(dataSourceConfig());
//	
//		// 包配置
//		PackageConfig packageCfg = new PackageConfig();
//		packageCfg.setParent("cc.wanforme.munkblog");
//		packageCfg.setModuleName("base");
//		generator.setPackageInfo(packageCfg);
//		
//		// 自定义模板配置
//		InjectionConfig customConfigs = customConfigs(projectPath, packageCfg);
//		generator.setCfg(customConfigs);
//        
//        // 策略配置
//        StrategyConfig strategy = new StrategyConfig();
//        strategy.setNaming(NamingStrategy.underline_to_camel); // 表名下划线转驼峰
//        strategy.setColumnNaming(NamingStrategy.underline_to_camel); // 列名下划线转驼峰
//        strategy.setRestControllerStyle(true);
//        strategy.setInclude(tables); //表
//        strategy.setControllerMappingHyphenStyle(true);
//        generator.setStrategy(strategy);
//        
//        // 不适用自定义模板时，使用这个默认的即可
//        // generator.setTemplateEngine(new FreemarkerTemplateEngine());
//        
//        // 自定义模板配置
//        // 放置自己项目的 src/main/resources/templates 目录下, 默认名称一下可以不配置，也可以自定义模板名称
//        TemplateConfig tc = new TemplateConfig();
//        tc.setController("templates/controller.java.vm");
//        tc.setService("templates/service.java.vm");
//        tc.setServiceImpl("templates/serviceImpl.java.vm");
//        tc.setEntity("templates/entity.java.vm");
//        tc.setMapper("templates/mapper.java.vm");
//        tc.setXml("templates/mapper.xml.vm");
//        generator.setTemplate(tc);
//        
//        // 执行
//		generator.execute();
//		
//		System.out.println("finished");
//		
//		// 自定义 xml 位置后，删除默认生成的
//		// 注意，会删除整个  mapper/xml/文件夹
//		String basePath = (projectPath+"/src/main/java/"+packageCfg.getParent()).replace('.', '/').replace('\\', '/')
////			+"/"+packageCfg.getModuleName()+"/mapper/xml/";
//		   +"/mapper/xml/";
//		File folder = new File(basePath);
//		File[] fs = folder.listFiles();
//		if(fs!=null) {
//			for (File file : fs) {
//				file.delete();
//			}
//		}
//		folder.delete();
//		System.out.println("删除成功！"+basePath);
//	}
//	
//	/** 数据源*/
//	private static DataSourceConfig dataSourceConfig() {
//		DataSourceConfig config = new DataSourceConfig();
//		config.setDriverName("com.mysql.jdbc.Driver");
//		config.setUrl("jdbc:mysql://localhost:3306/MunkBlog?useUnicode=true&characterEncoding=UTF-8&atuoReconnect=true&serverTimezone=GMT%2B8");
//		config.setUsername("root");
//		config.setPassword("wansmmecc");
//		config.setSchemaName("cmcore");
//		return config;
//	}
//
//	/** 自定义模板配置*/
//	private static InjectionConfig customConfigs(String projectPath, PackageConfig packageCfg ) {
//	    // 自定义配置
//        InjectionConfig cfg = new InjectionConfig() {
//            @Override
//            public void initMap() {
//                // to do nothing
//            }
//        };
//        // 自定义输出配置
//        List<FileOutConfig> focList = new ArrayList<>();
//        cfg.setFileOutConfigList(focList);
//        
//        // xml输出重新配置
//        String xmlTtemplate = "templates/mapper.xml.vm";
//        // 自定义配置会被优先输出
//        focList.add(new FileOutConfig(xmlTtemplate) {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
//                String path = projectPath + "/src/main/resources/mapper/" + packageCfg.getModuleName()
//                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
//                return path;
//            }
//        });
//        
//        
//        
//       return cfg;
//	}
//	
//}
//
