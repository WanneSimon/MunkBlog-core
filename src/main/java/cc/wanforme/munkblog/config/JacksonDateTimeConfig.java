package cc.wanforme.munkblog.config;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

/** jackson 时间和日期配置
 * @author wanne
 * 2020年9月18日
 */
@Configuration
public class JacksonDateTimeConfig {

	@Bean
	public MappingJackson2HttpMessageConverter customJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter jsonConverter=new MappingJackson2HttpMessageConverter();
        ObjectMapper objectMapper=new ObjectMapper();
        
        JavaTimeModule module=new JavaTimeModule();
        module.addSerializer(LocalDateTime.class,new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        module.addDeserializer(LocalDateTime.class,new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        module.addSerializer(LocalDate.class,new LocalDateSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        module.addDeserializer(LocalDate.class,new LocalDateDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        
        objectMapper.registerModule(module);
        jsonConverter.setObjectMapper(objectMapper);
        return jsonConverter;		
	}

}
