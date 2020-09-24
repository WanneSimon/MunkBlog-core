package cc.wanforme.munkblog;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.commons.lang3.StringUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
@MapperScan( "cc.wanforme.munkblog.base.mapper" )
public class MunkBlogApplication {
	private static final Logger log = LoggerFactory.getLogger(MunkBlogApplication.class);
	
	private static final String SERVER_SSL_KEY_STORE = "server.ssl.key-store";
	public static String serverFullAddress=""; // 示例: http://169.254.157.168:8020/cm
	private final Environment env;
	
	public MunkBlogApplication(Environment env) {
		this.env = env;
	}
	
	public Environment getEnv() {
		return env;
	}
	
	public static void main(String[] args) {
		Environment env = SpringApplication.run(MunkBlogApplication.class, args).getEnvironment();
		logApplicationStartup(env);
        log.info("\n<<<<<<<<<<<<<<<<\t启动完成\t>>>>>>>>>>>>>>>");
	}

	
    private static void logApplicationStartup(Environment env) {
        String protocol = "http";
        if (env.getProperty(SERVER_SSL_KEY_STORE) != null) {
            protocol = "https";
        }
        String serverPort = env.getProperty("server.port");
        String contextPath = env.getProperty("server.servlet.context-path");
        if (StringUtils.isBlank(contextPath)) {
            contextPath = "/";
        }
        String hostAddress = "localhost";
        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            log.warn("The host name could not be determined, using `localhost` as fallback");
        }
        
        serverFullAddress = protocol + hostAddress + serverPort + contextPath;
        
        log.info("\n----------------------------------------------------------\n\t" +
                "'{}' is running! Access URLs:\n\t" +
                "Local: \t\t{}://localhost:{}{}\n\t" +
                "External: \t{}://{}:{}{}\n\t" +
                "Profile(s): \t{}\n\t" +
                "----------------------------------------------------------",
            env.getProperty("spring.application.name"),
            protocol, serverPort, contextPath,
            protocol, hostAddress, serverPort, contextPath,
            env.getActiveProfiles());
    }

}
