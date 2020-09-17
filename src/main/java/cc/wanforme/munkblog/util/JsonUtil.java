package cc.wanforme.munkblog.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/** Json工具类
 * @author wanne
 * 2020年4月26日
 * 
 */
public class JsonUtil {
	private static final ThreadLocal<ObjectMapper> mappers = ThreadLocal.withInitial( ()-> {
		return new ObjectMapper();
	});
	
	public static String toJsonString(Object object) throws JsonProcessingException {
		ObjectMapper mapper = mappers.get();
		return mapper.writeValueAsString(object);
	}
	
	public static <T> T jsonToObject(String content, Class<T> clazz) throws JsonProcessingException {
		ObjectMapper mapper = mappers.get();
		return mapper.readValue(content, clazz);
	}
	
}
