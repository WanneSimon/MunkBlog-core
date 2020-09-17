package cc.wanforme.munkblog.simpleTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/** redis 单数据源使用
 * @author wanne
 * 2020年5月14日
 * 
 */
@Controller
@RequestMapping("/redis")
public class RedisDataSourceTest {

	@Autowired
	@Qualifier("redisTemplate")
	private RedisTemplate<String, Object> redisTemplate;
	
	@RequestMapping("/set")
	@ResponseBody
	public Object setRedis(@RequestParam("key") String key, @RequestParam("value") String value) {
		ValueOperations<String, Object> datas = redisTemplate.opsForValue();
		datas.set(key, value);
		return getRedis(key);
	}
	
	@RequestMapping("/get")
	@ResponseBody
	public Object getRedis(@RequestParam("key") String key) {
		ValueOperations<String, Object> datas = redisTemplate.opsForValue();
		return datas.get(key);
	}
	
}
